package ai.labrador.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 学习 Lambda 表达式之 Lambda 初体验
 * 来源：
 * 1. how2j (http://how2j.cn/k/lambda/lambda-lamdba-tutorials/697.html)
 *
 * @author  Genpeng Xu
 * @date    2018/05/28
 */
public class TestLambda1 {
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
        // 1. 使用普通方法
        filter(heros);
        // ================================================================ //

        // ================================================================ //
        // 2. 使用匿名类（Anonymous class）
        HeroChecker checker = new HeroChecker() {
            @Override
            public boolean test(Hero hero) {
                return (hero.hp > 100 && hero.damage < 50);
            }
        };
        filter(heros, checker);
        // ================================================================ //

        // ================================================================ //
        // 3. Lambda 表达式的形成过程
        HeroChecker c1 = new HeroChecker() {
            @Override
            public boolean test(Hero hero) {
                return (hero.hp > 100 && hero.damage < 50);
            }
        };

        // 去除 new HeroChecker() {}
        // 去除方法名和方法返回类型
        // 在参数和方法体之间加上符号 ->
        HeroChecker c2 = (Hero h) -> {
            return h.hp > 100 && h.damage < 50;
        };

        // 把 return 和 {} 去掉
        HeroChecker c3 = (Hero h) -> h.hp > 100 && h.damage < 50;

        // 把参数类型去掉
        HeroChecker c4 = h -> h.hp > 100 && h.damage < 50;

        // 把c4作为参数传递进去
        filter(heros, c4);

        // 直接把表达式传递进去
        filter(heros, h -> h.hp > 100 && h.damage < 50);
        // ================================================================ //
    }

    public static void filter(List<Hero> heros) {
        for (Hero hero : heros) {
            if (hero.hp > 100 && hero.damage < 50) {
                System.out.println(hero);
            }
        }
    }

    public static void filter(List<Hero> heros, HeroChecker checker) {
        for (Hero hero : heros) {
            if (checker.test(hero)) {
                System.out.println(hero);
            }
        }
    }
}
