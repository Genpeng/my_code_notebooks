import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CodeCounter {
	public static CounterResult count(String directory) {
		CounterResult counterResult = new CounterResult();
		File file = new File(directory);
		if (!file.exists()) {
			System.out.println("No such file was found or the specified path name doesn't exist.");
		} else if (file.isFile()) {
			if (file.getName().matches("^.*\\.java$")) {
				counterResult = parseJavaFile(file, counterResult);
			} else if (file.getName().matches("^.*\\.c$")) {
				counterResult = parseCFile(file, counterResult);
			} else if (file.getName().matches("^.*\\.cpp$")) {
				counterResult = parseCppFile(file, counterResult);
			} else if (file.getName().matches("^.*\\.py$")) {
				counterResult = parsePythonFile(file, counterResult);
			} else {
				System.out.println("This is not a source code file.");
			}
		} else if (file.isDirectory()) {
			counterResult = parseFolder(file, counterResult);
		}
		return counterResult;
	}

	private static CounterResult parseJavaFile(File file, CounterResult counterResult) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			String line = "";
			boolean isComment = false;
			while ((line=br.readLine()) != null) {
				line = line.trim();
				if (line.matches("^[\\s&&[^\\n]]*")) { 
					/* 注意！readLine()得到的一行字符串已经没有换行符\n，
					   因此，正则表达式不应该以换行符\n结尾。*/
					counterResult.whiteLinesNumPlusOne();
				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
					counterResult.commentLinesNumPlusOne();
					isComment = true;
				} else if (isComment) {
					counterResult.commentLinesNumPlusOne();
					if (line.endsWith("*/")) {
						isComment = false;
					}
				} else if (line.startsWith("/*") && line.endsWith("*/")) {
					counterResult.commentLinesNumPlusOne();
				} else if (line.startsWith("//")) {
					counterResult.commentLinesNumPlusOne();
				} else {
					counterResult.normalLinesNumPlusOne();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return counterResult;
	}

	private static CounterResult parseCFile(File file, CounterResult counterResult) {
		return counterResult;
	}

	private static CounterResult parseCppFile(File file, CounterResult counterResult) {
		return counterResult;
	}

	private static CounterResult parsePythonFile(File file, CounterResult counterResult) {
		return counterResult;
	}

	private static CounterResult parseFolder(File file, CounterResult counterResult) {
		File[] filesArray = file.listFiles();
		if (0 != filesArray.length) {
			for (File f : filesArray) {
				if (f.isFile()) {
					if (f.getName().matches("^.*\\.java$")) {
						counterResult = parseJavaFile(f, counterResult);
					} else if (f.getName().matches("^.*\\.c$")) {
						counterResult = parseCFile(f, counterResult);
					} else if (f.getName().matches("^.*\\.cpp$")) {
						counterResult = parseCppFile(f, counterResult);
					} else if (f.getName().matches("^.*\\.py$")) {
						counterResult = parsePythonFile(f, counterResult);
					} else {
						System.out.println("This is not a source code file.");
					}
				} else {
					counterResult = parseFolder(f, counterResult);
				}
			}
		}
		return counterResult;
	}
}

class CounterResult {
	private long normalLinesNum;

	private long commentLinesNum;

	private long whiteLinesNum;

	public long getNormalLinesNum() {
		return normalLinesNum;
	}

	public void setNormalLinesNum(long normalLinesNum) {
		this.normalLinesNum = normalLinesNum;
	}

	public void normalLinesNumPlusOne() {
		normalLinesNum++;
	}

	public long getCommentLinesNum() {
		return commentLinesNum;
	}

	public void setCommentLinesNum(long commentLinesNum) {
		this.commentLinesNum = commentLinesNum;
	}

	public void commentLinesNumPlusOne() {
		commentLinesNum++;
	}

	public long getWhiteLinesNum() {
		return whiteLinesNum;
	}

	public void setWhiteLinesNum(long whiteLinesNum) {
		this.whiteLinesNum = whiteLinesNum;
	}

	public void whiteLinesNumPlusOne() {
		whiteLinesNum++;
	}

	@Override
	public String toString() {
		return "The number of normal lines is: " + normalLinesNum + "\n" + 
			   "The number of comment lines is: " + commentLinesNum + "\n" + 
			   "The number of white lines is: " + whiteLinesNum;
	}
}