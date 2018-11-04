package pl.sdacademy.vending.util;

import org.junit.Test;

import static org.junit.Assert.*;

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

}