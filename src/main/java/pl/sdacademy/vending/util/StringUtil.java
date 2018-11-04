package pl.sdacademy.vending.util;

public class StringUtil {

    public static String duplicateText(String text, Integer count){
        StringBuilder duplicatedText = new StringBuilder();
        for (int i = 0; i <count; i++){
            duplicatedText = duplicatedText.append(text);
        }
        return duplicatedText.toString();
    }


    public static  String adjustText(String text, Integer length){
        if (text.length() > length){
            text = text.substring(0, Math.min(text.length(), length));
            return text;
        }

        if (text.length()%2 == 0 && text.length() < length){
            int numSpac = length-text.length();
            StringBuilder x = new StringBuilder();
            for (int i = 1; i <=numSpac/2; i++ ){
                x.append(" ");

            }
            return x+text+x;
        }

        if (text.length()%2 != 0 && text.length() < length){
            int numSpac = length-text.length();
            StringBuilder y = new StringBuilder();
            for (int i = 1; i <=numSpac/2; i++ ){
                y.append(" ");
            }
            return y.append(" ")+text+y.delete(1,2);
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
        int characterTillLastSpace = 0;
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
