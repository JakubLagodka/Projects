package org.example;

import java.util.*;
import java.util.stream.Collectors;

//Given a list of people with their birth and death years,
//implement a method to compute the year with the most number of people alive.
//You may assume that all people were born between 1900 and 2000 (inclusive).
//If a person was alive during any portion of that year, they should be included in that year's count.
//For example, a person born in 1908 who died in 1909 is included in counts for both 1908 and 1909
public class Main {
    public List<Integer> maxPeopleYears(List<Person> people) {

        int numberOfPeople = 0;
        int checkedYear = 1900;
        int maxPeopleYear = checkedYear;
        int maxPeopleNumber = 0;
        List<Integer> maxYears = new ArrayList<>();
        while (checkedYear <= 2000) {
            for (Person person : people) {
                if (person.birthYear == checkedYear)
                    numberOfPeople++;
                if (person.deathYear == checkedYear - 1)
                    numberOfPeople--;
            }
            if (numberOfPeople > maxPeopleNumber) {
                maxPeopleNumber = numberOfPeople;
                //maxPeopleYear = checkedYear;
                maxYears.clear();
                maxYears.add(checkedYear);
            } else if (numberOfPeople == maxPeopleNumber) {
                maxYears.add(checkedYear);
            }
            checkedYear++;
        }
        List<String> words = List.of("");
        List<String> returned = List.of("");
        for (String word : words) {
            returned.addAll(List.of(word.split("")));
            String[] split = word.split(String.valueOf('s'));
            for (String string : split) {

            }
        }

        return maxYears;
    }

    public List<Integer> maxPeopleYearsStream(List<Person> people) {
        Map<Long, Long> checkedYears = new HashMap<>();
        for (int i = 1900; i < 2000; i++) {
            int finalI = i;
            checkedYears.put((long) i, people.stream()
                    .filter(person -> (finalI >= person.birthYear && finalI <= person.deathYear))
                    .count());
        }
//zwraca tylko 1 zamiast listy:
//        return List.of(Math.toIntExact(checkedYears.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).orElse(null).getKey()));
        //poprawne:
//        List<Map.Entry<Long, Long>> sortedMap = checkedYears.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
//        Long maxValue = sortedMap.stream().skip(sortedMap.size()-1).findFirst().get().getValue(); //zwracam ostatni element
//        List<Map.Entry<Long, Long>> maxEntry = sortedMap.stream().filter(longLongEntry -> Objects.equals(longLongEntry.getValue(), maxValue)).toList();
//to samo tylko w jednej zmiennej:
        return checkedYears.entrySet().stream()
                .filter(longLongEntry -> Objects.equals(longLongEntry.getValue(),
                        checkedYears.entrySet().stream().
                                sorted(Map.Entry.comparingByValue())
                                .skip(checkedYears.size() - 1)
                                .findFirst()
                                .orElse(Map.entry(0L, 0L))
                                .getValue()))
                .map(longLongEntry -> longLongEntry.getKey().intValue()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    //kamila rozwiązanie:
//    public class Main {
//        public static void main(String[] args) {
//            int[] birth = {1900, 1905, 1910, 1908};
//            int[] death = {1999, 1980, 1970, 1909};
//
//            System.out.println(yearWithMostPeopleAlive(birth, death));
//        }
//
//        public static int yearWithMostPeopleAlive(int[] birth, int[] death) {
//            int[] years = new int[101];
//
//            for (int i = 0; i < birth.length; i++) {
//                years[birth[i] - 1900]++;
//                years[death[i] - 1900 + 1]--;
//            }
//
//            int maxYear = 0;
//            int maxPeople = 0;
//            int currentPeople = 0;
//
//            for (int i = 0; i < years.length; i++) {
//                currentPeople += years[i];
//                if (currentPeople > maxPeople) {
//                    maxPeople = currentPeople;
//                    maxYear = i;
//                }
//            }
//
//            return maxYear + 1900;
//        }
//    }

    //od Alka:
//    import org.junit.jupiter.api.Test;
//
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.IntStream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//    class People {
//        int birthYear;
//        int deathYear;
//
//        public People(int birthYear, int deathYear) {
//            this.birthYear = birthYear;
//            this.deathYear = deathYear;
//        }
//    }
//
//    class Pair {
//        int year;
//        long count;
//
//        public Pair(int year, long count) {
//            this.year = year;
//            this.count = count;
//        }
//
//        @Override
//        public String toString() {
//            return "Pair{" +
//                    "year=" + year +
//                    ", count=" + count +
//                    '}';
//        }
//    }
//
//    /*
//     * Given a list of people with their birth and death years,
//     * implement a method to compute the year with the most number of people alive.
//     * You may assume that all people were born between 1900 and 200 (inclusive).
//     * If a person was alive during any portion of that year, they should be included in that year's count.
//     * For example, a person born in 1908 who died in 1909 is included in counts for both 1908 and 1909
//     * */
//    public class CountPeopleAlive {
//
//        public Integer computeYearWithTopPopulation(List<People> peopleList) {
//            return IntStream.range(1900, 2001)
//                    .mapToObj(year -> new Pair(year, peopleList.stream().filter(p -> year >= p.birthYear && year <= p.deathYear).count()))
//                    .peek(System.out::println)
//                    .max(Comparator.comparing(a -> a.count))
//                    .map(pair -> pair.year).orElse(0);
//        }
//    }
//
//    class CountPeopleAliveTest {
//        @Test
//        void countAllAlive() {
//            // given
//            List<People> peopleList = List.of(new People(1900, 2000),
//                    new People(1907, 1909), new People(1908, 1908),
//                    new People(1909, 1950));
//            CountPeopleAlive subject = new CountPeopleAlive();
//            List<Integer> expected = List.of();
//
//            // when
//            Integer actual = subject.computeYearWithTopPopulation(peopleList);
//
//            // then
//            assertEquals(1908, actual);
//        }
//    }

}