public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int counter = 0;
        int current =  n;
        int result = 0;
        int digit=0;

        if(n==0){
            return 0;
        }
        if(n ==Integer.MIN_VALUE){
            return 1;
        }
        if(n<0){
            current=~n;
        }

        while (current > 0){
            digit =  current % 2;
            current /= 2;
            result += (int) (digit*Math.pow(2,30-counter));
            counter++;
        }
        result *=2;
        return n<1? ~result : result;
    }
}