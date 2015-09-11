package com.hczhang.ia.p3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by steven on 9/11/15.
 */
public class Main {
    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));

        Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());


        inventory.sort(byWeight);

        inventory.sort(Comparator.comparing(Apple::getWeight));

        Predicate<Apple> redApple = apple -> "red".equals(apple.getColor());

        Function<Apple, Integer> myfunction = Apple::getWeight;

    }
}
