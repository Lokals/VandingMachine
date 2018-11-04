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
            return y.delete(1,1)+text+y.append(" ");
        }

        return text;
    }
}
