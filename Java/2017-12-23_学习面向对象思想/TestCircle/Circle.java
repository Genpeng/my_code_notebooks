import java.lang.Math;

class Circle {
	private Point  o;

	private double radius;

	Circle(double radius) {
		this.o = new Point(0.0, 0.0);
		this.radius = radius;
	}

	Circle(Point o, double radius) {
		this.o = o;
		this.radius = radius;
	}

	public Point getO() {
		return o;
	}

	public void setO(double x, double y) {
		o.setX(x);
		o.setY(y);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public boolean contains(Point p) {
		double xDifference = p.getX() - o.getX();
		double yDifference = p.getY() - o.getY();
		double distance = Math.sqrt(xDifference*xDifference - yDifference*yDifference);
		if (distance > radius) {
			return false;
		} else {
			return true;
		}
	}

	public double area() {
		return Math.PI * radius * radius;
	}
}
