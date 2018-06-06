
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

/**
 * 熟悉List接口的常用方法、如何遍历以及常用的排序算法
 *
 * @author Genpeng Xu
 * @date 2017/11/07
 */
public class TestList {
    public static void main(String[] args) {
        // new一个List类型的对象（父类引用指向子类对象）
        List<String> list = new LinkedList<>();
        int listLength = 5;
        for (int i=0; i<=listLength; i++) {
            list.add("a"+i);
        }
        System.out.println(list);

        // 常用的方法
		// -------------------------------------------------------------------------
        list.add(3, "a100");
        System.out.println(list);
        list.set(6, "a200");
        System.out.println(list);
        System.out.print(list.get(2) + " ");
        System.out.println(list.indexOf("a3"));
        list.remove(1);
        System.out.println(list);
		// -------------------------------------------------------------------------

        // 4种遍历方法
		// -------------------------------------------------------------------------
        // 1
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        // 2
        for (String s : list) {
            System.out.println(s);
        }
        // 3
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = (String)iterator.next();
            System.out.println(s);
        }
        // 4
        for (Iterator i=list.iterator(); i.hasNext(); ) {
            String s = (String)i.next();
            System.out.println(s);
        }
		// -------------------------------------------------------------------------

        // List常用的算法
		// -------------------------------------------------------------------------
        Collections.shuffle(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(Collections.binarySearch(list, "a5"));
		// -------------------------------------------------------------------------
    }
}
