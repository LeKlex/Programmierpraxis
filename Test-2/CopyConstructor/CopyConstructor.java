class CopyConstrutctor {
	
	public static void main(String[] args) {
		Point a = new Point(0,0);
		Point b = new Point(1,0);
		Point c = new Point(1,1);
 
 
		Triangle t1 = new Triangle(a, b, c);
 
		Triangle t2 = new Triangle(t1); //CHANGE TO DEEP COPY
 
		b.move(3,3);
 
		System.out.println(t1);
		System.out.println(t2);
 
		/* Erwarteter Output nach Umstellung auf tiefe Kopie:
		 *
		 * (0.0,0.0)-(4.0,3.0)-(1.0,1.0)
		 * (0.0,0.0)-(1.0,0.0)-(1.0,1.0)
		 */
	}
	
}