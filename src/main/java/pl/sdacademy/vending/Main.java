package pl.sdacademy.vending;

import pl.sdacademy.vending.controller.CustomerOperationController;
import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.util.Configuration;

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration( );
        VendingMachine machine = new VendingMachine(configuration );
        new CustomerOperationController(machine).printMachine();


    }

}
