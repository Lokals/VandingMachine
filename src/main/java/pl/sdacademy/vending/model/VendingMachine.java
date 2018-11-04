package pl.sdacademy.vending.model;

import pl.sdacademy.vending.util.Configuration;

import java.util.Optional;

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

        for (int i= 0; i < rowsCount; i++){
            for (int j = 0; j < colsCount; j++){
                char symbolLetter = (char)('A' + j);
                int symbolNumber = i + 1;
                String symbol = "" + symbolLetter + symbolNumber;
                Tray tray = Tray.builder(symbol).build( );
                trays[i][j] = tray;
            }
        }
    }

    public Optional<Tray> getTrayAtPosition(int r, int k){
        if (r >= rowsCount || k >= colsCount || r < 0 || k < 0 ){
            return Optional.empty();
        }
        return Optional.of(trays[r][k]);
    }
    public Long rowCount(){return rowsCount; }

    public Long colsCount(){
        return colsCount;
    }
}
