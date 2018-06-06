import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
		// 按处理数据单位不同分为：字节流和字符流。
		// 按功能不同分为：节点流和处理流。
		// 所有流类型都位于java.io包内，继承自以下四种抽象流。
		// |        | 字节流       | 字符流 |
		// | ------ | ------------ | ------ |
		// | 输入流 | InputStream  | Reader |
		// | 输出流 | OutputStream | Writer |

		/*
		三、输入输出流
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

		// TestFileInputStream
//		String inPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\LearnIO.java";
//		FileInputStream in = null;
//		try {
//			in = new FileInputStream(inPath);
//
//			Long byteCounter = 0L;
//			int c;
//			while ((c=in.read()) != -1) { // read()方法会抛IOException
//				System.out.println((char) c);
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
		String inPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\LearnIO.java";
		String outPath = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\learn-io\\LearnIO1.java";

		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(inPath);
			out = new FileOutputStream(outPath);

			int c;
			while ((c=in.read()) != -1) { // read()方法会抛IOException
				out.write(c); // write()方法也会抛IOException
			}
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件！");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close(); // close()方法会抛IOException
				}

				if (out != null) {
					out.close(); // close()方法会抛IOException
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}