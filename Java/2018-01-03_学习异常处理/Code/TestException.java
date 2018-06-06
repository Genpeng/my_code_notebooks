import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestException {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		System.out.println(arr[4]);
//		System.out.println(2/0);

		// 特殊的Exception：RuntimeException（可以catch也可以不catch）
		// 备注：ArithmeticException是RuntimeException的子类
//		TestException te = new TestException();
//		te.m(0);
//		try {
//			new TestException().m(0);
//		} catch (ArithmeticException ae) {
//			ae.printStackTrace();
//			System.out.println("Error Found!!!");
//		}

		// 除了RuntimeException，其余继承Exception的类都需要catch
		// 比如下面的FileNotFoundException和IOException
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream(".//input//input.txt"); // 构造函数会抛出FileNotFoundException
//			int c;
//			while ((c=fis.read()) != -1) { // read()方法会抛出IOException
//				System.out.print((char) c);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				fis.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		// 测试如果是不是发生异常后，进行捕获就不再继续执行后面的try语句
		// 答案：会继续执行后面的try
//		try {
//			new TestException().m(0); // 发生异常，之后的语句不再执行
//			System.out.println("bla...bla...bla...");
//		} catch (ArithmeticException ae) {
//			ae.printStackTrace();
//			System.out.println("Error Found!!!");
//		}
//		try {
//			new TestException().m(0);
//			System.out.println("cla...cla...cla...");
//		} catch (ArithmeticException ae) {
//			ae.printStackTrace();
//			System.out.println("Error Found!!!");
//		}
		
		// 对于处理不了的异常就用关键字throws向外抛
//		try {
//			new TestException().method1();
//		} catch (ArithmeticException ae) {
//			ae.printStackTrace();
//		}
		
		
		
	}

	public void m(int i) throws ArithmeticException {
		if (0 == i) {
			throw new ArithmeticException("Divisor is zero!!!");
		}
	}

	public void method1() throws ArithmeticException {
		method2();
	}

	public void method2() throws ArithmeticException {
		method3();
	}

	public void method3() throws ArithmeticException {
		throw new ArithmeticException("别装大爷了，解决不了就抛吧！！！"); // 关键字throw
	}
}