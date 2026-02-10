import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> result = new LinkedList<>();
        List<Integer> finalResult;
        List<Integer> asteroidList = new ArrayList<>();
        finalResult = new ArrayList<>();
        boolean wasCollision;
        do {
            wasCollision = false;
            if(result.isEmpty()){
                for (int asteroid : asteroids) {
                    asteroidList.add(asteroid);
                }
            }
            else{
                asteroidList.clear();
                asteroidList.addAll(result);
            }
            result.clear();
            if(asteroidList.size() < 2 || asteroidList.size() == 2 && isSameDirection(asteroidList.get(0),asteroidList.get(1))){
                break;
            }
            for (int i = 0; i < asteroidList.size(); i++) {
                var asteroid1 = asteroidList.get(i);
                if (hasNextAsteroids(i, asteroidList)) {
                    var asteroid2 = asteroidList.get(i + 1);
                    if (isCollision(asteroid1, asteroid2)) {
                        wasCollision = true;
                        i++;
                        var collision = collision(asteroid1, asteroid2);
                        if (collision != null) {
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
            finalResult.clear();
            finalResult.addAll(result);
            if(result.isEmpty()){
                break;
            }
        } while (wasCollision);
        int[] res = new int[finalResult.size()];
        for (int i = 0; i < finalResult.size(); i++) {
            res[i] = finalResult.get(i);
        }
        return res;
    }
    private static boolean isSameDirection(Integer asteroid1, Integer asteroid2){
        return asteroid1 > 0 && asteroid2 > 0 || asteroid1 < 0 && asteroid2 < 0;
    }

    private static boolean hasNextAsteroids(int i, List<Integer> asteroidList) {
        return i + 1 < asteroidList.size();
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