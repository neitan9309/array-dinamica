 /*
 Créditos para o dono do canal "Bro Code", que eu sempre recorro para procurar meus cursos (gratuitos) de programação.
 Link para o vídeo sobre estrutura de dados e algorítmos: https://youtu.be/CBYHwZcbD-s?si=NSHDQx0HUmC6M3XZ
 */
public class DynamicArray {
	
	 /*
	 Configuração padrão da array. Inclui uma variável para o
	 tamanho da array, sua capacidade total e a criação de um
	 objeto do tipo "array", classe que possui vários métodos.
	 */
	int size;
	int capacity = 5;
	Object[] array;

	//Método público para definir a array, também definimos sua capacidade total com a variável "capacity".
	public DynamicArray() {
		this.array = new Object [capacity];
	}
	
	 /*
	 Esse trecho tem como função fornecer uma ferramenta para que o usuário defina
	 a capacidade de acordo com suas necessidades. Atualiza-se a capacidade de acordo
	 com a entrada (número inteiro) do usuário no argumento do método. 
	 */
	public DynamicArray(int capacidade) {
		this.capacity = capacidade;
		this.array = new Object [capacidade];
	}
	
	//Método para que o usuário faça a adição de um novo dado no fim da array.
	public void add(Object data) {
		
		if(size >= capacity) {//Condicional que busca o método grow caso o tamanho da array ultrapasse seu limite.
			grow();
		}
		array[size] = data;
		size++;//Atualiza o dado que leva a informação do tamanho.
	}
	
	//Método que permite o usuário inserir um dado na posição (index) desejada.
	public void insert(int index, Object data) {
		
		if(size >= capacity) {//Condicional que busca o método grow caso o tamanho da array ultrapasse seu limite.
			grow();
		}
		 /*
		 Loop do tipo "for" que percorre a array (da direita para a esquerda)
		 enquanto tiver elementos antes da posição fornecida pelo usuário.
		 */
		for(int i = size; i > index; i--) {
			 /*
			 Esse trecho irá atualizar o dado da posição atual, acessada
			 pelo loop for, com o dado da posição antereior, o que em suma
			 "move" para a direita todos os dados que sucedem o dado alterado.
			 */
			array[i] = array[i - 1];
		}
		array[index] = data;//Atualiza o elemento da posição desejada.
		size++;
	}
	
	//Método que permite o usuário deletar um dado específico da array.
	public void delete(Object data) {
		
		//Laço for simples, que irá percorrer os dados da esquerda para a direita.
		for(int i = 0; i < size; i++) {
			//Condição que identifica o dado fornecido na array.
			if(array[i] == data) {
				 /*
				 Loop for ativado com a condição anterior. O trecho (size - i - 1)
				 e o elemento j servem, respectivamente, para: Identificar a quantidade
				 de dados que sucedem a posição i e para controlar a quantidade total
				 de mudanças nos elementos, que serão "movidos" para a esquerda.
				 */
				for(int j = 0; j < (size - i - 1); j++) {
					 /*
					 Trecho que atualiza o dado das posições que nos importam, ele é
					 responsável por "mover" (leia-se copiar) os dados para a esquerda,
					 começando a atualização pelo dado que o usuário resolver excluir
					 */
					array[i + j] = array[i + j + 1];
				}
				 /*
				 descarta o último elemento da array, dado que aparece
				 repetido, já que ele foi copiado para a posição anterior.
				 */
				array[size - 1] = null;
				size--;//Diminui a variável que leva a informação do tamanho ocupado na array.
				 /*
				 Condicional que chama o método shrink caso o tamanho
				 ocupado da array seja menor que 1/3 da sua capacidade total.
				 */
				if(size <= (int) (capacity/3)) {
					shrink();
				}
				break;
			}
		}
	}
	
	//Pesquisa simples e unidimensional por elementos na array.
	public int search(Object data) {
		
		//Loop simples que percorre a array da esquerda para a direita.
		for (int i = 0; i < capacity; i++) {
			if(array[i] == data) {
				System.out.println("Resultado da procura: " + i);//O valor do index (i) do elemento é imprimido na tela do usuário.
			}
		}
		return -1;//Retorna o valor -1 caso o elemento que interessa o usuário não seja encontrado.
	}
	
	 /*
	 Método responsável por expandir a array para o dobro de sua
	 capacidade inicial. O método é ativado caso a capacidade máxima
	 da array seja ultrapassada, e os métodos add e insert podem nos
	 levar à essas situações, então neles configurei um condicional if
	 que checa a necessidade da chamada desse método.
	 */
	private void grow() {
		
		int newCapacity = (int)(capacity * 2);//Variável que armazena a infomação da nova capacidade da array.
		Object[] newArray = new Object[newCapacity];//Criação de um novo objeto do tipo array com a capacidade atualizada.
		
		for(int i = 0; i < size; i++) {//Loop for que copia, um por um, os elementos da antiga array para a nova.
			newArray[i] = array [i];
		}
		capacity = newCapacity;//Atualiza a variável que leva a informação da capacidade.
		array = newArray;//Atualiza a array principal, que agora tem uma capacidade 2x maior que a original.
	}
	
	 /*
	 Método que diminui a capacidade da array para sua metade. A lógica é a mesma do
	 método grow, com a diferença que o shrink é chamado caso uma certa quantidade de
	 elementos seja deletado da array, diminuindo-a para 1/3 de sua capacidade total.
	 */
	private void shrink() {

		int newCapacity = (int)(capacity / 2);
		Object[] newArray = new Object[newCapacity];
		
		for(int i = 0; i < size; i++) {
			newArray[i] = array [i];
		}
		capacity = newCapacity;
		array = newArray;
	}
	
	//Método simples que nos informa se a array tem algum elemento.
	public boolean isEmpty() {
		return size == 0;
	}
	
	//Método para configurar o formato da array, adicionando colchetes no começo e fim do grupo e vírgulas entre os elementos.
	public String toString() {
		
		String string = "";
		
		//Loop que adiciona uma vírgula e um espaço à direita de cada elemento que temos na array.
		for(int i = 0; i < capacity; i++) {
			string += array[i] + ", ";
		}
		//Esse trecho exclcui as duas últimas caracteres ", " aplicadas no loop anterior, também adiciona-se os colchetes.
		if(string != "") {
			string = "[" + string.substring(0, string.length() -2) + "]";
		}
		else {
			return "[]";//Para caso a array esteja vazia.
		}
		return string;//Responsável pela impressão da array formatada na tela do usuário.
	}
}
