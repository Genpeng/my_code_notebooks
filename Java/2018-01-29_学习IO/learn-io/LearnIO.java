import java.util.Date;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 学习Java IO
 *
 * @author	Genpeng Xu
 * @date	2018/01/30
 */
public class LearnIO {
	public static void main(String[] args) {
		/*
		一、Java流式输入/输出原理
		*/
		// File类封装的是文件的文件名，是内存中的一个对象。
		// 在Java程序中，对于数据的输入/输出操作是以流（stream）的方式实现的。

		/*
		二、Java流式的分类
		*/
		// 按数据流的方向不同分为：输入流和输出流。
		// 按处理数据单位不同分为：字节流和字符流（2个字节）。
		// 按功能不同分为：节点流（直接）和处理流（外面有包装）。
		// 所有流类型都位于java.io包内，继承自以下四种抽象流。
		// |        | 字节流       | 字符流 |
		// | ------ | ------------ | ------ |
		// | 输入流 | InputStream  | Reader |
		// | 输出流 | OutputStream | Writer |

		/*
		三、输入/输出流类
		*/
		// 这部分的图见笔记，下图带+号为处理流，不带+号为节点流。

		// InputStream/
		// |-- ByteArrayInputStream
		// |-- FileInputStream
		// |-- FilterInputStream (+)/
		// |-- |-- BufferedInputStream (+)
		// |-- |-- DataInputStream (+)
		// |-- |-- LineNumberInputStream (+)
		// |-- |-- PushbackInputStream (+)
		// |-- ObjectInputStream (+)
		// |-- PipedInputStream
		// |-- SequenceInputStream (+)
		// |-- StringBufferInputStream

		// InputStream基本的方法：
		// - public abstract int read() throws IOException
		// - public int read(byte[] b) throws IOException
		// - public int read(byte[] b, int off, int len) throws IOException
		// - public void close() throws IOException
		// - public long skip(long n) throws IOException
		
		// OutputStream/
		// |-- ByteArrayOutputStream
		// |-- FileOutputStream
		// |-- FilterOutputStream (+)/
		// |-- |-- BufferedOutputStream
		// |-- |-- DataOutputStream
		// |-- |-- PrintStream
		// |-- ObjectOutputStream (+)
		// |-- PipedOutputStream

		// OutputStream的基本方法：
		// - public abstract void write(int b) throws IOException
		// - public void write(byte[] b) throws IOException
		// - public void write(byte[] b, int off, int len) throws IOException
		// - public void flush() throws IOException
		// - public void close() throws IOException

		// Reader/
		// |-- BufferedReader (+)
		// |-- CharArrayReader
		// |-- FilterReader (+)/
		// |-- |-- PushbackReader (+)
		// |-- InputStreamReader (+)/
		// |-- |-- FileReader
		// |-- PipedReader
		// |-- StringReader

		// Reader的基本方法：
		// - public int read() throws IOException
		// - public int read(char[] cbuf) throws IOException
		// - public abstract int read(char[] cbuf, int off, int len) throws IOException
		// - public long skip(long n) throws IOException
		// - public abstract void close() throws IOException

		// Writer/
		// |-- BufferedWriter (+)
		// |-- CharArrayWriter
		// |-- FilterWriter (+)
		// |-- OutputStreamReader (+)/
		// |-- |-- FileWriter
		// |-- PipedWriter
		// |-- StringWriter

		// Writer的基本方法：
		// - public void write(int c) throws IOException
		// - public void write(char[] cbuf) throws IOException
		// - public abstract void write(char[] cbuf, int off, int len) throws IOException
		// - public void write(String str) throws IOException
		// - public void write(String str, int off, int len) throws IOException
		// - public abstract void flush() throws IOException
		// - public abstract void close() throws IOException

		/*
		四、常见的节点流和处理流
		*/
		// TestFileInputStream
//		String inPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\LearnIO.java";
//		FileInputStream in = null;
//		try {
//			in = new FileInputStream(inPath);
//
//			Long byteCounter = 0L;
//			int c;
//			while ((c=in.read()) != -1) { // read()方法会抛IOException
//				System.out.print((char) c);
//				byteCounter++;
//			}
//
//			System.out.println("读取的字节数：" + byteCounter);
//		} catch (FileNotFoundException e) {
//			System.out.println("找不到指定文件！");
//			System.exit(-1);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (in != null) {
//					in.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		// TestFileOutputStream
//		String inPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\LearnIO.java";
//		String outPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\LearnIO1.java";
//
//		FileInputStream in = null;
//		FileOutputStream out = null;
//		try {
//			in = new FileInputStream(inPath);
//			out = new FileOutputStream(outPath);
//
//			int c;
//			while ((c=in.read()) != -1) { // read()方法会抛IOException
//				out.write(c); // write()方法也会抛IOException
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("找不到指定文件！");
//			System.exit(-1);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (in != null) {
//					in.close(); // close()方法会抛IOException
//				}
//
//				if (out != null) {
//					out.close(); // close()方法会抛IOException
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		// TestFileReader
//		String inPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\LearnIO.java";
//
//		FileReader fr = null;
//		try {
//			fr = new FileReader(inPath);
//
//			int c;
//			while ((c=fr.read()) != -1) { // read()方法会抛IOException
//				System.out.print((char) c);
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("找不到指定文件！");
//			System.exit(-1);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (fr != null) {
//					fr.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		// TestFileWriter
//		String outPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\unicode.dat";
//
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter(outPath);
//		
//			for (int c=0; c<=50000; c++) {
//				fw.write(c);
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("找不到指定文件！");
//			System.exit(-1);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (fw != null) {
//					fw.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		/*
		五、文件流
		*/
		

		/*
		六、缓冲流
		*/
		// TestBufferStream1
//		String inPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\LearnIO.java";
//		String encoding = "utf-8";
//
//		BufferedInputStream bis = null;
//		try {
//			bis = new BufferedInputStream(new FileInputStream(inPath));
//
//			int c;
//			System.out.println(bis.read());
//			System.out.println(bis.read());
//
//			bis.mark(100);
//
//			for (int i=0; i<10; i++) {
//				if ((c=bis.read()) != -1) {
//					System.out.print(c + " ");
//				}
//			}
//			System.out.println();
//
//			bis.reset();
//
//			for (int i=0; i<10; i++) {
//				if ((c=bis.read()) != -1) {
//					System.out.print((char) c + " ");
//				}
//			}
//			System.out.println();
//		} catch (FileNotFoundException e) {
//			System.out.println("The file does not exit or the path is not correct!");
//			System.exit(-1);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (bis != null) {
//					bis.close();	
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		// TestBufferedStream2 (BufferedReader和BufferedWriter ☆☆☆☆☆)
//		String inPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\output.txt";
//		String outPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\output.txt";
//		String encoding = "utf-8";
//
//		BufferedReader br = null;
//		BufferedWriter bw = null;
//		try {
//			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath), encoding));
//			br = new BufferedReader(new InputStreamReader(new FileInputStream(inPath), encoding));
//			
//			String s = null;
//			for (int i=0; i<100; i++) {
//				s = String.valueOf(Math.random());
//				bw.write(s);
//				bw.newLine();
//			}
//			bw.flush();
//
//			while ((s=br.readLine()) != null) {
//				System.out.println(s);
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("The file does not exit or the path is correct!");
//			System.exit(-1);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (br != null) {
//					br.close();
//				}
//
//				if (bw != null) {
//					bw.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		/*
		七、数据流
		*/
//		try {
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			DataOutputStream out = new DataOutputStream(baos);
//			out.writeDouble(Math.random()); // throws IOException
//			out.writeBoolean(true); // throws IOException
//
//			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//			DataInputStream in = new DataInputStream(bais);
//			System.out.println(bais.available());
//			System.out.println(in.readDouble()); // throws IOException
//			System.out.println(in.readBoolean()); // throws IOException
//
//			in.close();
//			out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		/*
		八、转换流
		*/
//		// TestTransForm1.java
//		String outPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\output1.txt";
//		String encoding = "ISO8859_1";
//
//		OutputStreamWriter writer = null;
//		try {
//			writer = new OutputStreamWriter(new FileOutputStream(outPath));
//
//			writer.write("I Love China!");
//			System.out.println(writer.getEncoding());
//			writer.flush();
//			writer.close();
//
//			writer = new OutputStreamWriter(new FileOutputStream(outPath, true), encoding);
//			writer.write("I Love China!");
//			System.out.println(writer.getEncoding());
//			writer.flush();
//		} catch (FileNotFoundException e) {
//			System.out.println("The file does not exist or the path is not correct!");
//			System.exit(-1);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (writer != null) {
//					writer.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		// TestTransForm2.java
//		String encoding = "utf-8";
//
//		BufferedReader in = null;
//		try {
//			in = new BufferedReader(new InputStreamReader(System.in));
//
//			String s = null;
//			while ((s=in.readLine()) != null) {
//				if (s.equalsIgnoreCase("exit")) {
//					break;
//				} else {
//					System.out.println(s.toUpperCase());
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (in != null) {
//					in.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}		

		/*
		九、Print流
		*/
		// TestPrintStream1.java
//		String outPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\output2.txt";
//
//		PrintStream out = null;
//		try {
//			out = new PrintStream(new FileOutputStream(outPath));
//
//			if (out != null) {
//				System.setOut(out);
//			}
//
//			int count = 0;
//			for (char c=0; c<=60000; c++) {
//				System.out.print(c + " ");
//				if (count++ >= 100) {
//					System.out.println();
//					count = 0;
//				}
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("The file does not exist or the path is not correct!");
//			System.exit(-1);
//		} finally {
//			out.close();
//		}

		// TestPrintStream2.java
//		String filename = args[0];
//		if (filename != null) {
//			display(filename, System.out);
//		}

		// TestPrintStream3.java
//		String outPath = "./output4.txt";
//		String encoding = "utf-8";
//
//		BufferedReader in = null;
//		PrintWriter out = null;
//		try {
//			in = new BufferedReader(new InputStreamReader(System.in));
//			out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outPath, true), encoding));
//
//			String s = null;
//			while ((s=in.readLine()) != null) { // readLine()方法会抛IOException
//				if (s.equalsIgnoreCase("exit")) {
//					break;
//				} else {
//					System.out.println(s);
//					out.println(s);
//				}
//			}
//			System.out.println("====== " + new Date() + " ======");
//		} catch (FileNotFoundException e) {
//			System.out.println("The file does not exist or the path is not correct!");
//			System.exit(-1);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			out.close();
//			try {
//				if (in != null) {
//					in.close(); // BufferedReader的close()方法会抛IOException
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		/*
		十、Object流
		*/
		// TestObjectIO.java
		String outPath = "./object.dat";

		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(outPath));
			Pen myPen = new Pen(1, "black", 2.0);
			out.writeObject(myPen); // ObjectOutputStream类的writeObject()方法会抛IOException
			out.flush();

			in = new ObjectInputStream(new FileInputStream(outPath));
			Pen penReaded = (Pen) in.readObject(); // ObjectInputStream类的readObject()方法会抛IOException和ClassNotFoundException
			System.out.println(penReaded.id + " " + penReaded.color + " " + penReaded.price);
		} catch (FileNotFoundException e) {
			System.out.println("The file does not exist or the path is not correct!");
			System.exit(-1);
		} catch (ClassNotFoundException e) {
			System.out.println("Could not found the class!");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}

				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void display(String filename, PrintStream out) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "utf-8"));

			String s = null;
			while ((s=in.readLine()) != null) { // readLine()方法会抛IOException
				out.println(s);
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file does not exist or the path is not correct!");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class Pen implements Serializable { // Serializable接口的作用是标志这个类可以被序列化
	int	   id;
	String color;
	double price;

	Pen(int id, String color, double price) {
		this.id = id;
		this.color = color;
		this.price = price;
	}
}