/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		double x1 = 0.0, y1 = 0.0;
        double x2 = 1.0, y2 = 0.0;
        double x3 = 0.5, y3 = Math.sqrt(3) / 2.0;

    
        sierpinski(n, x1, x2, x3, y1, y2, y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n == 0) {
        
        double[] x = {x1, x2, x3};
        double[] y = {y1, y2, y3};
        StdDraw.polygon(x, y);
    } 
	else {
     
        double x12 = (x1 + x2) / 2.0;
        double y12 = (y1 + y2) / 2.0;
        
        double x23 = (x2 + x3) / 2.0;
        double y23 = (y2 + y3) / 2.0;
        
        double x31 = (x3 + x1) / 2.0;
        double y31 = (y3 + y1) / 2.0;

        sierpinski(n - 1, x1, x12, x31, y1, y12, y31);  // משולש פינה שמאלית
        sierpinski(n - 1, x12, x2, x23, y12, y2, y23);  // משולש פינה ימנית
        sierpinski(n - 1, x31, x23, x3, y31, y23, y3);  // משולש פינה עליונה
    }
}
}