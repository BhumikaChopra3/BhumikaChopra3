package L2_Patterns;

import java.util.Scanner;

public class pattern11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  
        Scanner scn = new Scanner(System.in);

        

        int n = scn.nextInt();
        
        
        
        for (int row = 1; row <= n; row++)
        {
            for (int col = 1; col <= row; col++)
            
                System.out.print(col+"\t");
            
           
            for (int col= row*2 ; col < n*2; col++) 
            
                System.out.print("\t"); 
            
            int col = row;
            if(row==n) {
            	col -=1;
            }
            for (; col >= 1; col--)
            
                System.out.print(col+"\t");
            
            System.out.println();
        }
        scn.close();
    }
	
}

	


