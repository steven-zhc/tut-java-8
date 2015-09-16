package com.hczhang.ia.p6;

import com.hczhang.ia.p4.CaloricLevel;
import com.hczhang.ia.p4.Dish;
import com.hczhang.ia.p4.Type;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Created by steven on 9/15/15.
 */
public class Main {
    public static void main(String[] args) {
        long howManyDishes = Dish.menu.stream()
                .collect(counting());

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish = Dish.menu.stream()
                .collect(maxBy(dishCaloriesComparator));

        int totalCalories = Dish.menu.stream().collect(summingInt(Dish::getCalories));

        IntSummaryStatistics menuStatistics = Dish.menu.stream()
                .collect(summarizingInt(Dish::getCalories));


        //

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu.stream()
                .collect(
                        groupingBy(
                                dish -> {
                                    if (dish.getCalories() <= 400) {
                                        return CaloricLevel.DIET;
                                    } else if (dish.getCalories() <= 700) {
                                        return CaloricLevel.NORMAL;
                                    } else {
                                        return CaloricLevel.FAT;
                                    }
                                }
                        )
                );

        Map<Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = Dish.menu.stream()
                .collect(
                        groupingBy(
                                Dish::getType,
                                groupingBy(
                                        dish -> {
                                            if (dish.getCalories() <= 400) {
                                                return CaloricLevel.DIET;
                                            } else if (dish.getCalories() <= 700) {
                                                return CaloricLevel.NORMAL;
                                            } else {
                                                return CaloricLevel.FAT;
                                            }
                                        }
                                )
                        )
                );


    }
}
