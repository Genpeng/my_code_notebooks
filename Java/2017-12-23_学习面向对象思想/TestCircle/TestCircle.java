public class TestCircle {
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(1.0, 2.0), 2.0);
		Circle c2 = new Circle(5.0);
//		System.out.println(String.format("c1: (%f, %f), radius: %f", c1.getO().getX(), c1.getO().getY(), c1.getRadius()));
		System.out.format("c1: (%f, %f), radius: %f%n", c1.getO().getX(), c1.getO().getY(), c1.getRadius());
		System.out.format("c2: (%f, %f), radius: %f%n", c2.getO().getX(), c2.getO().getY(), c2.getRadius());
		System.out.println("c1 area = " + c1.area());
		System.out.println("c2 area = " + c2.area());

		c1.setO(5, 6);
		c2.setRadius(9.0);
		System.out.format("c1: (%f, %f), radius: %f%n", c1.getO().getX(), c1.getO().getY(), c1.getRadius());
		System.out.format("c2: (%f, %f), radius: %f%n", c2.getO().getX(), c2.getO().getY(), c2.getRadius());
		System.out.println("c1 area = " + c1.area());
		System.out.println("c2 area = " + c2.area());

		Point p1 = new Point(5.2, 6.3);
		System.out.println(c1.contains(p1));
		System.out.println(c1.contains(new Point(10.0, 9.0)));
	}
}
