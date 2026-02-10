import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class NSum {

    public static void main(String[] args) {
//        log.info(nSum(List.of(1, 2, 0, -1, -2, 0, 1, 2), 0, 1).toString());
//        log.info(nSum(List.of(1, 2, 0, -1, -2, 0, 1, 2), 0, 2).toString());
//        log.info(nSum(List.of(1, 2, 0, -1, -2, 0, 1, 2), 0, 3).toString());
    }

    static List<List<Integer>> nSum(List<Integer> inputNumbers, Integer desiredSum, int numberOfElements) {
        int inputSize = inputNumbers.size();
        if (inputSize < numberOfElements) {
            return List.of();
        }

        if (numberOfElements == 1) {
            return inputNumbers.stream()
                    .filter(el -> Objects.equals(el, desiredSum))
                    .map(List::of)
                    .toList();
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < inputSize - 1; i++) {
            Integer firstElement = inputNumbers.get(i);
            Integer newSum = desiredSum - firstElement;
            result.addAll(
                    nSum(inputNumbers.subList(i + 1, inputSize), newSum, numberOfElements - 1).stream()
                            .filter(list -> list.size() == numberOfElements - 1)
                            .map(list -> group(firstElement, list))
                            .toList()
            );
        }
        return result;
    }

    private static List<Integer> group(Integer firstElement, List<Integer> moreElements) {
        List<Integer> result = new ArrayList<>();
        result.add(firstElement);
        result.addAll(moreElements);
        return result;
    }

}