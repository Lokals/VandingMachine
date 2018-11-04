package pl.sdacademy.vending.model;

import pl.sdacademy.vending.util.Configuration;

import java.util.Optional;
import java.util.Random;

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

    private void generateTrayAtPosition(int i, int j) {
        Random random = new Random();
        long priceProduct = random.nextInt(901) + 100;
        char symbolLetter = (char) ('A' + j);
        int symbolNumber = i + 1;
        String symbol = "" + symbolLetter + symbolNumber;
        int prodProbability = random.nextInt(10);
        Tray.Builder trayBuilder = Tray.builder(symbol).price(priceProduct);
        if (prodProbability < 5) {
            trayBuilder = trayBuilder.product(Product.builder("Product" + symbol).build( ));
        }
        if (prodProbability < 1){
            trayBuilder = trayBuilder.product(Product.builder("Product" + symbol).build( ));
        }
        trays[i][j] = trayBuilder.build();
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
        //pobierz nazwe pierwszego produktu
        //zwroc optional
    }
}
