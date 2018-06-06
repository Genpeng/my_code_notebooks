//import java.io.File;

public class TestCodeCounter {
	public static void main(String[] args) {
		String directory = "D:\\MyData\\XUGP3\\Desktop\\LearnJava\\CodeNotes\\2017-11-22_学习正则表达式\\Test";
		CounterResult counterResult = CodeCounter.count(directory);
		System.out.println(counterResult);
//		File file = new File(directory);
//		File[] filesArray = file.listFiles();
//		if (filesArray == null) {
//			System.out.println("111111");
//		} else {
//			System.out.println("222222");
//			System.out.println(filesArray.length);
//			for (File f : filesArray) {
//				System.out.println(f.getName());
//			}
//		}
	}
}
