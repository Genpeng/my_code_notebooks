
interface Singer {
	void sing(); // default: public

	void sleep();
}

interface Painter {
	void paint();

	void eat();
}

class Student implements Singer {
	private String name;

	Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void sing() {
		System.out.println("Student is singing.");
	}

	@Override
	public void sleep() {
		System.out.println("Student is sleeping.");
	}
	
	public void study() {
		System.out.println("Studing is studying.");
	}
}

class Teacher implements Singer, Painter {
	private String name;

	Teacher(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void sing() {
		System.out.println("Teacher is singing.");
	}

	@Override
	public void sleep() {
		System.out.println("Teacher if sleeping.");
	}

	@Override
	public void paint() {
		System.out.println("Teacher is painting.");
	}

	@Override
	public void eat() {
		System.out.println("Teacher is eating.");
	}

	public void teach() {
		System.out.println("Teacher is teaching.");
	}
}

public class TestInterface {
	public static void main(String[] args) {
//		Singer s1 = new Student("le");
//		s1.sing();
//		s1.sleep();

		Singer s2 = new Teacher("steven");
		s2.sing();
		s2.sleep();
		
		Paint p1 = (Painter) s2;
		p1.paint();
		p1.eat();
	}
}