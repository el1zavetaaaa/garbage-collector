package yllbnts.gc.memory_allocator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import yllbnt.gc.memory_allocator.SequentialBump;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SequentialBumpTest {

    SequentialBump sequentialBump = new SequentialBump();

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 8",
            "3, 8",
            "8, 8",
            "9, 16",
            "12, 16",
            "15, 16",
            "21, 24",
            "24, 24"
    })
    public void memoryAlignmentTest(int input, int expected) {
        assertEquals(expected, sequentialBump.align(input));
    }

    @Test
    public void allocateFirstInput() {
        sequentialBump.allocate(3);
        assertEquals(8, sequentialBump.getTop());
    }

    @Test
    public void sequentialAllocation() {
        sequentialBump.allocate(3);
        assertEquals(8, sequentialBump.getTop());
        sequentialBump.allocate(5);
        assertEquals(16, sequentialBump.getTop());
        sequentialBump.allocate(12);
        assertEquals(32, sequentialBump.getTop());
    }

    @Test
    public void testOutOfMemoryException() {
        while (sequentialBump.getTop() != 1024) {
            sequentialBump.allocate(1);
        }

        assertThrows(OutOfMemoryError.class, () -> sequentialBump.allocate(1));
    }
}
