package L4_arrays;

import java.util.Scanner;

public class f_c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner scn=new Scanner(System.in);
    
    int min=scn.nextInt();
    int max=scn.nextInt();
    int step=scn.nextInt();;

	
    for(double F=min;F<=max;F+=20)
    {
    	double C= (0.5556)*(F-32);
    	int c=(int) C;
    	int f=(int) F;
    	System.out.println(f+" "+c);
    	
    }
    
    	
	}

}
