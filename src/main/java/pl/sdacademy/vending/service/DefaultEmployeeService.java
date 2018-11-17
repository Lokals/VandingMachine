package pl.sdacademy.vending.service;

import pl.sdacademy.vending.controller.service.EmployeeService;
import pl.sdacademy.vending.model.Tray;
import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.service.repository.VendingMachineRepository;
import pl.sdacademy.vending.util.Configuration;

import java.util.Optional;

public class DefaultEmployeeService implements EmployeeService {
    private final VendingMachineRepository vendingMachineRepository;
    private final Configuration configuration;

    public DefaultEmployeeService(VendingMachineRepository vendingMachineRepository, Configuration configuration) {
        this.vendingMachineRepository = vendingMachineRepository;

        this.configuration = configuration;
    }


    @Override
    public Optional<String> addTray(Tray tray) {
        Optional<VendingMachine>  loadMachineRepository = vendingMachineRepository.load( );

        VendingMachine vendingMachine = loadMachineRepository.orElseGet(()->new VendingMachine(configuration));

        boolean b = vendingMachine.placeTray(tray);
        if (b){
            vendingMachineRepository.save(vendingMachine);
            return Optional.empty();
        }
        else{
            String sth = "Please recheck provided values";
            return Optional.of(sth);
        }
    }
}
/*
    1.Metoda  ta  powinna  pobrać  automat  z  repozytorium,  wprowadzić  na  nim  zmianę,
    oraz  zapisać  automat  w  repozytorium
    2.Jeżeli  udało  się  wprowadzić  zmianę,
    to  metoda  zwraca  null(czyli  brak  komunikatu  błędu)
    3.Jeżeli  nie  udało  się  wprowadzić  zmiany  w  automacie,  to  metoda  zwróci  ogólny  komunikat  błędu,
      np.Couldnot  set  uptray,  pleasecheckprovidedvalues.



   */