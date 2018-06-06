import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * 学习正则表达式
 *
 * @author	Genpeng Xu
 * @date	2017/11/22
 */
class TestRegexp {
	public static void main(String[] args) {

		// Greedy quantifiers
		// X? - X, once or not at all
		// X* - X, zero or more times 
		// X+ - X, one or more times
//		System.out.println("a".matches(".")); // true
//		System.out.println("aa".matches("aa")); // true
//		System.out.println("aaaa".matches("a*")); // true
//		System.out.println("aaaa".matches("a+")); // true
//		System.out.println("".matches("a*")); // true
//		System.out.println("aaaa".matches("a?")); // false
//		System.out.println("".matches("a?")); // true
//		System.out.println("a".matches("a?")); // true
//		System.out.println("2145543433545".matches("\\d{3,100}")); // true
//		System.out.println("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")); // false
//		System.out.println("192".matches("[0-2][0-9][0-9]")); // true
		
		// Character classes
		// [abc]         - a, b, or c (simple class)
		// [^abc]        - Any character except a, b, or c (negation)
		// [a-zA-Z]      - a through z or A through Z, inclusive (range)
		// [a-d[m-p]]    - a through d, or m through p: [a-dm-p] (union)
		// [a-z&&[def]]  - d, e, or f (intersection)
		// [a-z&&[^bc]]  - a through z, except for b and c: [ad-z] (subtraction)
		// [a-z&&[^m-p]] - a through z, and not m through p: [a-lq-z] (subtraction)
//		System.out.println("a".matches("[abc]")); // true
//		System.out.println("a".matches("[^abc]")); // false
//		System.out.println("A".matches("[a-zA-Z]")); // true
//		System.out.println("A".matches("[a-z]|[A-Z]")); // true
//		System.out.println("A".matches("[a-z[A-Z]]")); // true
//		System.out.println("R".matches("[A-Z&&[RFG]]")); // true

		// Predefined character classes
		// . - Any character
		// \d - A digit: [0-9]
		// \D - A non-digit: [^0-9]
		// \s - A whitespace character: [ \t\n\x0B\f\r]
		// \S - A non-whitespace character: [^\s]
		// \w - A word character: [a-zA-Z_0-9]
		// \W - A non-word character: [^\w]
		// \
//		System.out.println(" \n\r\t".matches("\\s{4}")); // true
//		System.out.println(" ".matches("\\S")); // false
//		System.out.println("a_8".matches("\\w{3}")); // true
//		System.out.println("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+")); // true
//		System.out.println("\\".matches("\\\\")); // true

		// POSIX character classes (US-ASCII only)
//		System.out.println("a".matches("\\p{Lower}"));

		// Boundary matchers
		// ^  - The beginning of a line
		// $  - The end of a line
		// \b - A word boundary
		// \B - A non-word boundary
//		System.out.println("hello sir".matches("^h.*")); // true
//		System.out.println("hello sir".matches(".*ir$")); // true
//		System.out.println("hello sir".matches("^h[a-z]{1,3}o\\b.*")); // true
//		System.out.println("hellosir".matches("^h[a-z]{1,3}o\\b.*")); // false

		// white lines
//		System.out.println(" \n".matches("^[\\s&&[^\\n]]*\\n$"));

		// email
//		System.out.println("adfdfsfsdffdsf@dfdfdfdfd.com".matches("^[\\w[-.]]+@[\\w[-.]]+\\.[\\w]+"));

		/**
		 * find() - Attempts to find the next subsequence of the input sequence that matches the pattern.
		 *			尝试在目标字符串里查找下一个匹配子串。
		 * find(int start) - Resets this matcher and then attempts to find the next subsequence of the input sequence that
		 *					 matches the pattern, starting at the specified index.
		 *					 重设Matcher对象，并且尝试在目标字符串里从指定的位置开始查找下一个匹配的子串。
		 * matches() - Attempts to match the entire region against the pattern.
		 *			   尝试对整个目标字符展开匹配检测，也就是只有整个目标字符串完全匹配时才返回真值。
		 * lookingAt() - Attempts to match the input sequence, starting at the beginning of the region, against the pattern.
		 *				 检测目标字符串是否以匹配的子串起始。
		 * start() - Returns the start index of the previous match.
		 *			 返回当前查找所获子串的开始字符在原目标字符串中的位置。
		 * end() - Returns the offset after the last character matched.
		 *		   返回当前匹配的子串的最后一个字符在原目标字符串中的索引位置。
		 */
//		String s = "123-45678-978-00";
//		Pattern p = Pattern.compile("\\d{3,5}");
//		Matcher m = p.matcher(s);
//		System.out.println(m.matches());
//		m.reset();
//		System.out.println(m.find());
//		System.out.println(m.start() + "-" + m.end());
//		System.out.println(m.find());
//		System.out.println(m.start() + "-" + m.end());
//		System.out.println(m.find());
//		System.out.println(m.start() + "-" + m.end());
//		System.out.println(m.find());
//		System.out.println(m.lookingAt());
//		System.out.println(m.lookingAt());
//		System.out.println(m.lookingAt());
//		System.out.println(m.lookingAt());

		/**
		 * compile(String regex) - Compiles the given regular expression into a pattern.
		 *						   将给定的正则表达式编译并赋予给Pattern类。
		 * compile(String regex, int flags) - Compiles the given regular expression into a pattern with the given flags.
		 *								  同上，但增加flag参数的指定，可选的flag参数包括：CASE_INSENSITIVE、MULTILINE、
		 *									  DOTALL、UNICODE_CASE、CANON_EQ、UNIX_LINES、LITERAL、UNICODE_CHARACTER_CLASS和
		 *									  COMMENTS
		 * replaceAll(String replacement) - Replaces every subsequence of the input sequence that matches the pattern
		 *									with the given replacement string.
		 *								    将目标字符串里与既有模式相匹配的子串全部替换为指定的字符串。
		 * appendReplacement(StringBuffer sb, String replacement) - Implements a non-terminal append-and-replace step.
		 *															将当前匹配子串替换为指定字符串，并且将替换后的子串以及
		 *															其之前到上次匹配子串之后的字符串添加到一个StringBuffer对象里。
		 * appendTail(StringBuffer sb) - Implements a terminal append-and-replace step.
		 *								 将最后一次匹配工作后剩余的字符串添加到一个StringBuffer对象里。
		 */
		 Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		 Matcher m = p.matcher("java Java jAva jaVa javA I Love JAVA I hate Java sbsbsbsb");
//		 System.out.println(m.replaceAll("JAVA"));
//		 while (m.find()) {
//			System.out.println(m.group());
//		 }
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while (m.find()) {
			i++;
			if (i%2 == 0) {
				m.appendReplacement(sb, "java");
			} else {
				m.appendReplacement(sb, "JAVA");
			}
		}
		m.appendTail(sb);
		System.out.println(sb);

		/**
		 * group() - Returns the input subsequence matched by the previous match.
		 *			 返回当前查找而获得的与组匹配的所有子串内容。
		 * group(String name) - Returns the input subsequence captured by the given named-capturing group 
		 *						during the previous match operation.
		 *						返回当前查找而获得的与指定的组相匹配的子串内容。
		 */
//		String s = "123aa-34567bb-234cc-00";
//		Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");
//		Matcher m = p.matcher(s);
//		while (m.find()) {
//			System.out.println(m.group(1));
//		}

		/**
		 * Reluctant quantifiers
		 * X?? - X, once or not at all
		 * X*? - X, zero or more times
		 * X+? - X, one or more times
		 * X{n}? - X, exactly n times
		 * X{n,}? - X, at least n times
		 * X{n,m}? - X, at least n but not more than m times
		 *
		 * Possessive quantifiers
		 * Reluctant quantifiers
		 * X?+ - X, once or not at all
		 * X*+ - X, zero or more times
		 * X++ - X, one or more times
		 * X{n}+ - X, exactly n times
		 * X{n,}+ - X, at least n times
		 * X{n,m}+ - X, at least n but not more than m times
		 */
//		String s = "aaaa5bbbb6";
//		Pattern p = Pattern.compile("(.{1,10}+)[0-9]");
//		Matcher m = p.matcher(s);
//		if (m.find()) {
//			System.out.println(m.start() + "-" + m.end());
//		} else {
//			System.out.println("Not match!!!");
//		}
	}
}
