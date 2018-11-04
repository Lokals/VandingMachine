package pl.sdacademy.vending.util;

public class StringUtil {
    public static  String adjustText(String text, Integer length){
        if (text.length() > length){
            text = text.substring(0, Math.min(text.length(), length));
            return text;
        }
        StringBuilder x = new StringBuilder();
        if (text.length()%2 == 0 && text.length() < length){
            int numSpac = length-text.length();

            for (int i = 1; i <=numSpac/2; i++ ){
                x = x.append(" ");

            }
            return x+text+x;
        }
        StringBuilder y = new StringBuilder();
        if (text.length()%2 != 0 && text.length() < length){
            int numSpac = length-text.length();

            for (int i = 1; i <=numSpac/2; i++ ){
                y = y.append(" ");

            }
            return y.append(" ")+text+y.delete(1,1);
        }

        return text;
    }
    public static String formatMoney(Long value){

        String valueString;


        afterComma(value);
        beforeComma(value);

        valueString = beforeComma(value) + "," + afterComma(value);
      return valueString;
    }

    private static String beforeComma(Long value) {
        String integrals = Long.toString(value/100);
        StringBuilder formaterMoney = new StringBuilder( );
        Integer characterTillLastSpace = 0;
        for (int charIndex = integrals.length() -1; charIndex >= 0; charIndex--){
                characterTillLastSpace++;
            formaterMoney = formaterMoney.append(integrals.charAt(charIndex));
            if (characterTillLastSpace >= 3) {
                    formaterMoney.append(" ");
                    characterTillLastSpace = 0;
                }
            }
        return formaterMoney.reverse().toString().trim();
    }

    private static String afterComma(Long value) {
        String decimals = Long.toString(value%100);

        if(decimals.length() < 2){
            decimals = "0" +decimals;
        }
        return decimals;
    }
}
