package com.hczhang.ia.p5;

import com.hczhang.ia.p4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


    }
}
