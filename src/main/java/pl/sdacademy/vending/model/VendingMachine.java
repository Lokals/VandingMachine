package pl.sdacademy.vending.model;

import pl.sdacademy.vending.util.Configuration;

public class VendingMachine {
    private final Configuration configuration;

    public VendingMachine(Configuration configuration){
        this.configuration = configuration;
    }
    public Long rowCount(){


        return configuration.getLongProperty("machine.size.rows",6L);
    }

    public Long colsCount(){
        return configuration.getLongProperty("machine.size.cols", 4L);
    }
}
