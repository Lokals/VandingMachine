package pl.sdacademy.vending.controller;

import pl.sdacademy.vending.model.Tray;
import pl.sdacademy.vending.model.VendingMachine;

import java.util.Optional;

public class CustomerOperationController {

    private VendingMachine machine;


    public CustomerOperationController(VendingMachine machine){
        this.machine = machine;
    }

    public void printMachine(){


        for (int k = 0; k < machine.colsCount(); k++) {
            for (int r = 0; r < machine.rowCount(); r++) {
                printUpperBoundary(k,r);
            }
            System.out.println( );
            for (int r = 0; r < machine.rowCount( ); r++) {
                printSymbol(k,r);

            }
            System.out.println( );
            for (int r = 0; r < machine.rowCount( ); r++) {
                printLowerBoundary(k,r);
            }

            System.out.println( );
        }
    }
    private void  printUpperBoundary(int r, int k){
        System.out.print("+--------+");
    }
    private void  printSymbol(int k, int r){
        Optional<Tray> tray = machine.getTrayAtPosition(r, k);
        String traySymbol = tray.map(Tray::getSymbol).orElse("--");
        System.out.print("|   " + traySymbol + "   |");
    }
    private void  printLowerBoundary(int k, int r){
        System.out.print("+--------+");
    }
}




