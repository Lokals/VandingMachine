package pl.sdacademy.vending.util;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)

public class StringUtilTest {



    @Test
    public void shouldReturnUnmodifiedTextIfLenghtMatched() {
        // Given
        String textToAdjust = "Text testowy";
        Integer expectedLength = 12;
        // When
        String adjustedText = StringUtil.adjustText(textToAdjust, expectedLength);
        // Then
        assertEquals("Text testowy",adjustedText);
    }

    @Test
    public void shouldTrimTooLongText() {
        // Given
        String textToTrim = "Text Tess";
        Integer expectedLength = 8;
        // When
        String adjustedTest = StringUtil.adjustText(textToTrim, expectedLength);
        // Then
        assertEquals("Text Tes",adjustedTest);
    }


    @Test
    public void shouldReturnProperLenghtWhenStringIsEvenAndLessThan8()
    {
        // Given
        String textToTrim = "Textedod";
        Integer expectedLength = 8;
        // When
        String adjustedTest = StringUtil.adjustText(textToTrim, expectedLength);
        // Then
        assertEquals("Textedod", adjustedTest);
    }
    @Test
    public void shouldReturnProperLenghtWhenStringIsOddAndLessThan8()
    {
        // Given
        String textToTrim = "T";
        Integer expectedLength = 8;
        // When
        String adjustedTest = StringUtil.adjustText(textToTrim, expectedLength);
        // Then
        System.out.println(adjustedTest + "lenght " + adjustedTest.length());
        assertEquals("   T    ", adjustedTest);
    }


    @Test
    @Parameters
    public void shouldProperlyFormatMoney(Long amountToFormat, String expectedResult){
        // Given in parameters            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        // When
        String formatedMoney = StringUtil.formatMoney(amountToFormat);
        // Then
        System.out.println(formatedMoney );
        assertEquals(expectedResult, formatedMoney);
    }
    public  Object[] parametersForShouldProperlyFormatMoney(){
        return new Object[]{
                new Object[] {123L, "1,23"},
                new Object[] {0L, "0,00"},
                new Object[] { 5L, "0,05"},
                new Object[] { 12L, "0,12"},
                new Object[] { 1234L, "12,34"},
                new Object[] { 12345L, "123,45"},
                new Object[] { 123456L, "1 234,56"},
                new Object[] { 1234567L, "12 345,67"},
                new Object[] { 12345678L, "123 456,78"},
                new Object[] { 123456789L, "1 234 567,89"},
                new Object[] { 1234567890123456789L, "12 345 678 901 234 567,89"}

        };
    }
}