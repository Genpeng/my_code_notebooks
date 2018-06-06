
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

/**
 * 熟悉Map接口常用的方法以及如何遍历
 * 
 * @author Genpeng Xu
 * @date 2017/11/7
 */
public class TestMap {
	public static void main(String[] args) {
		Map<String, Integer> m1 = new HashMap<>(16); 
		Map<String, Integer> m2 = new HashMap<>(16);

		// Map接口的常用方法
		// -------------------------------------------------------------------------
		m1.put("one", 1);
		m1.put("two", 2);
		m1.put("three", 3);
		m2.put("A", 1);
		m2.put("B", 2);

		System.out.println(m1.size());
		System.out.println(m2.size());
		System.out.println(m1.containsKey("one"));
		System.out.println(m2.containsValue(1));

		if (m1.containsKey("two")) {
			int i = m1.get("two");
		}

		Map<String, Integer> m3 = new HashMap<>(m1);
		m3.putAll(m2);
		System.out.println(m3);
		// -------------------------------------------------------------------------

		// 4种遍历的方法
		// -------------------------------------------------------------------------
		// 1. 获取所有的key，按照key进行遍历
		Set<String> keys = m1.keySet();
		for (String key : keys) {
			int value = m1.get(key);
			System.out.println(value);
		}

		// 2. 通过Map.entrySet使用iterator遍历key和value
		Iterator<Map.Entry<String, Integer>> iterator = m1.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			System.out.println("key = " + entry.getKey() + "\t" +
							   "value = " + entry.getValue());
		}

		// 3. 通过Map.entrySet遍历key和value
		for (Map.Entry<String, Integer> entry : m1.entrySet()) {
			System.out.println("key = " + entry.getKey() + "\t" +
							   "value = " + entry.getValue());
		}

		// 4. 通过Map.values()遍历所有的value，但是不能遍历key
		for (Integer v : m1.values()) {
			System.out.println("value = " + v);
		}
		// -------------------------------------------------------------------------
	}
}