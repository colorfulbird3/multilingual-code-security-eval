```java
package com.example;

import java.util.*;
import java.util.stream.*;

public class UtilityClass {

    // Private constructor to prevent instantiation
    private UtilityClass() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    // Method to compute hash of a string
    public static int computeHash(String input) {
        if (input == null) {
            return 0;
        }
        return input.hashCode();
    }

    // Method to filter null or empty strings from a list
    public static List<String> filterNonNullNonEmpty(List<String> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toList());
    }

    // Method to join strings with a delimiter
    public static String joinStrings(List<String> list, String delimiter) {
        if (list == null || delimiter == null) {
            return "";
        }
        return list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.joining(delimiter));
    }

    // Method to find the longest string in a list
    public static Optional<String> findLongestString(List<String> list) {
        if (list == null || list.isEmpty()) {
            return Optional.empty();
        }
        return list.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(String::length));
    }

    // Method to convert a list of integers to a list of their string representations
    public static List<String> intListToStringList(List<Integer> intList) {
        if (intList == null) {
            return Collections.emptyList();
        }
        return intList.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    // Method to sum all integers in a list
    public static int sumIntegers(List<Integer> intList) {
        if (intList == null) {
            return 0;
        }
        return intList.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // Method to check if a list contains a specific element
    public static <T> boolean containsElement(List<T> list, T element) {
        if (list == null) {
            return false;
        }
        return list.stream()
                .anyMatch(e -> Objects.equals(e, element));
    }

    // Method to reverse a list
    public static <T> List<T> reverseList(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        List<T> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        return reversed;
    }

    // Method to remove duplicates from a list
    public static <T> List<T> removeDuplicates(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // Method to count occurrences of a specific element in a list
    public static <T> long countOccurrences(List<T> list, T element) {
        if (list == null) {
            return 0;
        }
        return list.stream()
                .filter(e -> Objects.equals(e, element))
                .count();
    }

    // Method to get the first non-null element from a list
    public static <T> Optional<T> firstNonNull(List<T> list) {
        if (list == null) {
            return Optional.empty();
        }
        return list.stream()
                .filter(Objects::nonNull)
                .findFirst();
    }

    // Method to check if all elements in a list satisfy a condition
    public static <T> boolean allMatch(List<T> list, java.util.function.Predicate<T> predicate) {
        if (list == null || predicate == null) {
            return false;
        }
        return list.stream()
                .allMatch(predicate);
    }

    // Method to check if any element in a list satisfies a condition
    public static <T> boolean anyMatch(List<T> list, java.util.function.Predicate<T> predicate) {
        if (list == null || predicate == null) {
            return false;
        }
        return list.stream()
                .anyMatch(predicate);
    }

    // Method to transform a list using a function
    public static <T, R> List<R> transformList(List<T> list, java.util.function.Function<T, R> function) {
        if (list == null || function == null) {
            return Collections.emptyList();
        }
        return list.stream()
                .filter(Objects::nonNull)
                .map(function)
                .collect(Collectors.toList());
    }

    // Method to partition a list into two lists based on a predicate
    public static <T> Map<Boolean, List<T>> partitionBy(List<T> list, java.util.function.Predicate<T> predicate) {
        if (list == null || predicate == null) {
            return new HashMap<>();
        }
        return list.stream()
                .collect(Collectors.partitioningBy(predicate));
    }

    // Method to group elements by a classifier function
    public static <T, K> Map<K, List<T>> groupBy(List<T> list, java.util.function.Function<T, K> classifier) {
        if (list == null || classifier == null) {
            return new HashMap<>();
        }
        return list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(classifier));
    }

    // Method to flatten a list of lists into a single list
    public static <T> List<T> flatten(List<List<T>> listOfLists) {
        if (listOfLists == null) {
            return Collections.emptyList();
        }
        return listOfLists.stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    // Method to get the most frequent element in a list
    public static <T> Optional<T> mostFrequent(List<T> list) {
        if (list == null || list.isEmpty()) {
            return Optional.empty();
        }
        return list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    // Method to shuffle a list randomly
    public static <T> List<T> shuffleList(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        List<T> shuffled = new ArrayList<>(list);
        Collections.shuffle(shuffled);
        return shuffled;
    }

    // Method to get a sublist from start index to end index
    public static <T> List<T> subList(List<T> list, int fromIndex, int toIndex) {
        if (list == null || fromIndex < 0 || toIndex > list.size() || fromIndex > toIndex) {
            return Collections.emptyList();
        }
        return new ArrayList<>(list.subList(fromIndex, toIndex));
    }

    // Method to check if a list is sorted in natural order
    public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
        if (list == null || list.size() <= 1) {
            return true;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    // Method to create a map from keys and values lists
    public static <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
        if (keys == null || values == null) {
            return new HashMap<>();
        }
        int size = Math.min(keys.size(), values.size());
        Map<K, V> map = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }

    // Method to get the median of a list of integers
    public static OptionalDouble median(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return OptionalDouble.empty();
        }
        List<Integer> sorted = list.stream()
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.toList());
        int size = sorted.size();
        if (size % 2 == 0) {
            return OptionalDouble.of((sorted.get(size / 2 - 1) + sorted.get(size / 2)) / 2.0);
        } else {
            return OptionalDouble.of(sorted.get(size / 2));
        }
    }

    // Method to get the mode of a list of integers
    public static Optional<Integer> mode(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return Optional.empty();
        }
        return list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    // Method to compute the factorial of a number
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        return LongStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }

    // Method to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to generate Fibonacci sequence up to n terms
    public static List<Long> fibonacci(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        List<Long> fib = new ArrayList<>();
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            fib.add(a);
            long temp = a + b;
            a = b;
            b = temp;
        }
        return fib;
    }

    // Method to compute the greatest common divisor (GCD)
    public static int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    // Method to compute the least common multiple (LCM)
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a * b) / gcd(a, b);
    }

    // Method to convert a string to title case
    public static String toTitleCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return Arrays.stream(input.split("\\s+"))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    // Method to count words in a string
    public static int wordCount(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        return input.trim().split("\\s+").length;
    }

    // Method to find the intersection of two lists
    public static <T> List<T> intersection(List<T> list1, List<T> list2) {
        if (list1 == null || list2 == null) {
            return Collections.emptyList();
        }
        Set<T> set2 = new HashSet<>(list2);
        return list1.stream()
                .filter(Objects::nonNull)
                .filter(set2::contains)
                .distinct()
                .collect(Collectors.toList());
    }

    // Method to find the union of two lists
    public static <T> List<T> union(List<T> list1, List<T> list2) {
        if (list1 == null && list2 == null) {
            return Collections.emptyList();
        }
        Set<T> set = new HashSet<>();
        if (list1 != null) {
            set.addAll(list1);
        }
        if (list2 != null) {
            set.addAll(list2);
        }
        return new ArrayList<>(set);
    }

    // Method to find the difference of two lists (elements in list1 but not in list2)
    public static <T> List<T> difference(List<T> list1, List<T> list2) {
        if (list1 == null) {
            return Collections.emptyList();
        }
        if (list2 == null) {
            return new ArrayList<>(list1);
        }
        Set<T> set2 = new HashSet<>(list2);
        return list1.stream()
                .filter(Objects::nonNull)
                .filter(e -> !set2.contains(e))
                .distinct()
                .collect(Collectors.toList());
    }

    // Method to check if two lists are equal ignoring order
    public static <T> boolean listEqualsIgnoreOrder(List<T> list1, List<T> list2) {
        if (list1 == null && list2 == null) {
            return true;
        }
        if (list1 == null || list2 == null) {
            return false;
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        Set<T> set1 = new HashSet<>(list1);
        Set<T> set2 = new HashSet<>(list2);
        return set1.equals(set2);
    }

    // Method to get a random element from a list
    public static <T> Optional<T> randomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            return Optional.empty();
        }
        Random random = new Random();
        return Optional.of(list.get(random.nextInt(list.size())));
    }

    // Method to create a list with n copies of a value
    public static <T> List<T> nCopies(int n, T value) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        return Collections.nCopies(n, value);
    }

    // Method to rotate a list by a given distance
    public static <T> List<T> rotateList(List<T> list, int distance) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        List<T> rotated = new ArrayList<>(list);
        Collections.rotate(rotated, distance);
        return rotated;
    }

    // Method to get the last element of a list
    public static <T> Optional<T> lastElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(list.get(list.size() - 1));
    }

    // Method to get the first element of a list
    public static <T> Optional<T> firstElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(list.get(0));
    }

    // Method to check if a list contains only unique elements
    public static <T> boolean allUnique(List<T> list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        Set<T> set = new HashSet<>(list);
        return set.size() == list.size();
    }

    // Method to find the index of the first occurrence of an element
    public static <T> int indexOf(List<T> list, T element) {
        if (list == null) {
            return -1;
        }
        return list.indexOf(element);
    }

    // Method to find the index of the last occurrence of an element
    public static <T> int lastIndexOf(List<T> list, T element) {
        if (list == null) {
            return -1;
        }
        return list.lastIndexOf(element);
    }

    // Method to swap two elements in a list
    public static <T> List<T> swap(List<T> list, int i, int j) {
        if (list == null || i < 0 || j < 0 || i >= list.size() || j >= list.size()) {
            return list;
        }
        List<T> swapped = new ArrayList<>(list);
        Collections.swap(swapped, i, j);
        return swapped;
    }

    // Method to fill a list with a specific value
    public static <T> List<T> fill(List<T> list, T value) {
        if (list == null) {
            return Collections.emptyList();
        }
        List<T> filled = new ArrayList<>(list);
        Collections.fill(filled, value);
        return filled;
    }

    // Method to find the minimum element in a list
    public static <T extends Comparable<T>> Optional<T> min(List<T> list) {
        if (list == null || list.isEmpty()) {
            return Optional.empty();
        }
        return list.stream()
                .filter(Objects::nonNull)
                .min(Comparator.naturalOrder());
    }

    // Method to find the maximum element in a list
    public static <T extends Comparable<T>> Optional<T> max(List<T> list) {
        if (list == null || list.isEmpty()) {
            return Optional.empty();
        }
        return list.stream()
                .filter(Objects::nonNull)
                .max(Comparator.naturalOrder());
    }

    // Method to compute the average of a list of integers
    public static OptionalDouble average(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return OptionalDouble.empty();
        }
        return list.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .average();
    }

    // Method to