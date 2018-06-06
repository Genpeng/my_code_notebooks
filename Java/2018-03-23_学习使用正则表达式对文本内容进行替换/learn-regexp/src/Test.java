import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Map<String, String> tokens = new HashMap<String, String>(16);
        tokens.put("cat", "Garfield");
        tokens.put("beverage", "coffee");

		/*
		- compile(String regex)
		  Compiles the given regular expression into a pattern.
		  将给定的正则表达式编译并赋予给Pattern类。
		- compile(String regex, int flags)
		  Compiles the given regular expression into a pattern with the given flags.
		  同上，但增加flag参数的指定，可选的flag参数包括：CASE_INSENSITIVE、MULTILINE、DOTALL、UNICODE_CASE、
		  CANON_EQ、UNIX_LINES、LITERAL、UNICODE_CHARACTER_CLASS和COMMENTS
		- replaceAll(String replacement)
		  Replaces every subsequence of the input sequence that matches the pattern with the given replacement string.
		  将目标字符串里与既有模式相匹配的子串全部替换为指定的字符串。
		- appendReplacement(StringBuffer sb, String replacement)
		  Implements a non-terminal append-and-replace step.
		  将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串添加到一个StringBuffer对象里。
		- appendTail(StringBuffer sb)
		  Implements a terminal append-and-replace step.
		  将最后一次匹配工作后剩余的字符串添加到一个StringBuffer对象里。
		*/
        String s = "cat really needs some beverage";
        String patternStr = "(" + StringUtils.join(tokens.keySet(), "|") + ")";

        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(s);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, tokens.get(matcher.group(1)));
        }
        matcher.appendTail(sb);

        System.out.println(s);
        System.out.println(sb.toString());
    }
}