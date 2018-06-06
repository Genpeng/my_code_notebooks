
import static com.datamole.learn.PrintHelper.*;

/**
 * 学习 Java static 关键字的四种用法
 * 参考博客：
 * 1. https://www.cnblogs.com/dotgua/p/6354151.html?utm_source=itdadao&utm_medium=referral
 * 
 * @author	Genpeng Xu
 * @date	2018/01/26
 */
public class LearnStatic {
	public static void main(String[] args) {
		/*
		作用1：修饰类的成员变量
		*/
//		Person p1 = new Person();
//		p1.name = "ZhangSan";
//		p1.age = 10;
//
//		Person p2 = new Person();
//		p2.name = "LiSi";
//		p2.age = 20;
//
//		System.out.println(p1);
//		System.out.println(p2);

		/*
		作用2：修饰类的方法
		*/

		/*
		作用3：静态块（☆☆☆☆☆）
		一些结论：
		1. 当new一个对象时，static修饰的成员变量首先被初始化，随后是普通成员，
		最后调用类的构造方法完成初始化；
		2. 当我们调用类的静态方法时，就会触发该类静态成员变量的初始化，并且
		静态成员只需要初始化一次即可，之后即使new该类的对象也不会再次初始化；
		*/
//		Library.add();
//		System.out.println("=========== 我是分割线 ===========");
//		Library l1 = new Library("p1对象的初始化");

//		Bookshelf.add();
//		System.out.println("=========== 我是分割线 ===========");
//		Bookshelf b1 = new Bookshelf("b1对象的初始化");

		/*
		作用4：静态导包
		在不与当前类的方法名冲突的情况下，无需使用“类名.方法名”的方法去调用
		类方法，直接采用“方法名”去调用类方法。
		*/
		print("Hello World!");
	}
}

class Person {
	String name;
//	int	   age;
	static int age;

	@Override
	public String toString() {
		return "Name: " + name + "\t" + "Age: " + age;
	}
}

class Book {
	public Book(String msg) {
		System.out.println(msg);
	}
}

class Library {
	Book		book1 = new Book("book1成员变量的初始化");
	static Book book2 = new Book("static: book2成员变量的初始化");

	public Library(String msg) {
		System.out.println(msg);
	}

	Book		book3 = new Book("book3成员变量的初始化");
	static Book book4 = new Book("static: book4成员变量的初始化");

	public static void add() {
		System.out.println("static修饰的方法（add）");
	}
}

class Bookshelf {
	Book		book1 = new Book("book1成员变量的初始化");
	static Book book2;

	static {
		book2 = new Book("static: book2成员变量的初始化");
		book4 = new Book("static: book4成员变量的初始化");
	}

	public Bookshelf(String msg) {
		System.out.println(msg);
	}

	Book		book3 = new Book("book3成员变量的初始化");
	static Book book4;

	public static void add() {
		System.out.println("静态方法（add）");
	}
}