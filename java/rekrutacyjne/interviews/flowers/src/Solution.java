public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean zero = false;
        int zeroIndex = 0;
        int remainingFlowers = n;
        if(n==0){
            return true;
        }
        if(flowerbed.length == 1 && flowerbed[0]==1){
            return false;
        } else if ( flowerbed.length == 1 && flowerbed[0]==0 && n == 1){
            return true;
        } else if (flowerbed[0]==0 && flowerbed[1]==0){
            remainingFlowers--;
        }
        for (int i = 1; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && i < flowerbed.length-1){
                if (!zero){
                    zeroIndex = i;
                }
                zero = true;
            } else if(zero){
                int free = i-zeroIndex;
                while(free > 2){
                    remainingFlowers--;
                    free -= 2;
                }
                zero = false;
            }
        }
        if (flowerbed.length > 2 && flowerbed[flowerbed.length-2]==0 && flowerbed[flowerbed.length-1]==0){
            remainingFlowers--;
        }
        return remainingFlowers <= 0;
    }
}