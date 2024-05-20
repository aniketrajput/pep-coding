package com.home.programs;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;
import static java.util.List.of;
import static java.util.stream.Collectors.*;

public class Java_8_Syntax {

    public static void calculatePersonAgeInYear() {
        LocalDate birthDate = LocalDate.of(1998, 8, 17);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();
        System.out.println("Age of the person is: " + age);
    }

    public static void lastElementInTheArray() {
        int[] intArray = {0,1,2,3,4,5};
        Integer lastElementInTheArray = Arrays.stream(intArray)
                .boxed()
                .reduce((first, second) -> second).orElse(-1);
        System.out.println("\nlast elements in the array " + lastElementInTheArray);
    }

    public static void firstTenOddNumbers() {
        Stream.iterate(1,i->i+2)
                .limit(10)
                .forEach(System.out::print);
    }

    public static void generateFibonacciSeries() {

        Stream.iterate(new int[]{0,1},t->new int[]{ t[1], t[0]+ t[1] })
                .limit(10)
                .map(t->t[0])
                .forEach(System.out::print);

        Function<int[], List<Integer>> intArraytoListOFInt = array -> Arrays.stream(array).boxed()
                .collect(toList());
        List<Integer> collect = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(intArraytoListOFInt)
                .flatMap(List::stream)
                .distinct()
                .collect(toList());
        System.out.println(collect);
    }

    public static void firstNonRepeatingCharacter() {
        String tempStr = "rohitrohi";
        System.out.println (Arrays.stream (tempStr.split (""))
                .filter (str -> tempStr.indexOf (str) == tempStr.lastIndexOf (str))
                .findFirst ()
                .orElse (""));

    }

