package L2_Patterns;

public class patern {
	public static void main(String[] args) {

//		int totalno = 1;
//		int n = 3;
//		int row = 1;
//		while (row <= n) {
//
//			int c = 1;
//			int count = row;
//			while (c <= totalno) {
//				System.out.print(count);
//				count++;
//				c++;
//			}
//
//			System.out.println();
//			totalno++;
//			row++;
//		}

		patternAlpha();
	}

	public static void pattern4() {

		int n = 4;
		int nsp = n - 1;
		int totalno = 1;
		int row = 1;

		while (row <= n) {

			// space work
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			// number work
			int c = 1;
			int count = row;
			while (c <= totalno) {
				System.out.print(count);
				count++;
				c++;
			}

			System.out.println();
			nsp--;
			totalno++;
			row++;

		}
	}

	public static void patternAlpha() {
		
		int alpha = 64;
		int i, j;
		int n = 5;

		for(i=n; i>=1; i--){
			  for(j=i; j<=n; j++){
				System.out.print((char)(alpha + j) + " ");
			}
			System.out.println();
		}
	}
}
