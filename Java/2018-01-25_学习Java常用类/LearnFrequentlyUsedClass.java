import static java.lang.Math.*;
import java.io.File;

/**
 * 学习马士兵《Java基础》第6章常用类
 * 
 * @author 	Genpeng Xu
 * @date	2018/01/25 ~ 2018/01/
 */
public class LearnFrequentlyUsedClass {
	private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String ARABIC_NUMBERS = "1234567890";


	public static void main(String[] args) {
		/*
		内容1：String和StringBuffer类
		*/
		// 1. String类
		// String s1 = "hello";
		// String s2 = "world";
		// String s3 = "hello";
		// System.out.println(s1 == s3); // true

		// String s4 = new String("hello");
		// String s5 = new String("hello");
		// System.out.println(s4 == s5); // false
		// System.out.println(s4.equals(s5)); // true

		// char[] c = {'s', 'u', 'n', ' ', 'j', 'a', 'v', 'a'};
		// String s6 = new String(c);
		// String s7 = new String(c, 4, 4);
		// System.out.println(s6);
		// System.out.println(s7);

		// 2. String类常用的方法
		// - charAt(...)
		// - length() 注：数组是用成员变量length记录长度，集合类用方法size()返回集合的元素个数
		// - indexOf(...)
		// - equalsIgnoreCase(...)
		// - replace(...)
		// String s1 = "sun java";
		// String s2 = "Sun Java";
		// System.out.println(s1.charAt(1)); // u
		// System.out.println(s2.length()); // 8
		// System.out.println(s1.indexOf("java")); // 4
		// System.out.println(s2.indexOf("Java")); // 4
		// System.out.println(s1.equalsIgnoreCase(s2)); // true

		// String s3 = "我是程序员，我在学java"; // java中的字符占两个字节（0~65535）
		// String s4 = s3.replace('我', '你');
		// System.out.println(s4);

		// - startsWith(...)
		// - endsWith(...)
		// - toUpperCase(...)
		// - toLowerCase(...)
		// - substring(...)
		// - trim()
		// String s1 = "Welcome to Java World!";
		// String s2 = "  sun java  ";
		// System.out.println(s1.startsWith("Welcome")); // true
		// System.out.println(s1.endsWith("World")); // false
		// String sL = s1.toLowerCase();
		// String sU = s1.toUpperCase();
		// System.out.println(sL);
		// System.out.println(sU);
		// String subStr1 = s1.substring(11); // Java World!
		// String subStr2 = s2.trim();
		// System.out.println(subStr1);
		// System.out.println(subStr2);

		// 疑问：当字符串是一个空格的时候，调用trim()方法的结果是什么？
		// 答案：空字符
		// String s = " ";
		// System.out.println("=" + s.trim() + "=");

		// 静态方法：
		// - String.valueOf(...)
		// int n = 1234567;
		// String s = String.valueOf(n);
		// System.out.println(n + " 是 " + s.length() + "位数。"); // 求整数位数的另一种方法

		// String s1 = "Mary,F,1976";
		// String[] s1Array = s1.split(",");
		// for (int i=0; i<s1Array.length; i++) {
		// 	System.out.println(s1Array[i]);
		// }

		// 3. 思考题
		// a. 编写一个程序，输出一个字符串中的大写英文字母数、小写英文字母数
		// 以及非英文字母数。
		// 解法1：
		// String s = "abcd1234ABCD,./!";
		// char c;
		// int lowerCaseNum = 0;
		// int upperCaseNum = 0;
		// int digitNum = 0;
		// int otherCharacterNum = 0;
		// for (int i=0; i<s.length(); i++) {
		// 	c = s.charAt(i);
		// 	if (LOWER_CASE.indexOf(c) != -1) {
		// 		lowerCaseNum++;
		// 	} else if (UPPER_CASE.indexOf(c) != -1) {
		// 		upperCaseNum++;
		// 	} else if (ARABIC_NUMBERS.indexOf(c) != -1) {
		// 		digitNum++;
		// 	} else {
		// 		otherCharacterNum++;
		// 	}
		// }
		// System.out.println(lowerCaseNum + "\t" + upperCaseNum + "\t" + digitNum + "\t" + otherCharacterNum);

		// 解法2：
		// String s = "abcd1234ABCD,./!";
		// char c;
		// int lowerCaseNum = 0;
		// int upperCaseNum = 0;
		// int digitNum = 0;
		// int otherCharacterNum = 0;
		// for (int i=0; i<s.length(); i++) {
		// 	c = s.charAt(i);
		// 	if (c >= 'a' && c <= 'z') {
		// 		lowerCaseNum++;
		// 	} else if (c >= 'A' && c <= 'Z') {
		// 		upperCaseNum++;
		// 	} else if (c >= '0' && c <= '9') {
		// 		digitNum++;
		// 	} else {
		// 		otherCharacterNum++;
		// 	}
		// }
		// System.out.println(lowerCaseNum + "\t" + upperCaseNum + "\t" + digitNum + "\t" + otherCharacterNum);

		// 解法3：
		// String s = "abcd1234ABCD,./!";
		// char c;
		// int lowerCaseNum = 0;
		// int upperCaseNum = 0;
		// int digitNum = 0;
		// int otherCharacterNum = 0;
		// for (int i=0; i<s.length(); i++) {
		// 	c = s.charAt(i);
		// 	if (Character.isLowerCase(c)) {
		// 		lowerCaseNum++;
		// 	} else if (Character.isUpperCase(c)) {
		// 		upperCaseNum++;
		// 	} else if (Character.isDigit(c)) {
		// 		digitNum++;
		// 	} else {
		// 		otherCharacterNum++;
		// 	}
		// }
		// System.out.println(lowerCaseNum + "\t" + upperCaseNum + "\t" + digitNum + "\t" + otherCharacterNum);

		// b. 编写一个方法，输出在一个字符串中，指定字符出现的次数。
		// String s = "javailovejavayoulovejavaohjava"; // 4次java
		// int n = findOccurrenceNum(s, "java");
		// System.out.println(n);

		// 4. StringBuffer类
		// 常用方法：
		// - append(...)
		// - insert(...)
		// - delete(...)
		// - reverse()

		// 与String类含义类似的方法：
		// - indexOf(...)
		// - substring(...)
		// - length()

		// String s = "Microsoft";
		// char[] c = {'a', 'b', 'c'};
		// StringBuffer sb1 = new StringBuffer(s);
		// sb1.append("/").append("IBM").append("/").append("Google");
		// System.out.println(sb1);

		// StringBuffer sb2 = new StringBuffer("数字");
		// for (int i=0; i<=9; i++) {
		// 	sb2.append(i);
		// }
		// System.out.println(sb2);
		// sb2.delete(8, sb2.length()).insert(0, c);
		// System.out.println(sb2);
		// System.out.println(sb2.reverse());

		/*
		内容2：基本数据类型包装类
		*/
		// Integer i = new Integer(100);
		// Double d = new Double("123.456");
		// int j = i.intValue() + d.intValue();
		// float f= i.floatValue() + d.floatValue();
		// System.out.println(j);
		// System.out.println(f);

		// double pi = Double.parseDouble("3.1415926");
		// double r = Double.valueOf("2.0").doubleValue();
		// double s = pi * r * r;
		// System.out.println(s);

		// try {
		// 	int k = Integer.parseInt("1.25");
		// } catch (NumberFormatException e) {
		// 	System.out.println("数据格式不对！");
		// }

		// System.out.println(Integer.toBinaryString(123) + "B");
		// System.out.println(Integer.toHexString(123) + "H");
		// System.out.println(Integer.toOctalString(123) + "O");

		/*
		思考题：
		编写一个方法，返回一个double类型的二维数组，数组中的元素通过
		解析字符串获得。
		e.g.：
		"1,2;3,4,5;6,7,8"
		对应的数组为：
		d[0, 0] = 1.0	d[0, 1] = 2.0
		d[1, 0] = 3.0	d[1, 1] = 4.0	d[1, 2] = 5.0
		d[2, 0] = 6.0	d[2, 1] = 7.0	d[2, 2] = 8.0
		*/
		// String s = "1,2;3,4,5;6,7,8";
		// double[][] doubleArray = parseStringToArray(s);
		// for (int i=0; i<doubleArray.length; i++) {
		// 	for (int j=0; j<doubleArray[i].length; j++) {
		// 		System.out.format("d[%d, %d] = %f\t", i, j, doubleArray[i][j]);
		// 	}
		// 	System.out.println();
		// }

		/*
		内容3：Math类
		备注：用了静态导包（直接调用方法名和，不用加Math类名）
		 */
		// double a = random();
		// double b = random();
		// System.out.println(sqrt(a*a + b*b));
		// System.out.println(pow(a, 8)); // a的8次幂
		// System.out.println(round(b)); // 四舍五入
		// System.out.println(log(pow(E, 15)));
		// double d = 60.0;
		// double r = PI / 4;
		// System.out.println(toRadians(d));
		// System.out.println(toDegrees(r));

		/*
		内容4：File类
		File类常用的构造方法：
		- public File(String pathname)
		- public File(String parent, String child)

		File类常用的方法：
		- public boolean canRead()
		- public boolean canWrite()
		- public boolean exists()
		- public boolean isDirectory()
		- public boolean isFile()
		- public boolean isHidden()

		- public long lastModified()
		- public long length()
		- public String getName()
		- public String getPath()

		通过File对象创建空文件或目录（在该对象所指的文件或目录不存在的情况下）
		- public boolean createNewFile() throws IOException
		- public boolean delete()
		- public boolean mkdir()
		- public boolean mkdirs()
		 */
		// String filename = "myfile.txt";
		// String directory = "mydir1" + File.separator + "mydir2";
		// File f = new File(directory, filename);
		// if (f.exists()) {
		// 	System.out.println("文件路径：" + f.getAbsolutePath());
		// 	System.out.println("文件名：" + f.getName());
		// 	System.out.println("文件大小：" + f.length());
		// } else {
		// 	f.getParentFile().mkdirs();
		// 	try {
		// 		f.createNewFile();
		// 	} catch (IOException e) {
		// 		e.printStackTrace();
		// 	}
		// }

		// 练习题：(☆☆☆☆☆)
		// 编写一个程序，在命令行中以树状结构展现特定的文件夹以及其子文件（夹）
		 String pathname = "D:\\MyData\\XUGP3\\Desktop\\2018-01-29_学习Java IO\\Writer";
		 File file = new File(pathname);
		 showAsTreeStructure(file, 0);
	
		/*
		内容5：枚举类
		 */
		// 后面用到的时候进行学习
	}

