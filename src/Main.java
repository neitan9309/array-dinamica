public class Main{
	
	public static void main(String[] args) {
		
		DynamicArray dynamicArray = new DynamicArray();
		
		dynamicArray.add("A");
		dynamicArray.add("B");
		dynamicArray.add("C");
		dynamicArray.add("D");
		dynamicArray.add("E");
		
		//dynamicArray.delete("");
		//dynamicArray.insert(0, "");
		
		System.out.println(dynamicArray);
		System.out.println("Tamanho: " + dynamicArray.size);
		System.out.println("Capacidade: " + dynamicArray.capacity);
		System.out.println("Vazio: " + dynamicArray.isEmpty());
	
		//dynamicArray.search("");
	}
}