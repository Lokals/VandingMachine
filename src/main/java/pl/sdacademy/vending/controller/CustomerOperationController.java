package pl.sdacademy.vending.controller;

import pl.sdacademy.vending.model.VendingMachine;

public class CustomerOperationController {

    private VendingMachine machine;


    public CustomerOperationController(VendingMachine machine){
        this.machine = machine;
    }

    public void printMachine(){
        char letter = 'A';

        for (int r = 0; r < machine.rowCount( ); r++) {
            for (int k = 0; k < machine.colsCount(); k++) {
                printUpperBoundary(k,r);
            }
            System.out.println( );
            for (int k = 1; k <= machine.colsCount( ); k++) {
                printSymbol(k,r, letter);

            }
            System.out.println( );
            for (int k = 0; k < machine.colsCount( ); k++) {
                printLowerBoundary(k,r);
            }
            letter++;
            System.out.println( );
        }
    }
    private void  printUpperBoundary(int k, int r){
        System.out.print("+--------+");
    }
    private void  printSymbol(int k, int r, char letter){
        System.out.print("|   " + letter + k + "   |");
    }
    private void  printLowerBoundary(int k, int r){
        System.out.print("+--------+");
    }
}




