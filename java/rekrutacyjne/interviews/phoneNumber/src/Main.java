public class Main {
    public static String reformatNumber(String number) {
        String result = number.replaceAll("\\s+","");
        result = result.replaceAll("-","") ;
        int cur = 0;
        StringBuilder builder = new StringBuilder(result);
        while(cur < builder.length()-5){
            cur += 3;
            builder.insert(cur,"-");
            cur += 1;
        }
        if(result.length()==2){
            return result;
        }
        if(cur==builder.length()-2 || cur==builder.length()-4|| cur==builder.length()-5){
            cur += 3;
            builder.insert(builder.length()-2,"-");
        }
        return builder.toString();
    }

    public static void main( String[] args ) {
boolean insigth = false;
insigth = !insigth;
        System.out.println(reformatNumber( "1-23-45 6" ));
    }
}