	private static int findOccurrenceNum(String str, String object) {
		int guidepost = 0, count = 0;
		while ((guidepost=str.indexOf(object)) != -1) {
			count++;
			str = str.substring(guidepost+object.length());
		}
		return count;
	}

	private static double[][] parseStringToArray(String s) {
		String[] firstArray = s.split(";");
		double[][] output = new double[firstArray.length][];
		for (int i=0; i<firstArray.length; i++) {
			String[] secondArray = firstArray[i].split(",");
			output[i] = new double[secondArray.length];
			for (int j=0; j<secondArray.length; j++) {
				output[i][j] = Double.parseDouble(secondArray[j]);
			}
		}
		return output;
	}

	private static void showAsTreeStructure(File file, int level) {
		if (file.isDirectory()) {
			// 如果是目录的话，首先判断目录是否为空
			File[] subfiles = file.listFiles();
			if (subfiles.length == 0) {
				// 如果为空，直接输出目录名
				System.out.println(createPreString(level) + file.getName());
			} else {
				// 如果不为空，首先输出目录名，再遍历每个子目录
				System.out.println(createPreString(level) + file.getName() + "/");
				for (int i=0; i<subfiles.length; i++) {
					showAsTreeStructure(subfiles[i], level+1);
				}
			}
		} else {
			// 如果是文件，直接输出
			System.out.println(createPreString(level) + file.getName());
		}
	}

	private static String createPreString(int level) {
		String preStr = "";
		for (int i=0; i<level; i++) {
			preStr += "|-- ";
		}
		return preStr;
	}
}