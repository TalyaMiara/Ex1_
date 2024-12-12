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
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void int2NumberTest() {
        int[] numArr = {5, 12, 10, 20, 48};
        String[] resInBinary = {"101b2", "1100b2", "1010b2", "10100b2", "110000b2"};
        int baseNum = 2;
        for (int i = 0; i < numArr.length; i++) {
            String realRes = Ex1.int2Number(numArr[i], baseNum);
            assertEquals(resInBinary[i], realRes);
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
    void returnNumber() {
        // Test valid inputs
        assertEquals(0, Ex1.returnNumber('0'), "Input '0' should return 0");
        assertEquals(1, Ex1.returnNumber('1'), "Input '1' should return 1");
        assertEquals(9, Ex1.returnNumber('9'), "Input '9' should return 9");
        assertEquals(10, Ex1.returnNumber('A'), "Input 'A' should return 10");
        assertEquals(15, Ex1.returnNumber('F'), "Input 'F' should return 15");
        assertEquals(16, Ex1.returnNumber('G'), "Input 'G' should return 16");

        // Test invalid inputs
        assertEquals(-1, Ex1.returnNumber('H'), "Input 'H' should return -1");
        assertEquals(-1, Ex1.returnNumber('!'), "Input '!' should return -1");
        assertEquals(-1, Ex1.returnNumber(' '), "Input ' ' (space) should return -1");

        // Edge cases
        assertEquals(-1, Ex1.returnNumber((char) 0), "Null character should return -1");
        assertEquals(-1, Ex1.returnNumber((char) 127), "DEL character should return -1");
    }

}
