public class reverseInteger {
    public int reverse(int x) {
        int result = 0;
        int current = x;
        if(x < 0){
            current = -current;
        }
        int digit;
        int counter = 0;
        int tmp = current;
        while(current > 0){
            current /= 10;
            counter++;
        }
        current = tmp;
        int remain = counter;
        while(current > 0){
            digit = current % 10;
            current /= 10;
            remain--;
            if(result + digit*Math.pow(10,remain) > Integer.MAX_VALUE){
                return 0;
            }
            result += digit*Math.pow(10,remain);
        }
        return x < 0 ? -result : result;
    }
}