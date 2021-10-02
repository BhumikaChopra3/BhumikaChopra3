package L2_Patterns;

import java.util.Scanner;

public class hollowdiamond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		for (int row = 0; row < n; row++) {
			for (int j = 0; j < n-1; j++)

			{
				if (j < n - row)
					System.out.print("*");
				else

					System.out.print(" ");

			}
			for (int j = 0; j < n; j++)

			{

				if (j < row)
					System.out.print(" ");
				else

					System.out.print("*");
			}

			System.out.println();

		} //
		for (int row = 2; row <= n; row++) {
			for (int j = 0; j < n-1; j++)

			{
				if (j < row)
					System.out.print("*");
				else

					System.out.print(" ");

			}
			for (int j = 0; j < n; j++)

			{

				if (j < n - row)
					System.out.print(" ");
				else

					System.out.print("*");
			}

			System.out.println();

		}

	}
}
