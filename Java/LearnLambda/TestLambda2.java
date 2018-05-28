package ai.labrador.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 学习 Lambda 表达式之 Lambda 方法引用
 * 来源：
 * 1. how2j (http://how2j.cn/k/lambda/lambda-method-references/701.html#nowhere)
 *
 * @author  Genpeng Xu
 * @date    2018/05/28
 */
public class TestLambda2 {
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
        // 1. 引用静态方法

        // 使用匿名类
//        HeroChecker checker = new HeroChecker() {
//            @Override
//            public boolean test(Hero hero) {
//                return (hero.hp > 100 && hero.damage < 50);
//            }
//        };
//        filter(heros, checker);

        // 使用匿名表达式
//        filter(heros, h -> h.hp > 100 && h.damage < 50);

        // 在 Lambda 表达式中使用静态方法

        // ================================================================ //

        // ================================================================ //
        //

        // ================================================================ //

        // ================================================================ //
        //

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
