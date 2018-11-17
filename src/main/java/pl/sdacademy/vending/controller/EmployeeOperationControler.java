package pl.sdacademy.vending.controller;

import pl.sdacademy.vending.controller.service.EmployeeService;
import pl.sdacademy.vending.model.Tray;

import java.util.Optional;
import java.util.Scanner;

public class EmployeeOperationControler {
    private final EmployeeService employeeService;

    public EmployeeOperationControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void addTrey(Tray tray){
        System.out.println(" > provide tray symbol: ");
        String traysymbol = getUserInput( );
        System.out.println(" > provide tray price: ");
        Long trayprice = Long.parseLong(getUserInput( ));
        Tray newTray = Tray.builder(traysymbol).price(trayprice).build( );
        Optional<String> errorMessage = employeeService.addTray(newTray);
        System.out.println(errorMessage.orElse("Success, trey has been added"));


        // ask for trey price
        // build new trey
        //delegate tray save to service
    }

    private String getUserInput() {
        return new Scanner(System.in).nextLine( );
    }


}
