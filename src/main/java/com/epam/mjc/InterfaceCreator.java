package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> strings.stream().allMatch(str -> str.matches("[A-Z][\\w-]*"));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            List<Integer> Values = integers.stream()
                    .filter(value -> value % 2 == 0)
                    .collect(Collectors.toList());
            integers.addAll(Values);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        values.removeIf(value -> !value.matches("^[A-Z].*\\.$") || value.split(" ").length <= 3);
        return () -> values;
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> strings.stream().collect(Collectors.toMap(str -> str, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (integers, integers2) -> {
            List<Integer> values = new ArrayList<>();
            values.addAll(integers);
            values.addAll(integers2);
            return values;
        };
    }
}
