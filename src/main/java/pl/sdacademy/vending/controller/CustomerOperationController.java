package pl.sdacademy.vending.controller;

import pl.sdacademy.vending.model.VendingMachine;

public class CustomerOperationController {

    private VendingMachine machine;


    public CustomerOperationController(){
        machine = new VendingMachine();
    }

    public void printMachine(){
        char letter = 'A';

        for (int k = 0; k < machine.colsCount(); k++) {
            for (int i = 0; i < machine.rowCount( ); i++) {
                printUpperBoundary(i,k);
            }
            System.out.println( );
            for (int i = 1; i <= machine.rowCount( ); i++) {
                printSymbol(i,k, letter);

            }
            System.out.println( );
            for (int i = 0; i < machine.rowCount( ); i++) {
                printLowerBoundary(i,k);
            }
            letter++;
            System.out.println( );
        }
    }
    private void  printUpperBoundary(int i, int k){
        System.out.print("+--------+");
    }
    private void  printSymbol(int i, int k, char letter){
        System.out.print("|   " + letter + i + "   |");
    }
    private void  printLowerBoundary(int i, int k){
        System.out.print("+--------+");
    }
}




