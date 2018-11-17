package pl.sdacademy.vending;

import pl.sdacademy.vending.controller.CustomerOperationController;
import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.util.Configuration;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().init();


    }



    private void init() {
        Configuration configuration = new Configuration( );
        VendingMachine machine = new VendingMachine(configuration );
        new CustomerOperationController(machine).printMachine();
        while (true) {
            printMenu( );
            try {
                UserMenySelection userSelection = getUserSelection( );
                switch (userSelection) {
                    case BUY_PRODUCTS:
                        // 1. pobrac od uzytkownica symbol tacki
                        //2. wywolac odpowiednia metode z koltolera

                        break;
                    case EXIT:
                        System.out.println("Bye");
                        return;
                    default:
                        System.out.println("Invalid selection");
                }
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage( ));
            }
        }
    }



    private void printMenu() {
        UserMenySelection[] allPossibleSelection = UserMenySelection.values( );
        for (UserMenySelection menuPosition: allPossibleSelection){
            System.out.println(menuPosition.getOptionNumber( ) + ". " + menuPosition.getOptionText( ));
        }

    }
    private UserMenySelection getUserSelection() {
        System.out.println(" > Your selection: " );
        String userSelection = new Scanner(System.in).nextLine( );
        try {
            Integer menuNumber = Integer.valueOf(userSelection);
            return UserMenySelection.selectionForOptionNumber(menuNumber);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid selection format. Please select Number");
        }

    }

}
