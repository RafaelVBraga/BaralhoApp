package objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import modelos.PilhaStream;
import utilidades.NaipesBaralho;


// Classe criada com propósitos educacionais, simulando um baralho com algumas funções básicas,
// utilizando stream para alguns métodos;
public class Baralho implements PilhaStream {
	//modelagem do deque de cartas utilizando um List
	private List<Carta> cartas;

	//Construtor do baralho: criará um baralho utilizando o parâmero 'quantidades_de_deques' para quantas
	//cartas sejam necessárias
	public Baralho(int quantidades_de_deques) {
		int numeroDeque = 1;
		this.cartas = new ArrayList<Carta>();		
		
		//para cada naipe, serão criadas 14 cartas, de A até o K
		for (NaipesBaralho naipe : NaipesBaralho.values()) {
			for (int valorAtual = 1; valorAtual < 14; valorAtual++) {
				//cria uma nova carta a cada iteração e depois são feitas as atribuições com seus "setter's"
				Carta carta = new Carta();
				carta.setDeque(String.valueOf(numeroDeque));
				switch (valorAtual) { //switch utilizado para diferenciar e inserir os valores diferentes de números
				case 1:
					carta.setNaipe(naipe.toString());
					carta.setValor("A");					
					break;
				case 11:
					carta.setNaipe(naipe.toString());
					carta.setValor("J");
					break;
				case 12:
					carta.setNaipe(naipe.toString());
					carta.setValor("Q");
					break;
				case 13:
					carta.setNaipe(naipe.toString());
					carta.setValor("K");
					break;
				default://se o valor for um número, somente converte para a string do referido número;
					carta.setNaipe(naipe.toString());					
					carta.setValor(String.valueOf(valorAtual));
					break;
				}
				this.cartas.add(carta);
			}
		}
		numeroDeque++;
		while(numeroDeque<=quantidades_de_deques) {
			List<Carta> novoDeque = new ArrayList<Carta>();
			String nDeque = String.valueOf(numeroDeque);
			this.cartas.stream().forEach(e -> novoDeque.add(new Carta(e.getNaipe(),e.getValor(),nDeque)));
			this.cartas.addAll(novoDeque);
			numeroDeque++;
		}
	}	

	@Override
	public void colocaItem(Object item) {
		
		List<Carta> auxiliar = new ArrayList<Carta>();
		auxiliar.add((Carta) item);
		//stream para percorrer as cartas do baralho e adicionar cada carta ao novo deque 
		//onde a carta inserida está na primeira posição ou seja no topo do baralho
		this.cartas.stream().forEach(e-> auxiliar.add(e));
		
		//por fim o baralho recebe o novo deque como suas cartas
		this.cartas = auxiliar;
		
	}

	@Override
	public Object retiraItem() {
		//utilizando o metodo skip() do stream, é retirado o elemento do topo do deque do baralho
		Carta carta = this.cartas.stream().limit(1).collect(Collectors.toList()).get(0);
		//atulizando o deque sem a carta retirada do topo
		this.cartas = this.cartas.stream().skip(1).collect(Collectors.toList());
		return carta;
	}

	public void exibeCartas() {
		//utilizando o método forEach() do stream para percorrer a lista e imprimir cada elemento
		this.cartas.stream().forEach(e -> System.out.println(e.toString()));
	}
	
	//método utilizado para embaralhar o baralho
	public void embaralhar() {		
		
		//utilizamos o objeto java.util.Random para gerar um número aleatório
		Random rand = new Random();
		List<Carta> embaralhado = new ArrayList<Carta>();
		
		
		//vai transferir cartas aleatórias do deque "cartas" para o deque "embaralhado" até 
		//o primeiro ficar sem nenhuma carta
		while (this.cartas.size() > 0) {
			// o número é gerado para ter um valor sempre entre 0 e o tamanho do baralho+1
			int x = rand.nextInt(this.cartas.size() + 1);
			//seleciona a carta a ser transferida para o deque "embaralhado"
			//no método skip() do stream é utilizado a condição para caso o valor seja 0, não seja selecionado
			//uma carta com index negativo( x > 0 ? x - 1 : x)
			Carta carta = this.cartas.stream().skip(x > 0 ? x - 1 : x).limit(1).collect(Collectors.toList()).get(0);
			//atualiza o deque retirando a carta selecionada
			this.cartas = this.cartas.stream().filter(e -> !e.toString().equals(carta.toString()))
					.collect(Collectors.toList());
			
			//adiciona a carta ao deque "embaralhado"
			embaralhado.add(carta);		
		}
		
		// por fim, o deque "cartas" está sem elementos e lhe é atribuído um novo valor que é o deque contendo
		// as cartas embaralhadas
		this.cartas = embaralhado;

	}
	
	// Método que retorna o número de cartas atuais no baralho;
	public long contar() {
		return this.cartas.stream().count();
	}

}
