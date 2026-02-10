
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CollisionDetectorParamTest {
    CollisionDetector collisionDetector = new CollisionDetector();

//    @ParameterizedTest
//    @MethodSource("argumentsWithExpectations")
//    void calculate_collide(List<Integer> inputAsteroids, List<Integer> expectedResult) {
//        var result = collisionDetector.collisionResult(inputAsteroids);
//        assertThat(result).isEqualTo(expectedResult);
//    }
//
//    static Stream<Arguments> argumentsWithExpectations() {
//        return Stream.of(
//                arguments(List.of(5, 10, -5), List.of(5, 10)),
//                arguments(List.of(0, 1, 2, 3), List.of(0, 1, 2, 3)),
//                arguments(List.of(0, -1, -2, -3), List.of(-1, -2, -3)),
//                arguments(List.of(-1, -2, -3, 0), List.of(-1, -2, -3, 0)),
//                arguments(List.of(-8, 8), List.of(-8, 8)),
//                arguments(List.of(8, -8), List.of()),
//                arguments(List.of(-8, 0, 8), List.of(-8, 0, 8)),
//                arguments(List.of(8, 0, -8), List.of()),
//                arguments(List.of(10, 2, -5), List.of(10)),
//                arguments(List.of(), List.of()),
//                arguments(null, null),
//                arguments(List.of(1), List.of(1)),
//                arguments(List.of(0), List.of(0)),
//                arguments(List.of(0, 0), List.of(0, 0))
//        );
//    }
//    @ParameterizedTest
//    @MethodSource("argumentsWithExpectations")
//    void calculate_collide(List<Integer> inputAsteroids, List<Integer> expectedResult) {
//        var result = Asteroids.collisionResult(inputAsteroids);
//        assertThat(result).isEqualTo(expectedResult);
//    }

    static Stream<Arguments> argumentsWithExpectations() {
        return Stream.of(
                arguments(List.of(5, 10, -5), List.of(5, 10)),
                arguments(List.of(0, 1, 2, 3), List.of(0, 1, 2, 3)),
                arguments(List.of(0, -1, -2, -3), List.of(-1, -2, -3)),
                arguments(List.of(-1, -2, -3, 0), List.of(-1, -2, -3, 0)),
                arguments(List.of(-8, 8), List.of(-8, 8)),
                arguments(List.of(8, -8), List.of()),
                arguments(List.of(-8, 0,  8), List.of(-8, 0, 8)),
                arguments(List.of(8, 0,  -8), List.of()),
                arguments(List.of(10, 2, -5), List.of(10)),
                arguments(List.of(), List.of()),
                arguments(null, null),
                arguments(List.of(1), List.of(1)),
                arguments(List.of(0), List.of(0)),
                arguments(List.of(0, 0), List.of(0, 0))
        );
    }
}