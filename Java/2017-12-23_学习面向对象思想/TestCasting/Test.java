
class Animal {
	public String name;

	Animal(String name) {
		this.name = name;
	}
}

class Cat extends Animal {
	public String eyesColor;

	Cat(String name, String eyesColor) {
		super(name);
		this.eyesColor = eyesColor;
	}
}

class Dog extends Animal {
	public String furColor;

	Dog(String name, String furColor) {
		super(name);
		this.furColor = furColor;
	}
}

//public class Test {
//	public static void main(String[] args) {
//		Animal a = new Animal("a");
//		Cat c = new Cat("c", "blue");
//		Dog d = new Dog("d", "black");
//
////		System.out.println(a instanceof Animal);
////		System.out.println(c instanceof Animal);
////		System.out.println(d instanceof Animal);
////		System.out.println(a instanceof Cat);
//
//		a = new Dog("bigyellow", "yellow");
//		System.out.println(a.name);
////		System.out.println(a.furColor);
//		System.out.println(a instanceof Animal);
//		System.out.println(a instanceof Dog);
//
//		Dog d1 = (Dog) a; 
//		System.out.println(d1.furColor);
//	}
//}

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		Animal a = new Animal("a");
		Cat c = new Cat("c", "blue");
		Dog d = new Dog("d", "black");
		test.f(a);
		test.f(c);
		test.f(d);
	}

	public void f(Animal a) {
		System.out.println("name: " + a.name);
		if (a instanceof Cat) {
			Cat cat = (Cat) a;
			System.out.println("eyesColor: " + cat.eyesColor);
		} else if (a instanceof Dog) {
			Dog dog = (Dog) a;
			System.out.println("furColor: " + dog.furColor);
		}
	}
}