package L26_Inhertance;

import L25_dataStructures.stack;


public class dynamicStack extends stack{

	public void push(int item) throws Exception {

		if(isFull()) {

			// create  a new array of double size
			int[] na = new int[data.length * 2] ;

			// copy previous elements
			for(int i = 0 ; i < data.length ; i++) {
				na[i] = data[i] ;
			}

			// ref change
			data = na ;

		}

		super.push(item);

	}
}

