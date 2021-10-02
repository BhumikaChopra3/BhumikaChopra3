import java.util.Scanner;

public class charcheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn=new Scanner (System.in);
		char ch=scn.next().charAt(0);
		
		if(ch>='a'&& ch<='z')
			System.out.println("lower");
		
		else if(ch>='A'&& ch<='Z')
			System.out.println("upper");
		else
			System.out.println("invalid");
		
		
		
		
	}

}
