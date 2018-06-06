import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class EmailExtractor {
	public static void main(String[] args) {
		String in = "test1.html";
		String out = "result.txt";
		String encoding = "utf-8";

		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(in), encoding));
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(out), encoding));
			
			Pattern p = Pattern.compile("^[\\w[-.]]+@[\\w[-.]]+\\.[\\w]+");
			String l = reader.readLine();
			while (null != l) {
				Matcher m = p.matcher(l);
				while (m.find()) {
					writer.println(m.group());
				}
				l = reader.readLine();
			}

			writer.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
