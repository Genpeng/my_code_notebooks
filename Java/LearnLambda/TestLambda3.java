package ai.labrador.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 学习 Lambda 表达式之 Lambda 聚合操作
 * 来源：
 * 1. how2j (http://how2j.cn/k/lambda/lambda-stream/700.html)
 *
 * @author  Genpeng Xu
 * @date    2018/05/28
 */
public class TestLambda3 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i=0; i<5; i++) {
            heros.add(new Hero("Hero" + i, random.nextInt(1000), random.nextInt(100)));
        }

        System.out.println("初始化后的英雄们：");
        for (Hero hero : heros) {
            System.out.println(hero);
        }

        System.out.println();
        System.out.println("=============================================");
        System.out.println("筛选出的英雄们：");

        // ================================================================ //
        // 1. 传统方式与聚合操作方式遍历数据


        // 传统方式遍历数据
//        long st = System.currentTimeMillis();
//        for (Hero h : heros) {
//            if (h.hp > 100 && h.damage < 50) {
//                System.out.println(h);
//            }
//        }
//        long et = System.currentTimeMillis();
//        System.out.println("Consumed time: " + (et - st) + " ms");

        // 聚合操作遍历数据
        long st = System.currentTimeMillis();
        heros.stream()
                .filter(h -> h.hp > 100 && h.damage < 50)
                .forEach(h -> System.out.println(h));
        long et = System.currentTimeMillis();
        System.out.println("Consumed time: " + (et - st) + " ms");

        // ================================================================ //

        // ================================================================ //
        //

        // ================================================================ //

        // ================================================================ //
        //

        // ================================================================ //
    }
}
