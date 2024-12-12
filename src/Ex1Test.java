package assignments.ex1;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
           int [] numArr= {5, 12, 10, 20, 48};
           String[] resInBinary={"101b2", "1100b2","1010b2","10100b2","110000b2"};
           int baseNum= 2;
            for (int i = 0; i < numArr.length; i++) {
                String realRes= Ex1.int2Number(numArr[i],baseNum);
                assertEquals(resInBinary[i],realRes);
            }
        }
        @Test
        void maxIndexTest() {
            // Capture the output of the function
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outputStream));

            // Test case 1: add is greater than multiply
            Ex1.maxIndex(5, 3, 10, 8, "10 (add)", "8 (multiply)");
            String expectedOutput1 = "max number over[5,3,10 (add),8 (multiply)] is10 (add)";
            assertTrue(outputStream.toString().trim().contains(expectedOutput1), "Test case 1 failed");
            outputStream.reset();

            // Test case 2: multiply is greater than add
            Ex1.maxIndex(7, 2, 9, 15, "9 (add)", "15 (multiply)");
            String expectedOutput2 = "max number over[7,2,9 (add),15 (multiply)] is15 (multiply)";
            assertTrue(outputStream.toString().trim().contains(expectedOutput2), "Test case 2 failed");
            outputStream.reset();

            // Test case 3: add is equal to multiply
            Ex1.maxIndex(4, 6, 12, 12, "12 (add)", "12 (multiply)");
            String expectedOutput3 = "max number over[4,6,12 (add),12 (multiply)] is12 (add)";
            assertTrue(outputStream.toString().trim().contains(expectedOutput3), "Test case 3 failed");

            // Restore original System.out
            System.setOut(originalOut);
        }
    @Test
    void equalsTest() {
        // Test valid equal numbers
        assertTrue(Ex1.equals("1011b2", "11b10")); // Binary and Decimal
        assertTrue(Ex1.equals("FFbG", "255b10"));  // Hexadecimal-like and Decimal
        assertTrue(Ex1.equals("0b2", "0b10"));     // Zero in Binary and Decimal

        // Test valid non-equal numbers
        assertFalse(Ex1.equals("1010b2", "11b10")); // Different values
        assertFalse(Ex1.equals("FFbG", "254b10"));  // Close but not equal

        // Test invalid inputs
        assertFalse(Ex1.equals("", "11b10"));       // Empty string
        assertFalse(Ex1.equals("1011b2", ""));      // Empty string
        assertFalse(Ex1.equals(null, "11b10"));     // Null input
        assertFalse(Ex1.equals("1011b2", null));    // Null input
    }
    @Test
    void number2IntTest() {
        // Test valid inputs
        assertEquals(11, Ex1.number2Int("1011b2")); // Binary
        assertEquals(255, Ex1.number2Int("FFbG"));  // Hexadecimal-like base 16 (G)
        assertEquals(0, Ex1.number2Int("0b10"));    // Base 10 with 0

        // Test invalid inputs
        assertEquals(-1, Ex1.number2Int(""));         // Empty string
        assertEquals(-1, Ex1.number2Int(null));       // Null input
        assertEquals(-1, Ex1.number2Int("123b17"));   // Invalid base
        assertEquals(-1, Ex1.number2Int("123"));      // Missing base
        assertEquals(-1, Ex1.number2Int("b2"));       // Missing number
        assertEquals(-1, Ex1.number2Int("123b"));     // Missing base
    }

    }
