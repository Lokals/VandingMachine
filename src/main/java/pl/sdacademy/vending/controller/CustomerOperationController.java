package pl.sdacademy.vending.controller;

import pl.sdacademy.vending.model.Product;
import pl.sdacademy.vending.model.Tray;
import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.util.StringUtil;

import java.util.Optional;

public class CustomerOperationController {
    private VendingMachine machine;
    private final Integer trayWidth = 12;

    public CustomerOperationController(VendingMachine machine) {
        this.machine = machine;
    }

    public void printMachine() {


        for (int k = 0; k < machine.colsCount( ); k++) {
            for (int r = 0; r < machine.rowCount( ); r++) {
                printUpperBoundary(k, r);
            }
            System.out.println( );
            for (int r = 0; r < machine.rowCount( ); r++) {
                printSymbol(k, r);

            }

            System.out.println( );
            for (int r = 0; r < machine.rowCount( ); r++) {
                printName(k, r);

            }

            System.out.println( );
            for (int r = 0; r < machine.rowCount( ); r++) {
                printPrice(k, r);

            }

            System.out.println( );
            //wyswietl cene produktu
            for (int r = 0; r < machine.rowCount( ); r++) {
                printLowerBoundary(k, r);
            }

            System.out.println( );
        }
    }


    public Optional<Product> buyProductForSymbol(String traySymbol){
        return machine.buyProductWithSymbol(traySymbol);
    }

    private void printUpperBoundary(int r, int k) {
        System.out.print("+" + StringUtil.duplicateText("-", trayWidth) + "+");
    }

    private void printSymbol(int k, int r) {
        Optional<Tray> tray = machine.getTrayAtPosition(r, k);
        String traySymbol = tray.map(Tray::getSymbol).orElse("--");
        System.out.print("|" + StringUtil.adjustText(traySymbol, trayWidth) + "|");
    }

    private void printPrice(int k, int r) {
        Optional<Tray> tray = machine.getTrayAtPosition(r, k);
        Long price = tray.map(Tray::getPrice).orElse(0L);
        String formatedMoney = StringUtil.formatMoney(price);
        String centeredMoney = StringUtil.adjustText(formatedMoney, trayWidth);
        System.out.print("|" + centeredMoney + "|");

    }


    private void printName(int k, int r) {
        Optional<String> productName = machine.productNameAtPosition(r, k);
        String formatedName = productName.orElse("--");
        System.out.print("|" + StringUtil.adjustText(formatedName, trayWidth) + "|");
    }

    private void printLowerBoundary(int k, int r) {


        System.out.print("+" + StringUtil.duplicateText("-", trayWidth) + "+");
    }
}




