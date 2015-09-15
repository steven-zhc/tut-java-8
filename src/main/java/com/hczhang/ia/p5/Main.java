package com.hczhang.ia.p5;

import com.hczhang.ia.p4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by steven on 9/11/15.
 */
public class Main {
    public static void main(String[] args) {
        Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        List<Dish> dishes = Dish.menu
                .stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(3)
                .collect(Collectors.toList());


        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());


        List<String> steamOfWords = Dish.menu.stream()
                .map(dish -> dish.getName().split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly !!");
        }

        Optional<Dish> dish = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        dish.ifPresent(d -> System.out.println(d.getName()));

        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        IntStream ones = IntStream.generate(() -> 1);


        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int old = this.previous;
                int next = this.previous + this.current;
                this.previous = this.current;
                this.current = next;
                return old;
            }
        };

        IntStream.generate(fib).limit(10).forEach(System.out::println);


    }
}
