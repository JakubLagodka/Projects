//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int countLargestGroup(int n) {
        if(n < 10){
            return n;
        }
        int[] tab = new int[24];
        int pointer;
        int limit2 = 99;
        int limit3 = 999;
        int validated = limit2 < n ? limit2 : n;
        for(int i =10; i <= validated; i++){
            pointer = i%10 + i/10;
            if(pointer < 25){
                tab[pointer-1]++;
            }
        }
        validated = limit3 < n ? limit3 : n;
        for(int i =limit2+1; i <= validated; i++){
            pointer = i%10 + i/100 + i%100/10;
            if(pointer < 25){
                tab[pointer-1]++;
            }
        }
        for(int i =limit3+1; i <= n; i++){
            pointer = i%10 + i/1000 + i%100/10 + i%1000/100;
            if(pointer < 15){
                tab[pointer-1]++;
            }
        }
        tab[0]++;
        tab[1]++;
        tab[2]++;
        tab[3]++;
        tab[4]++;
        tab[5]++;
        tab[6]++;
        tab[7]++;
        tab[8]++;
        int max = tab[0];
        int counter = 0;
        for(int digit : tab){
            if(digit>max){
                counter = 1;
                max=digit;
            }else if(digit==max){
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        System.out.println(countLargestGroup(1439));
    }
}