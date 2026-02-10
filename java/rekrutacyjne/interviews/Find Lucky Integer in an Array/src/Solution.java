import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public int findLuckyStream(int[] arr) {

        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.naturalOrder()).collect(Collectors.toUnmodifiableList());
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)))
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .max(Comparator.naturalOrder())
                .orElse(-1);
    }

    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.values().stream().max(Integer::compare).orElse(-1);
    }

    public int solutionExample(int[] A) {
        // Implement your solution here
        List<Integer> list = Arrays.stream(A).boxed().distinct().filter(i -> i > 0).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        if (list.isEmpty()) {
            return 1;
        }
        if (list.get(0) == 1) {
            int counter = 1;
            for (int l : list) {
                if (counter != l) {
                    return counter;
                }
                counter++;
            }
        }
        return 1;
    }

    public int tomTom(String S) {
        // Implement your solution here
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int counter = 0;
        for (char i : S.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            counter++;
        }
        while (counter > 2) {
            List<Integer> collect = map.values().stream().toList();
            counter = 0;
            for (Integer i : collect) {
                counter += i;
            }
            for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
                while (characterIntegerEntry.getValue() > 1) {
                    if (counter >= 3) {
                        result++;
                        map.put(characterIntegerEntry.getKey(), characterIntegerEntry.getValue() - 2);
                        break;
                    }
                }
            }
            counter--;
        }
        return result;
    }
    public int solution(String S) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int counter = 0;
        for (char i : S.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            counter++;
        }
        int size = map.size();
//        while (counter > 2 && size>0) {
            List<Integer> collect = map.values().stream().toList();
            counter = 0;
            for (Integer i : collect) {
                counter += i;
            }
            for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
                if (characterIntegerEntry.getValue() > 1 && counter >= 3) {
                    if(result > 0){
                        result--;
                    }
                    result += map.size()-1;
                    if(characterIntegerEntry.getValue() > 2){
                        result++;
                    }
                    counter-=result;
                    size--;
                }
            }
            return result;
//        }
//        return result;
    }
}