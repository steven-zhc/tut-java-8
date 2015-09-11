package com.hczhang.ia.p3;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by steven on 9/11/15.
 */
public class Apple {
    private int weight = 0;
    private String color = "";

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("weight", weight)
                .append("color", color)
                .toString();
    }
}
