package com.three60t.happycube.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * This class return all permutations of given elements. e.g. for elements {1, 2, 3, 4, 5, 6}
 * return 6! = 6*5*4*3*2*1 = 720 different states
 *
 * //todo This class must be changed, because I found it some months ago from web! .. So I have to write it myself...
 *
 * @author Hossein Moradi
 * @since 3/15/19
 */
public abstract class Permutations {

    public static <T> Stream<Stream<T>> of(final List<T> items) {
        return IntStream.range(0, factorial(items.size())).mapToObj(i -> permutation(i, items).stream());
    }

    private static int factorial(final int num) {
        return IntStream.rangeClosed(2, num).reduce(1, (x, y) -> x * y);
    }

    private static <T> List<T> permutation(final int count, final LinkedList<T> input, final List<T> output) {
        if (input.isEmpty()) {
            return output;
        }

        final int factorial = factorial(input.size() - 1);
        output.add(input.remove(count / factorial));
        return permutation(count % factorial, input, output);
    }

    private static <T> List<T> permutation(final int count, final List<T> items) {
        return permutation(count, new LinkedList<>(items), new ArrayList<>());
    }
}
