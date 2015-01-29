/**
 * Ein verschiebbarer 2d-Punkt.
 */
public class Point {
         
        private double x;
        private double y;
		
		public Point(Point p) {
			this.x = p.x;
			this.y = p.y;
		}
         
        public Point(double x, double y) { 
            this.x = x;
            this.y = y;
        }
         
        public void move(double x, double y) {
            this.x += x;
            this.y += y;
        }
         
        public String toString() {
            return "(" + x +"," + y + ")";
        }
         
}