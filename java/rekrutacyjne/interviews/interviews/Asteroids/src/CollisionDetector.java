import java.util.*;

import static java.util.Objects.*;

public class CollisionDetector {
    public List<Integer> collisionResult(List<Integer> asteroidsList) {
        if (isNull(asteroidsList) || asteroidsList.size() <= 1 ) {
            return asteroidsList;
        }
        LinkedList<Integer> result;
        boolean wasCollision;
        var asteroids = asteroidsList;
        do {
            wasCollision = false;
            result = new LinkedList<>();
            for (int i = 0; i < asteroids.size(); i++) {
                var asteroid1 = asteroids.get(i);
                if (hasNextAsteroids(i, asteroids)) {
                    var asteroid2 = asteroids.get(i + 1);
                    if (isCollision(asteroid1, asteroid2)) {
                        wasCollision = true;
                        i++;
                        var collision = collision(asteroid1, asteroid2);
                        if (nonNull(collision)) {
                            if (collision.equals(asteroid1)) {
                                result.add(asteroid1);
                            } else {
                                result.add(asteroid2);
                            }
                        }
                    } else {
                        result.add(asteroid1);
                    }
                } else {
                    result.add(asteroid1);
                }
            }
            asteroids = result;
        } while (wasCollision);
        return result;
    }

    private static boolean hasNextAsteroids(int i, List<Integer> asteroids) {
        return i + 1 < asteroids.size();
    }

    private Integer collision(Integer asteroid1, Integer asteroid2) {
        int absA1 = Math.abs(asteroid1);
        int absA2 = Math.abs(asteroid2);
        if (absA1 > absA2) {
            return asteroid1;
        } else if (absA1 == absA2) {
            return null;
        } else {
            return asteroid2;
        }
    }

    private static boolean isCollision(Integer asteroid1, Integer asteroid2) {
        return asteroid1 >= 0 && asteroid2 < 0;
    }
}