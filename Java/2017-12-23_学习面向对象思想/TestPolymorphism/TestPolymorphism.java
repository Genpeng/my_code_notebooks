abstract class Animal {
	private String name;

	Animal (String name) {
		this.name = name;
	}

	abstract public void enjoy();
}

class Cat extends Animal {
	private String eyesColor;

	Cat (String name, String eyesColor) {
		super(name);
		this.eyesColor = eyesColor;
	}

	@Override
	public void enjoy() {
		System.out.println("Mew...Mew...");
	}
}

class Dog extends Animal {
	private String furColor;

	Dog (String name, String furColor) {
		super(name);
		this.furColor = furColor;
	}

	@Override
	public void enjoy() {
		System.out.println("Woof...Woof...");
	}
}

class Bird extends Animal {
	private String featherColor;

	Bird (String name, String featherColor) {
		super(name);
		this.featherColor = featherColor;
	}

	@Override
	public void enjoy() {
		System.out.println("Bird sounds.");
	}
}

class Lady {
	private String name;

	private Animal pet;

	Lady (String name, Animal pet) {
		this.name = name;
		this.pet = pet;
	}

	public void myPetEnjoy() {
		pet.enjoy();
	}
}

public class TestPolymorphism {
	public static void main(String[] args) {
		Cat c = new Cat("catname", "blue");
		Dog d = new Dog("dogname", "black");
		Bird b = new Bird("birdname", "green");
		Lady l1 = new Lady("l1", c);
		Lady l2 = new Lady("l2", d);
		Lady l3 = new Lady("l3", b);
		l1.myPetEnjoy();
		l2.myPetEnjoy();
		l3.myPetEnjoy();
	}
}
