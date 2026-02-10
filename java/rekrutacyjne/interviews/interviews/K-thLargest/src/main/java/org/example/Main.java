package org.example;

import java.util.*;

//Given list of unordered non-distinct int numbers, find the Kth largest number
//input: List<Integer> nums; int n;
//output: return n-th largest number;
//
//example:
//nums = 1, 3, 2, 6, 7, 6, 2, 5, 2, 10
//n = 2
//answer = 7
public class Main {
    static int kThLargestNumber(List<Integer> nums, int n){
        return nums.stream().sorted(Comparator.reverseOrder()).skip(n-1).findFirst().orElse(null);
    }
    static int kThLargestNumberArrStrem(int[] nums, int n){
        return Arrays.stream(nums).boxed().sorted((a,b)-> Integer.compare(b,a)).skip(n-1).findFirst().orElse(0);
    }
    static String kThLargestNumberArrStremString(String[] nums, int n){
        return Arrays.stream(nums).mapToLong(Long::parseLong).boxed().sorted(Comparator.reverseOrder()).skip(n-1).findFirst().orElse(0L).toString();
    }
    static int kThLargestNumberArr(int[] nums, int target){
        int result = 0;
        for (int i = 0; i < target; i++) {
            int maxIndex = 0;
            for (int k = 1; k < nums.length; k++) {
                if (nums[k] > nums[maxIndex]) {
                    maxIndex = k;
                }
            }
            result = nums[maxIndex];
            nums[maxIndex] = Integer.MIN_VALUE;
        }
        return result;
    }
    public static String kthLargestNumberString(String[] nums, int k) {
        boolean isLong = false;
        String[] big = new String[nums.length];
        String[] small = new String[nums.length];
        int indexBig = 0;
        int indexSmall = 0;
        for(String num: nums){
            if(num.length() > 19 || num.length() == 19 && num.charAt(0) == '9'){
                isLong = true;
                big[indexBig] = num;
                indexBig++;
            } else{
                small[indexSmall] = num;
                indexSmall++;
            }
        }
        if(isLong){
//            for(int j = 0; j< indexBig-1; j++){
//                for(int i = 0; i< indexBig-1; i++) {
//                    // if(big[i].length() < big[i + 1].length() || big[i].length() == big[i + 1].length() && (big[i].charAt(0) < big[i+1].charAt(0) || big[i].charAt(0) == big[i+1].charAt(0) && (big[i].charAt(1) < big[i+1].charAt(1) || big[i].charAt(1) == big[i+1].charAt(1) && (big[i].charAt(2) < big[i+1].charAt(2) || big[i].charAt(2) == big[i+1].charAt(2) && big[i].charAt(3) < big[i+1].charAt(3)|| big[i].charAt(3) == big[i+1].charAt(3) && big[i].charAt(4) < big[i+1].charAt(4)))))){
//                    if (big[i].length() < big[i + 1].length()) {
//                        String tmp = big[i];
//                        big[i] = big[i + 1];
//                        big[i + 1] = tmp;
//                    } else if(big[i].length() == big[i + 1].length()){
//                        for (int i1 = 0; i1 < big[i].length(); i1++) {
//                            if(big[i].charAt(i1) < big[i+1].charAt(i1)){
//                                String tmp = big[i];
//                                big[i] = big[i + 1];
//                                big[i + 1] = tmp;
//                                break;
//                            } else if (big[i].charAt(i1) > big[i+1].charAt(i1)) {
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//            return indexBig >= k ? big[k-1] : Arrays.stream(small).filter(Objects::nonNull).mapToLong(Long::parseLong).boxed().sorted(Comparator.reverseOrder()).skip(k-indexBig-1).findFirst().orElse(0L).toString();
            if(indexBig < k){
                return Arrays.stream(small).filter(Objects::nonNull).mapToLong(Long::parseLong).boxed().sorted(Comparator.reverseOrder()).skip(k-indexBig-1).findFirst().orElse(0L).toString();
            }
            int maxI = 0;
            String returned = big[0];
            for(int i = 0; i<k; i++) {
                for(int j = 1; j< indexBig; j++){
                    //  if(big[j] > big[maxI]){
                    if(big[j].length() > big[maxI].length()){
                        maxI = j;
                    }  else if(big[j].length() == big[maxI].length()){
                        for (int i1 = 0; i1 < big[j].length(); i1++) {
                            if(big[j].charAt(i1) > big[maxI].charAt(i1)){
                                maxI = j;
                                break;
                            } else if (big[j].charAt(i1) < big[maxI].charAt(i1)) {
                                break;
                            }
                        }
                    }
                }
                returned = big[maxI];
                big[maxI] = "";
                maxI = 0;
            }
            return returned;
        }
        return Arrays.stream(nums).mapToLong(Long::parseLong).boxed().sorted(Comparator.reverseOrder()).skip(k-1).findFirst().orElse(0L).toString();

    }
    public static void main(String[] args) {
//        System.out.println(kThLargestNumber(Arrays.asList(1, 3, 2, 6, 7, 6, 2, 5, 2, 10),2));
//        System.out.println(kThLargestNumberArr(new int[]{1, 3, 2, 6, 7, 6, 2, 5, 2, 10},2));
//        System.out.println(kthLargestNumberString(new String[]{"754265888998203915336868925857220416862504","94076991243038101714652401127240805","564610853905353435014867638722725784","513159570775218468831788233","1522868219874385445963089780209","926","3629593624423745006498162232042","6157819013272544572","84994753591810097601995954762370826459973","6185851106515521438581652017727693591316049075","4","573904432","13248061738606050","55749465","27392105612617718959839978715482862497958063","33121687314240508998809528506168803587473141","496948602","85526","9014923359585586220881158339856785969","13932077040330594513516105143717881622115379581","980437949251354427","804","972070511","5362961","6159177305589941896710311017468444908357874314","4","668","1416288852302774232532502759659672136417963114877","53681252322240928981959856203173775343225069","7706240893739719266106088373923370487055775825517","15908518480619782612071347317055916092694671","783011749965848375052477196983445438969","4592737206656268483688606026621","360402636","21724117280665823023781581406042600","953455244868","73390058776866","945243585444539685409123545","9152306652809743644024082295617416968199722","137959166525105803","70214127961671162091","29887401406260350605116933177","493931548267712117065605700363619374142","72969783812176681568953363903904","522172172459433480688453233722529946055315673","433174083","888386172361068978849095885978772283012","34285540578729134015416516074211399606022387","651037832925591263961748373464","851677228221363569","470669925634811870468067713460405260959212","38458185","51398201684090241425480547115","52355863995","84112594251","6699195928788728997","234777615384329952919945416564642458579071614047","74853834789579074019857","905959354118372344429","67014","254903907467632626304195104299252","429900757341","9393279568042175109963670","94","59813494051413849414394169626005603032443064485450","8478792158796186","60178213312208728","32244","25231442"},2));
        System.out.println(kthLargestNumberString(new String[]{"683339452288515879","7846081062003424420","4805719838","4840666580043","83598933472122816064","522940572025909479","615832818268861533","65439878015","499305616484085","97704358112880133","23861207501102","919346676","60618091901581","5914766072","426842450882100996","914353682223943129","97","241413975523149135","8594929955620533","55257775478129","528","5110809","7930848872563942788","758","4","38272299275037314530","9567700","28449892665","2846386557790827231","53222591365177739","703029","3280920242869904137","87236929298425799136","3103886291279"},3));
                System.out.println(kthLargestNumberString(new String[]{"21729806865086376","262473149864","1098180","4565126944869","563688725887","595621372","4865","126012796114351906","9490277038430","98392053021465669380","284","654393769042681818","6184894769","4577907141633565","90434165182755394","473334","4339521","2790","175957947284639208","88085627187500","7915594","943479","62763655647","393143","763227026728857448","1612034717545588450","25939982455877","794","325699611253554","747598762","123413","711178","16","21492164334722820","65","8848728299796884","883174564240","9","64780","8406493085368663","763416","99448463","324","8974","83502080214427031207","6647570","22046187234","1136730371837","5520881474350"},43));
        System.out.println(kthLargestNumberString(new String[]{"66955798877492424","85402547","384222","410592","552380552578284","1672","620885474929751","1281406937515093","9343018718637599805","3656504554781","8674266","22347","61961064628792326","9704947873","1","54714","37301471959796","815890429","35","352045650448183","292855","5518952028","6765213283","9988816","212075452798524","2","32342321","21076031089071","114011939"},23));


    }
}