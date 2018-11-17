package pl.sdacademy.vending.model;

import org.junit.Test;
import pl.sdacademy.vending.util.Configuration;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VendingMachineTest {


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenZeroRowsConfigured()
    {
        // Given
        Configuration config = mock(Configuration.class);
        doReturn(0L).when(config).getLongProperty(eq("machine.size.rows"),anyLong());
        doReturn(4L).when(config).getLongProperty(eq("machine.size.cols"),anyLong());

        // When
        new VendingMachine(config);
        // Then
        fail("Can not be value set less or equal ZERO");
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldControlIfRowAmoutIsLessThan26(){
        // Given
        Configuration config = mock(Configuration.class);

        doReturn(27L).when(config).getLongProperty(eq("machine.size.rows"),anyLong());
        doReturn(4L).when(config).getLongProperty(eq("machine.size.cols"),anyLong());
        // When
        new VendingMachine(config);
        // Then
        fail("Can not be more than 26 rows amount");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldControlIfColAmoutIsLMoreThan9(){
        // Given
        Configuration config = mock(Configuration.class);

        doReturn(6L).when(config).getLongProperty(eq("machine.size.rows"),anyLong());
        doReturn(10L).when(config).getLongProperty(eq("machine.size.cols"),anyLong());
        // When
        new VendingMachine(config);
        // Then
        fail("Can not be more than 9 columns amount");
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldControlIfColAmoutIslessThan0(){
        // Given
        Configuration config = mock(Configuration.class);

        doReturn(6L).when(config).getLongProperty(eq("machine.size.rows"),anyLong());
        doReturn(0L).when(config).getLongProperty(eq("machine.size.cols"),anyLong());
        // When
        new VendingMachine(config);
        // Then
        fail("Can not be less than 1 columns amount");
    }

    @Test
    public void shouldBeAbleToAddTrayToEmptySlot()
    {
        // Given
        Tray tray = Tray.builder("A2").build( );
        Configuration config = mock(Configuration.class);

        doReturn(6L).when(config).getLongProperty(eq("machine.size.rows"),anyLong());
        doReturn(4L).when(config).getLongProperty(eq("machine.size.cols"),anyLong());

        VendingMachine vendingMachineTested = new VendingMachine(config);

        // When
        boolean placed = vendingMachineTested.placeTray(tray);
        // Then
        assertTrue(placed);
        assertEquals(tray, vendingMachineTested.getTrayAtPosition(0, 1).get());

    }
    @Test
    public void shouldNotBeAbleToAddTrayToTakenSlot()
    {
        // Given
        Tray tray = Tray.builder("A2").build( );
        Tray secondTray = Tray.builder("A2").build( );
        Configuration config = mock(Configuration.class);

        doReturn(6L).when(config).getLongProperty(eq("machine.size.rows"),anyLong());
        doReturn(4L).when(config).getLongProperty(eq("machine.size.cols"),anyLong());

        VendingMachine vendingMachineTested = new VendingMachine(config);
        // When

        boolean firstTrayPlacementResult = vendingMachineTested.placeTray(tray);
        boolean secondTrayPlacementResult = vendingMachineTested.placeTray(secondTray);

        // Then

        assertFalse(secondTrayPlacementResult);
        assertEquals(tray, vendingMachineTested.getTrayAtPosition(0, 1).get());

    }
    @Test
    public void shouldNotBeAbleToAddTrayToNotExistingPosition()
    {
        // Given
        Tray tray = Tray.builder("##").build( );
        Configuration config = mock(Configuration.class);

        doReturn(6L).when(config).getLongProperty(eq("machine.size.rows"),anyLong());
        doReturn(4L).when(config).getLongProperty(eq("machine.size.cols"),anyLong());

        VendingMachine vendingMachineTested = new VendingMachine(config);

        // When
        boolean placed = vendingMachineTested.placeTray(tray);
        // Then
        assertFalse(placed);
    }
    @Test
    public void shouldNotBeAbleToAddTooLongSymbol()
    {
        // Given
        Tray tray = Tray.builder("AAA").build( );
        Configuration config = mock(Configuration.class);

        doReturn(6L).when(config).getLongProperty(eq("machine.size.rows"),anyLong());
        doReturn(4L).when(config).getLongProperty(eq("machine.size.cols"),anyLong());

        VendingMachine vendingMachineTested = new VendingMachine(config);

        // When
        boolean placed = vendingMachineTested.placeTray(tray);
        // Then
        assertFalse(placed);
    }
}