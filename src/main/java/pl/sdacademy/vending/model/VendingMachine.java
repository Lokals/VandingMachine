package pl.sdacademy.vending.model;

import pl.sdacademy.vending.util.Configuration;
import pl.sdacademy.vending.util.StringUtil;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class VendingMachine {
    private final Configuration configuration;
    private final Long rowsCount;
    private final Long colsCount;
    private final Tray[][] trays;

    public VendingMachine(Configuration configuration){
        this.configuration = configuration;
        rowsCount = configuration.getLongProperty("machine.size.rows", 6L);
        colsCount = configuration.getLongProperty("machine.size.cols",4L);
        if (rowsCount<=0 || rowsCount > 26L){
            throw new IllegalArgumentException("Row count " + rowsCount + " is invalid");
        }
        if (colsCount<=0 || colsCount > 9L){
            throw new IllegalArgumentException("Columns count " + colsCount + " is invalid");
        }
        trays = new Tray[rowsCount.intValue()][colsCount.intValue()];

        Random random = new Random();
        for (int i= 0; i < rowsCount; i++){
            for (int j = 0; j < colsCount; j++){
                if (random.nextInt(10) < 8) {
                    generateTrayAtPosition(i, j);
                }
            }
        }
    }

    private void generateTrayAtPosition(int rowNo, int colNo) {
        Random random = new Random();
        long priceProduct = random.nextInt(901) + 100;
        char symbolLetter = (char) ('A' + rowNo);
        int symbolNumber = colNo + 1;
        String symbol = "" + symbolLetter + symbolNumber;
        int prodProbability = random.nextInt(10);
        Tray.Builder trayBuilder = Tray.builder(symbol).price(priceProduct);
        if (prodProbability == 1) {
            trayBuilder = trayBuilder.product(Product.builder("Product" + symbol).build( ));
        }
        if (prodProbability == 0){
            trayBuilder = trayBuilder.product(Product.builder("Product" + symbol).build( ));
        }
        trays[rowNo][colNo] = trayBuilder.build();
    }


    public Optional<Tray> getTrayAtPosition(int r, int k){
        if (r >= rowsCount || k >= colsCount || r < 0 || k < 0 ){
            return Optional.empty();
        }
        return Optional.ofNullable(trays[r][k]);
    }
    public Long rowCount(){return rowsCount; }

    public Long colsCount(){
        return colsCount;
    }
    public Optional<String> productNameAtPosition(int rowNo, int colsNo){

        Optional<Tray> trayAtPosition = getTrayAtPosition(rowNo, colsNo);
        if (trayAtPosition.isPresent()){
            return trayAtPosition.get().firstProductName();
        }else {
            return Optional.empty();
        }
    }
    public Optional<Product> buyProductWithSymbol(String traySymbol){

        if (traySymbol.length() != 2){
            return Optional.empty();
        }
        char trayLetter = traySymbol.toUpperCase().charAt(0);
        char trayNumber = traySymbol.charAt(1);
        int rowNo = trayLetter - 'A';
        int colNo = trayNumber - '1';

        Tray tray = trays[rowNo][colNo];
        if (tray == null){
            return  Optional.empty();
        } else{
            return tray.buyProduct();
        }

    }

    public boolean placeTray(Tray trayToBeAdded) {
        String symbol = trayToBeAdded.getSymbol();
        int rowNum = symbol.charAt(0) -'A';
        int colNum = symbol.charAt(1) -'1';
        trays[rowNum][colNum] = trayToBeAdded;
        return true;

    }
}
