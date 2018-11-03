package pl.sdacademy.vending.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigurationTest {

    private Configuration testedConfig;

    @Before
    public void init(){
        testedConfig = new Configuration();
    }

    @Test
    public void shouldReturnDefaultStringValueWhenPropartyisUnknown() {
        // Given
        String unknownPropertyName = "qwertdfasdc";
        String expectedDefault = "javaIsOk";
        // When
        String propertyValue = testedConfig.getStringProperty(unknownPropertyName, expectedDefault);

        // Then
        assertEquals(expectedDefault,propertyValue);

    }

    @Test
    public void shouldReturnSetValueWhenPropertyIsKnown() {
        // Given
        String knownPropertyName = "test.property.string";
        String expectedDefault = "javaIsOk";
        // When
        String properValue = testedConfig.getStringProperty(knownPropertyName, expectedDefault);
        // Then
        assertEquals("qwerty", properValue);
    }

    @Test
    public void shouldReturnDefaultLongValue() {
        // Given
        String unknownPropertyName = "qwertdfasdc";
        Long expectedDefault = 8L;
        // When
        Long longProperty = testedConfig.getLongProperty(unknownPropertyName, expectedDefault);
        // Then
        assertEquals(expectedDefault, longProperty);
    }

    @Test
    public void shouldReturnSetLongValue() {
        // Given
        String knownPropertyName = "test.property.long";
        Long expectedDefault = 8L;
        Long expectedVal = 5L;
        // When
        Long longProperty = testedConfig.getLongProperty(knownPropertyName, expectedDefault);
        // Then
        assertEquals(expectedVal, longProperty);
    }


}