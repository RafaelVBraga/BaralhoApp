package principal;

import objetos.Baralho;
import objetos.Carta;


/* Esta classe é somente para testes, a classe Baralho é independente desta*/ 
public class Principal {

	public static void main(String[] args) {
		
		Baralho baralho = new Baralho(2);	
		System.out.println(baralho.contar()+ " cartas");
		
		System.out.println("----------------Cartas originais ---------------------");
		baralho.exibeCartas();
		
		System.out.println("--------------- Cartas embaralhadas -------------------");		
		baralho.embaralhar();		
		baralho.exibeCartas();
		
		System.out.println("---------------- Carta retirada ------------------------");
		
		Carta carta = (Carta) baralho.retiraItem();
		
		System.out.println(carta.toString());
		
		System.out.println("---------------Cartas após a retirada -----------------------");
		
		baralho.exibeCartas();
		
		System.out.println("---------------- Carta colocada ------------------------");
		System.out.println(carta.toString());
		baralho.colocaItem(carta);
		
		System.out.println("---------------Cartas após a colocação da carta  -----------------------");
		
		baralho.exibeCartas();
		
		System.out.println(baralho.contar()+ " cartas");
		
	}

}
