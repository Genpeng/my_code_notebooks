import java.lang.Math;

public class Point {
	private double x;

	private double y;

	private double z;

	Point() {}

	Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double calcDistance(Point p) {
		double distance = Math.sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y) + (z-p.z)*(z-p.z));
		return distance;
	}
}
