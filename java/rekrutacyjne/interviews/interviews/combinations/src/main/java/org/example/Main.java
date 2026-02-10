import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

private static final Map<Integer, String> NUMBERS = Map.ofEntries(
        Map.entry(2, "abc"),
        Map.entry(3, "def"),
        Map.entry(4, "ghi"),
        Map.entry(5, "jkl"),
        Map.entry(6, "mno"),
        Map.entry(7, "pqrs"),
        Map.entry(8, "tuv"),
        Map.entry(9, "wxyz"));
private static final Map<Character, String> STRING_NUMBERS = Map.ofEntries(
        Map.entry('2', "abc"),
        Map.entry('3', "def"),
        Map.entry('4', "ghi"),
        Map.entry('5', "jkl"),
        Map.entry('6', "mno"),
        Map.entry('7', "pqrs"),
        Map.entry('8', "tuv"),
        Map.entry('9', "wxyz"));

public static void main(String[] args) {
    System.out.println(combine(2, 3));
    System.out.println(letterCombinations(""));
    System.out.println(letterCombinations("23"));
}

private static List<String> combine(final int... numbers) {
    return combine(new ArrayList<>(Arrays.stream(numbers).boxed().toList()), List.of(""));
}

private static List<String> combine(final List<Integer> numbers, final List<String> result) {
    if (numbers.isEmpty()) {
        return result;
    }
    final String letters = NUMBERS.get(numbers.getFirst());
    numbers.removeFirst();
    final List<String> resultCopy = new ArrayList<>(result);
    for (String string : result) {
        for (char c : letters.toCharArray()) {
            resultCopy.add(string + c);
        }
    }
    return combine(numbers, resultCopy.subList(result.size(), resultCopy.size()));
}

public static List<String> letterCombinations(String digits) {
    if (digits == null || digits.isEmpty()) {
        return new ArrayList<>();
    }
    List<String> result = Arrays.stream( STRING_NUMBERS.get(digits.charAt(0)).split("")).toList();
    String[] currentCombinations;
    List<String> tmp = new ArrayList<>();
    char[] digitsCharArray = digits.toCharArray();
    for (int i = 1; i < digitsCharArray.length; i++) {
        tmp.clear();
        currentCombinations = STRING_NUMBERS.get(digitsCharArray[i]).split("");
        for (String string : result) {
            for (String s : currentCombinations) {
                tmp.add(string+s);
            }
        }
        result = new ArrayList<>(tmp);
    }
    return result;
}