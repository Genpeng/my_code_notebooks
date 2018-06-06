public class TestPoint {
	public static void main(String[] args) {
		Point p1 = new Point(1.0, 2.0, 3.0);
		Point p2 = new Point(0.0, 0.0, 0.0);
		System.out.println(p1.calcDistance(p2));

		p1.setX(5.0);
		System.out.println(p1.calcDistance(new Point(0.0, 0.0, 0.0)));
	}
}