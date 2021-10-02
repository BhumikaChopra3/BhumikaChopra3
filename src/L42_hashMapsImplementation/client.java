package L42_hashMapsImplementation;

public class client {
	
	public static void main(String[] args) {
		
		HashMap<String, Integer> map = new HashMap<>();
		//put
		map.put("A", 10);
		map.put("B", 15);
		map.put("C", 20);
		map.put("D", 25);
		map.put("E", 30);
		
		System.out.println(map);
		
		//get
		System.out.println(map.get("B"));  
		
		//containsKey
		System.out.println(map.containsKey("A"));
		
		//remove
		System.out.println(map.remove("C"));
		System.out.println(map);
		
		
		
	}

}
