package objetos;

public class Carta {

	
		private String naipe;
		private String valor;
		private String deque;
		
		public Carta() {}

		public Carta(String naipe, String valor, String deque) {
			super();
			this.naipe = naipe;
			this.valor = valor;
			this.deque = deque;
		}

		public String getNaipe() {
			return naipe;
		}

		public void setNaipe(String naipe) {
			this.naipe = naipe;
		}

		public String getValor() {
			return valor;
		}

		public void setValor(String valor) {
			this.valor = valor;
		}		

		public String getDeque() {
			return deque;
		}

		public void setDeque(String deque) {
			this.deque = deque;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((deque == null) ? 0 : deque.hashCode());
			result = prime * result + ((naipe == null) ? 0 : naipe.hashCode());
			result = prime * result + ((valor == null) ? 0 : valor.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Carta other = (Carta) obj;
			if (deque == null) {
				if (other.deque != null)
					return false;
			} else if (!deque.equals(other.deque))
				return false;
			if (naipe == null) {
				if (other.naipe != null)
					return false;
			} else if (!naipe.equals(other.naipe))
				return false;
			if (valor == null) {
				if (other.valor != null)
					return false;
			} else if (!valor.equals(other.valor))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Carta [naipe=" + naipe + ", valor=" + valor + ", deque=" + deque + "]";
		}

		
		
		
		
}