    public static void checkIsTheStringPalindrome() {
        String str = "momd";
        String temp = str.replaceAll("\\s+", "").toLowerCase();
        System.out.println("is palindrome string " +IntStream.range(0, temp.length() / 2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1)));
    }

    public static void firstRepeatedCharacter() {
        String word = "rohttoh";
        System.out.println (Arrays.stream (word.split (""))
                .filter (str -> word.indexOf (str) != word.lastIndexOf (str))
                .findFirst ().orElse (""));
    }

    public static void duplicateCharactersInString() {
        String word = "rohttoh";
        System.out.println ("original String " + word);


        System.out.println (Arrays.stream (word.split (""))
                .filter (str -> word.indexOf (str) != word.lastIndexOf (str))
                .map (str -> str.charAt (0))                    //check if we can use joining("") inside collect to get String again
                .collect (toList ()));
    }

    public static void extractDuplicateElements() {
        List<Integer> duplicateElements = of(1, 2,2,2,3, 3, 4, 5,1,1,56, 7, 8, 9, 10);

        System.out.println("maxed Elements " + duplicateElements);

        List<Integer> extractDuplicateElements = duplicateElements.stream()
                .filter(element -> duplicateElements.indexOf(element)
                        != duplicateElements.lastIndexOf(element))
                .distinct()
                .collect(toList());


        System.out.println("extract duplicates elements from " + extractDuplicateElements);
    }

    public static void stringsStartsWithNumber() {
        String [] words= {"rohit","foo","nemo","target1","12Target","2robot"};

        System.out.println("original Strings " + Arrays.toString(words));

        List<String> stringStartNumber = Arrays.stream(words)
                .filter(word -> Character.isDigit(word.charAt(0)))
                .toList();
        System.out.println("strings started with a number " + stringStartNumber);
    }

    public static void mostRepeatedElement() {
        int [] elements = {2,3,1,4,4,1,4,333,3,333,2,2,2,5,222};

        System.out.println("original Array" + Arrays.toString(elements));
        Function<Map<Integer, Long>, Integer> maxValuesKey = integerLongMap ->
                integerLongMap.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElse(Integer.MAX_VALUE);

        Integer maxDuplicateValue = Arrays.stream(elements)
                .boxed()
                .collect(collectingAndThen(groupingBy(Function.identity(),
                        counting()), maxValuesKey));

        System.out.println("max duplicate value in the array "+maxDuplicateValue);
    }

    public static void reversedArray() {
        int [] numberArray ={1,2,3,4,5,6,7,8,9,10};
        System.out.println("original array" + Arrays.toString(numberArray));
        int[] reversedArray = IntStream.rangeClosed(1, numberArray.length)
                .map(number -> numberArray[numberArray.length - number])
                .toArray();
        System.out.println("reversedArray Array" + Arrays.toString(reversedArray));
    }

    public static void reverseEachWord() {
        String stmt = "java is OOP language";
        String reverseEachWord = Arrays.stream(stmt.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(joining(" "));
        System.out.println(reverseEachWord);
    }

    public static void commonElements() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> twoToTen = of(2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> commonElements = oneToTen.stream()
                .filter(twoToTen::contains)
                .toList();
        System.out.println(commonElements);
    }

    public static void calculateAndSumAndAverage() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        IntSummaryStatistics summaryStatistics = oneToTen.stream()
                .collect(summarizingInt(Integer::intValue));
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getAverage());
    }

    public static void sortByLengthOfList() {
        List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");
        names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }

    public static void secondLargestNumberFromList() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer secondLarge = oneToTen.stream()
                .sorted(reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(Integer.MAX_VALUE);

        System.out.println(secondLarge);
    }

    public static void sumOf() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(oneToTen.stream()
                .mapToInt(Integer::intValue)
                .sum());
    }

    public static boolean isAnagram2() {

        String string1 = "listen";
        String string2 = "silent";

        String join1 = Arrays.stream(string1.split(""))
                .sorted()
                .collect(joining(""));

        String join2 = Arrays.stream(string2.split(""))
                .sorted()
                .collect(joining(""));

        return join1.equals(join2);

    }

    public static void isAnagram() {
        char[] splitIt = "listen".toCharArray();
        char[] splitIt2 = "silent".toCharArray();

        Arrays.sort(splitIt);
        Arrays.sort(splitIt2);
        if (Arrays.equals(splitIt,splitIt2)) {
            System.out.println("is Anagram");
        }else{
            System.out.println("is not anagram");
        }

    }

    public static void min3max3() {
        List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        List<Integer> min3 = randomNumbers.stream()
                .sorted(Integer::compare)
                .limit(3)
                .collect(toList());

        List<Integer> max3 = randomNumbers.stream()
                .sorted((x, y) -> Integer.compare(y, x))
                .limit(3)
                .collect(toList());

        System.out.println(min3);
        System.out.println(max3);
    }

    public static void mergeUnsortedArrayIntoSortedWithoutDuplicate() {
        int [] randomNumbers ={12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
        int [] randomNumber2 = {4, 32, 2, 5, 6, 78, 98, 53, 90};

        System.out.println(Arrays.toString(IntStream.concat(Arrays.stream(randomNumbers), Arrays.stream(randomNumber2))
                .distinct()
                .toArray()));
    }

    public static void mergeUnsortedArrayIntoSorted() {
        int [] randomNumbers ={12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
        int [] randomNumber2 = {4, 3, 2, 5, 6, 78, 98, 53, 90};

        int[] sortedArrayByMergingTwoArray = IntStream.concat(Arrays.stream(randomNumbers),
                Arrays.stream(randomNumber2)).sorted().toArray();
        System.out.println(Arrays.toString(sortedArrayByMergingTwoArray));
    }

    public static void minMaxFromList() {
        List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);

        Integer maxNumber = randomNumbers.stream()
                .max(Integer::compareTo)
                .orElse(Integer.MAX_VALUE);

        Integer minValue = randomNumbers.stream()
                .min(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);

        System.out.println(maxNumber);
        System.out.println(minValue);

        IntSummaryStatistics summaryStatistics = randomNumbers.stream()
                .collect(summarizingInt(Integer::intValue));

        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getAverage());
    }

    public static void multipleOf5() {
        List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        List<Integer> multipleOf5 = randomNumbers.stream()
                .filter(n -> n % 5 == 0)
                .collect(toList());
        System.out.println(multipleOf5);
    }

    public static void joinListOfStrings() {
        List<String> languageList = of("java", "c++", "c", "C sharp", "python", "kotlin", "scala");
        String joinWithPrefixSuffixAndDelimiter = languageList
                .stream()
                .collect(joining(",", "[", "]"));
        System.out.println(joinWithPrefixSuffixAndDelimiter);
    }

    public static void reverseSortedList() {
        List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        //this is throwing unsupportedOprerationException because we are
        // tries to sort ImmutableList that is not allowed .
        //   randomNumbers.sort(Comparator.reverseOrder());

        System.out.println(randomNumbers);

        List<Integer> sortInReverse = randomNumbers.stream()
                .sorted((x, y) -> Integer.compare(y, x)) // reverse sort
                .collect(toList());
        System.out.println(sortInReverse);

        List<Integer> sortListReverse = randomNumbers.stream()
                .sorted(reverseOrder())
                .collect(toList());
        System.out.println(sortListReverse);

    }

    public static void wordFrequency() {
        List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");
        Map<String, Long> frequencyWords = names.stream()
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println(frequencyWords);
    }

    public static void characterFrequency() {
        String name = "rohitroh";
        Map<String, Long> characterFrequency = Arrays.stream(name.split(""))
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println(characterFrequency);


        Map<Character, Long> collected = name.chars()
                .mapToObj(ch -> (char) ch)
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println(collected);

        Map<String, Integer> countCharacter = Arrays.stream(name.split(""))
                .collect(groupingBy(Function.identity(),
                        collectingAndThen(counting(), Long::intValue)));
        System.out.println(countCharacter);
    }

    public static void removeDuplicateFromList() {
        List<Integer> oneToTen = of(1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 9, 10);
        List<Integer> removeDuplicate = oneToTen.stream()
                .distinct()
                .collect(toList());

        System.out.println(removeDuplicate);    //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        Set<Integer> removeDuplicateWithoutOrder
                = oneToTen.stream()
                .collect(toSet());
        System.out.println(removeDuplicateWithoutOrder); //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        List<Integer> uniqueElement = oneToTen
                .stream()
                .filter(number -> oneToTen.indexOf(number)
                        == oneToTen.lastIndexOf(number))
                .collect(toList());
        System.out.println(uniqueElement);          //[1, 2, 4, 6, 7, 8, 9, 10]     - this will remove all occurrences of duplicate elements
    }

    public static void separationOfEvenOddNumberInList() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Collection<List<Integer>> evenOddList = oneToTen.stream()
                .collect(collectingAndThen(partitioningBy(i -> i % 2 == 0),
                        Map::values));                                          //We were getting Map with key value pair, using collectingAndThen we specified that we only want values.

        System.out.println(evenOddList);
    }

    public static void separationOfEvenOddNumberInMap() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> evenAddOddSeparation = oneToTen.stream()
                .collect(partitioningBy(i -> i % 2 == 0));

        System.out.println(evenAddOddSeparation);
    }
}
