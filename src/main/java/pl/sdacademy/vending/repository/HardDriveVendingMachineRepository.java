package pl.sdacademy.vending.repository;

import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.service.repository.VendingMachineRepository;
import pl.sdacademy.vending.util.Configuration;

import java.io.*;
import java.util.Optional;

public class HardDriveVendingMachineRepository implements VendingMachineRepository {

    private final String repoLocation;

    public HardDriveVendingMachineRepository(Configuration configuration){
        repoLocation = configuration.getStringProperty("repository.harddrive.vm.path", "VendingMachine.ser");

    }

    @Override
    public VendingMachine save(VendingMachine machine) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(repoLocation))) {
            System.out.println("About to serialize the object");
            objectOutputStream.writeObject(machine);
            System.out.println("Object has been serialized");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return machine;
    }
    @Override
    public Optional<VendingMachine> load() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(repoLocation))) {
            System.out.println("About to deserialize Object" );
            VendingMachine deserialized = (VendingMachine) objectInputStream.readObject();
            System.out.println("Object deserialised");
            System.out.println(deserialized );
            return Optional.ofNullable(deserialized);
        }
        catch   (IOException | ClassNotFoundException e){
            System.out.println("Vending machine repo file not found or could not find class");
            e.printStackTrace();
        }
        return Optional.empty();
    }

}

//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("SerializedSampleObject.ser"))) {
//            System.out.println("About to serialize the object");
//            objectOutputStream.writeObject(sso);
//            System.out.println("Object has been serialized");
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }