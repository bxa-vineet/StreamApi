package stream;
import java.util.*;
import java.util.stream.Collectors;

public class PracticeQues {
    public static void main(String[] args) {

        // 1️⃣ Print all elements of a list
        // Question: Print all elements of list [1, 20, 3, 4, 5]
        List<Integer> list = Arrays.asList(1, 20, 3, 4, 5);

        // Solution
        list.stream().forEach(System.out::println);

        // Output:
        // 1
        // 20
        // 3
        // 4
        // 5

        // ---------------------------------------------------

        // 2️⃣ Print even numbers
        // Question: Print only even numbers from the list
        list.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

        // Output:
        // 20
        // 4

        // ---------------------------------------------------

        // 3️⃣ Square of numbers
        // Question: Print square of each number
        list.stream()
                .map(x -> x * x)
                .forEach(System.out::println);

        // Output:
        // 1
        // 400
        // 9
        // 16
        // 25

        // ---------------------------------------------------

        // 4️⃣ Count elements
        // Question: Count total elements in the list
        long count = list.stream().count();
        System.out.println(count);

        // Output:
        // 5

        // ---------------------------------------------------

        // 5️⃣ Check if first element > 50
        // Question: Is first element greater than 50?
        boolean result = list.stream()
                .anyMatch(x -> x > 50);
        System.out.println(result);

        // Output:
        // false

        // ---------------------------------------------------

        // 6️⃣ Sum of numbers
        // Question: Sum of all numbers
        int sum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        // Output:
        // 33

        // ---------------------------------------------------

        // 7️⃣ Maximum number
        // Question: Maximum number in the list
        int max = list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
        System.out.println(max);

        // Output:
        // 20

        // ---------------------------------------------------

        // 8️⃣ Convert list of strings to uppercase
        // Question: Convert ["a","b","c"] to uppercase
        List<String> list2 = Arrays.asList("a", "b", "c");

        list2.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // Output:
        // A
        // B
        // C

        // ---------------------------------------------------

        // 9️⃣ Distinct elements
        // Question: Remove duplicates from [1, 2, 2, 3, 4, 1]
        List<Integer> list3 = Arrays.asList(1, 2, 2, 3, 4, 1);
        list3.stream()
                .distinct()
                .forEach(System.out::println);

        // Output:
        // 1
        // 2
        // 3
        // 4

        // ---------------------------------------------------

        // 10️⃣ Join list of strings with comma
        // Question: Join ["Java","Python","C++"] into single string
        List<String> langs = Arrays.asList("Java","Python","C++");
        String joined = langs.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joined);

        // Output:
        // Java, Python, C++

        // ---------------------------------------------------

        // 11️⃣ Count numbers > 10
        // Question: Count numbers greater than 10 in [5,15,25,3]
        List<Integer> nums = Arrays.asList(5, 15, 25, 3);
        long greaterThan10 = nums.stream()
                .filter(x -> x > 10)
                .count();
        System.out.println(greaterThan10);

        // Output:
        // 2

        // ---------------------------------------------------

        // 12️⃣ Convert list to set (remove duplicates)
        // Question: Convert [5,3,9,1,9,7] to LinkedHashSet to preserve order
        List<Integer> nums2 = Arrays.asList(5, 3, 9, 1, 9, 7);
        Set<Integer> set = nums2.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(set);

        // Output:
        // [5, 3, 9, 1, 7]

        // ---------------------------------------------------

        // 13️⃣ Partition numbers into even/odd
        // Question: Partition [1,2,3,4,5] into even and odd
        Map<Boolean, List<Integer>> partitioned = nums2.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(partitioned);

        // Output:
        // {false=[5, 3, 9, 1, 7], true=[]} (all odd in this example)

        // ---------------------------------------------------

        // 14️⃣ Frequency of elements
        // Question: Count frequency of ["a", "b", "c","b", "c"]
        List<String> list4 = Arrays.asList("a", "b", "c","b", "c");
        Map<String, Long> freq = list4.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(freq);

        // Output:
        // {a=1, b=2, c=2}

        // ---------------------------------------------------

        // 15️⃣ Flatten List of Lists
        // Question: Flatten [[1,2],[3,4],[5,6]] into single list
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> flattened = listOfLists.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println(flattened);

        // Output:
        // [1, 2, 3, 4, 5, 6]

        // ---------------------------------------------------

        // 16️⃣ Second highest number
        // Question: Find second highest in [5, 3, 9, 1, 9, 7]
        int secondHighest = nums2.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println(secondHighest);

        // Output:
        // 7

        // ---------------------------------------------------

        // 17️⃣ Find duplicate elements
        // Question: Find duplicates in [1, 2, 3, 2, 4, 1]
        List<Integer> list5 = Arrays.asList(1, 2, 3, 2, 4, 1);
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = list5.stream()
                .filter(x -> !seen.add(x))
                .distinct()
                .toList();
        System.out.println(duplicates);

        // Output:
        // [2, 1]

    }
}