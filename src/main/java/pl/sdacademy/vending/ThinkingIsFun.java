package pl.sdacademy.vending;

public class ThinkingIsFun {
// Zadania dodatkowe
    public void printTree(int height){
        String space = " ";
        String star = "*";
        for (int j = 1; j <=height; j++) {
            for (int i = 0; i < (height * 2) - 1; i++) {


                System.out.print(star);

            }
            System.out.println( );
        }
    }
}
