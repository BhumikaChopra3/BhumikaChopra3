package L4_arrays;

import java.util.Scanner;

public class upper_lower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scn= new Scanner (System.in);
        
        char ch= scn.next().charAt(0);
        
        if(ch>='a'&& ch<='z')
        	System.out.println("lowercase");
        
        else if(ch>='A'&& ch<='Z')
        System.out.println("UPPERCASE");
        
        else
        	System.out.println("Invalid");
        
        
        
	}

}

//public static void main(String args[]) {
//    // Your Code Here
//   // Your Code Here
//    Scanner scn=new Scanner(System.in);
//    int er=scn.nextInt();
//    
//    printmaxPath_D(er,er,"");
//    System.out.println();
//    System.out.println(maxPath_D( er, er));
//}
//public static int maxPath_D( int er, int ec) {
//    int count=0;
//	if (er==1 && ec==1) {
//		
//		return 1;
//	}
//	if (er<0|| ec<0) {
//	
//		return 0;
//	}
//
//	count+= maxPath_D( er, ec-1);
//	
//	count+= maxPath_D( er-1, ec);
//    
//   
//    if(er==ec) {
//	 count+=maxPath_D( er-1, ec-1);
//
//		
//    }
//    return count;
//}
//
//public static void printmaxPath_D(int er,int ec,String ans) {
//	if (er==1 && ec==1) {
//		System.out.print(ans+" ");
//		return ;
//	}
//	if (er<0 || ec<0) {
//		
//		return ;
//	}
//    printmaxPath_D(er-1,ec,ans+"V");
//	printmaxPath_D(er,ec-1,ans+"H");
//    if(er==ec)
//	printmaxPath_D(er-1,ec-1,ans+"D");
//}
//}
//
//
