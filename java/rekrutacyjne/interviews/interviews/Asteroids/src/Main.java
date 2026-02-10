import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;
import static java.util.Objects.isNull;

//We are given an array asteroids of integers representing asteroids in a row.
//For each asteroid, the absolute value represents its size,
// and the sign represents its direction (positive meaning right, negative meaning left).
// Each asteroid moves at the same speed.
//Find out the state of the asteroids after all collisions.
// If two asteroids meet, the smaller one will explode. If both are the same size, both will explode.
// Two asteroids moving in the same direction will never meet.
//
//Example 1: Input: asteroids = [5,10,-5] Output: [5,10] Explanation: The 10 and -5 collide resulting in 10.
// The 5 and 10 never collide.
//
//Example 2: Input: asteroids = [8,-8] Output: [] Explanation: The 8 and -8 collide exploding each other.
//
//Example 3: Input: asteroids = [10,2,-5] Output: [10] Explanation: The 2 and -5 collide resulting in -5.
// The 10 and -5 collide resulting in 10.
public class Main {
    static List<Integer> afterCollision(List<Integer> asteroids) {
        if (isNull(asteroids) || asteroids.size() <= 1) {
            return asteroids;
        }
        var result = new LinkedList<Integer>();
        for (Integer asteroid : asteroids) {
            if (result.isEmpty()) {
                result.add(asteroid);
            } else {
                var previous = result.peekLast();
                if (colliding(previous, asteroid)) {
                    collide(result, asteroid);
                } else {
                    result.add(asteroid);
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return result;
    }

    private static boolean colliding(Integer previous, Integer next) {
        if (previous > 0 && next <= 0) {
            return true;
        }
        return previous == 0 && next < 0;
    }

    private static void collide(Deque<Integer> asteroids, Integer asteroid) {
        Integer previous = asteroids.pollLast();
        boolean asteroidSurvive = true;
        while (previous != null) {
            if (abs(previous) == abs(asteroid)) {
                asteroidSurvive = false;
                break;
            }
            if (abs(previous) > abs(asteroid)) {
                asteroids.add(previous);
                asteroidSurvive = false;
                break;
            }

            previous = asteroids.pollLast();
        }
        if (asteroidSurvive) {
            asteroids.add(asteroid);
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Type asteroidType = Type.values()[(int)(Math.random()*3)];
        String stringType = switch (asteroidType){
            case ROCKY:
                yield "asteroid is rocky!";
            case ICY:
                yield "asteroid is icy!";
            default:
                yield "asteroid is metallic!";
        };
        System.out.printf(stringType);
    }
}