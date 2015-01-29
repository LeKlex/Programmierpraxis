/**
 * Ein verschiebbares Dreieck.
 */
public class Triangle {
         
        private Point a;
        private Point b;
        private Point c;
         
        public Triangle(Point a, Point b, Point c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
		
		public Triangle(Triangle t) {
			this.a = new Point(t.a);
			this.b = new Point(t.b);
			this.c = new Point(t.c);
		}
         
        public void move(double x, double y) {
            a.move(x,y);
            b.move(x,y);
            c.move(x,y);
        }
         
        public String toString() {
            return a + "-" + b + "-" + c;
        }
         
}