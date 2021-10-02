package L50_TrieHuffman;

public class client {

	public static void main(String[] args) {
		
	}
	
	public static int patternMatching(String srs, String patt) {
		
		for(int i = 0; i<= srs.length()- patt.length() ; i++) {
			
			int j = 0;
			while(j< patt.length()) {
				
				if(srs.charAt(i+j) != patt.charAt(j))
					break;
				
				j++;
			}
			
			if(j == patt.length())
				return i;
		}
		
		return -1;
	}
}
