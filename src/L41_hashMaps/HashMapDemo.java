package L41_hashMaps;

import java.util.HashMap;

import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {

//		HashMap<String, Integer> map = new HashMap<>() ;
//		
//		//put
//		map.put("A", 10);
//		map.put("B", 15);
//		map.put("C", 20);
//		map.put("D", 25);
//		map.put("E", 30);
//		
//		System.out.println(map);
//		
//		//get
//		System.out.println(map.get("B"));  
//		
//		//containsKey
//		System.out.println(map.containsKey("A"));
//		
//		//remove
//		System.out.println(map.remove("C"));
//		System.out.println(map);
//		
//		//keys obtain
//		Set<String> keys = map.keySet();
//		for(String key: keys) 
//			System.out.println(key);

		int[] one = { 20, 30, 20, 50, 70, 30, 50 };
		int[] two = { 20, 70, 30, 80 };

		intersection(one, two);

	}

	public static void intersection(int[] one, int[] two) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int key : one) {

//			if(map.containsKey(key)) {
//				int of = map.get(key);
//				int nf = of+1;
//				map.put(key, nf);
//			}
//			else
//				map.put(key,1); 

			map.put(key, map.getOrDefault(key, 0) + 1);

		}
		System.out.println(map);

		for (int key : two) {

			if (map.containsKey(key) && map.get(key) > 0) {
				System.out.println(key);
				map.put(key, map.get(key) - 1);
			}

		}

	}

	public static void consectiveNumbers(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int key : arr) {

			if (map.containsKey(key - 1))
				map.put(key, false);

			else
				map.put(key, true);

			if (map.containsKey(key + 1))
				map.put(key + 1, false);
		}

		int max = 0;
		int sp = 0;

		for (int key : map.keySet()) {

			if (map.get(key)) {
				int count = 0;
				while (map.containsKey(key + count))
					count++;

				if (count > max) {
					max = count;
					sp = key;
				}

			}
		}

		for (int i = sp; i < sp + max; i++) {
			System.out.println(i);
		}
	}

}
 