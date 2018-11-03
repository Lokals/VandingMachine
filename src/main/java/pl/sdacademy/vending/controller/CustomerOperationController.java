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
            for (int r = 0; r < machine.rowCount( ); r++) {
                printUpperBoundary(r,k);
            }
            System.out.println( );
            for (int r = 1; r <= machine.rowCount( ); r++) {
                printSymbol(r,k, letter);

            }
            System.out.println( );
            for (int r = 0; r < machine.rowCount( ); r++) {
                printLowerBoundary(r,k);
            }
            letter++;
            System.out.println( );
        }
    }
    private void  printUpperBoundary(int r, int k){
        System.out.print("+--------+");
    }
    private void  printSymbol(int r, int k, char letter){
        System.out.print("|   " + letter + r + "   |");
    }
    private void  printLowerBoundary(int r, int k){
        System.out.print("+--------+");
    }
}




