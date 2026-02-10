//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    class Solution {
        public static int removeDuplicates(int[] nums) {
            int same = 0;
            for(int i=1;i<nums.length; i++){
                if(nums[i-1]>=nums[i]){
                    same = 0;
                    while( i+same < nums.length && nums[i-1]>=nums[i+same]){
                        same++;
                    }
                    if(i+same==nums.length){
                        return nums.length-same;
                    }
                    nums[i]=nums[i+same];
                }
            }
            return nums.length-same;
        }
        public static int removeVal(int[] nums, int val) {
            int same = 0;
            int counter = 0;
            int tmp = 0;
            if(nums.length==0){
                return 0;
            }
            for(int i=0;i<nums.length-1-counter; i++){
                if(nums[i]==val){
                    same = 1;
                    while( i+same < nums.length-counter && nums[i+same]==val){
                        same++;
                    }
                    tmp = 0;
                    while(i+same+tmp < nums.length){
                        nums[i+tmp]=nums[i+same+tmp];
                        tmp++;
                    }
                    counter +=same;
                }
            }
            if(nums.length-counter != 0 && nums[nums.length-counter-1]==val && (nums.length-counter-1==0 || nums[nums.length-counter-2]!=val )){
                counter++;
            }
            return nums.length-counter;
        }
    }
//    int removed = 0;
//    int tmp = 0;
//    int same = 1;
//    int series = 0;
//        for(int i=1;i<=nums.length-removed; i++){
//        if(nums[i-1]==nums[i]){
//            tmp = i;
//            while(tmp < nums.length-removed-1){
//                while( tmp+same < nums.length-removed && nums[tmp]==nums[tmp+same]){
//                    same++;
//                    if(same>1+removed){
//                        removed++;
//                    }
//                }
//                if(tmp+same==nums.length){
//                    return nums.length-removed-same;
//                }
//                nums[tmp]=nums[tmp+same];
//                tmp++;
//                same = 1;
//            }
//            removed++;
//        }
//    }
//        return nums.length-removed-series;
    public static void main(String[] args) {
//        System.out.println(Solution.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
//        System.out.println(Solution.removeDuplicates(new int[]{1,1}));
//        System.out.println(Solution.removeVal(new int[]{0,1,2,2,3,0,4,2},2));
        System.out.println(Solution.removeVal(new int[]{0,3,1,1,0,1,3,0,3,3,1,1},1));
    }
}