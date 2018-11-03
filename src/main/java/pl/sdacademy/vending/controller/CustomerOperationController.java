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
                System.out.print("+--------+");
            }
            System.out.println( );
            for (int j = 1; j <= machine.rowCount( ); j++) {
                System.out.print("|   " + letter + j + "   |");

            }
            System.out.println( );
            for (int i = 0; i < machine.rowCount( ); i++) {
                System.out.print("+--------+");
            }
            letter++;
            System.out.println( );
        }
    }

}




