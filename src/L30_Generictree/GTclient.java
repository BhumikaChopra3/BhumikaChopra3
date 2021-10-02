package L30_Generictree;

public class GTclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericTree gt = new GenericTree();
		gt.display();

		// System.out.println(gt.size());
		// System.out.println(gt.max());
		// System.out.println(gt.ht());
		// System.out.println(gt.find(600));

		// gt.mirror(); 
		// gt.display();

		// gt.printAtLevel(1) ;

		// gt.linearize();
		// gt.display2();

		// gt.postorder();
		gt.levelorderLinewise();

	}

}
