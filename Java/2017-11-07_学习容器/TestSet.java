package com.niuniu.set;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * 熟悉Set接口常用的方法以及如何遍历
 *
 * @author Genpeng Xu
 * @date 2017/11/07
 */
public class TestSet {
    public static void main(String[] args) {
        // new一个Set类型的对象
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("hello");
        System.out.println(set);

        // Set接口常用的方法
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add("a");
        s1.add("b");
        s1.add("c");
        s2.add("a");
        s2.add("b");
        s2.add("d");
        Set<String> sn = new HashSet<>(s1);
        sn.retainAll(s2);
        Set su = new HashSet<>(s1);
        su.addAll(s2);
        System.out.println(sn);
        System.out.println(su);

        // 3种遍历的方法
        // 1
        Iterator<String> i = set.iterator();
        while (i.hasNext()) {
            String str = i.next();
            System.out.println(str);
        }
        // 2
        for (Iterator<String> i=set.iterator(); i.hasNext(); ) {
            String str = i.next();
            System.out.println(str);
        }
        // 3
        for (String s : set) {
            System.out.println(s);
        }
    }
}
