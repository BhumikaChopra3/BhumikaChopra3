package L2_Patterns;

public class pattern_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int rows=5;
   int i, j; 
   for (i=1; i<=rows; i++) 
   { 
       // Print trailing spaces 
       for (j=1; j<=rows - i; j++) 
           System.out.print(" "); 
          
       // Print stars after spaces 
       // Print stars for each solid rows 
       if (i==1 || i==rows) 
           for (j=1; j<=rows; j++) 
               System.out.print("*"); 
              
       // stars for hollow rows 
       else
           for (j=1; j<=rows; j++) 
               if (j==1 || j==rows) 
                   System.out.print("*"); 
               else
                   System.out.print(" "); 
       // Move to the next line/row 
       System.out.println(); 
   } 
} 
	}


