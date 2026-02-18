package memory_allocator;

import org.junit.jupiter.api.Test;
import yllbnt.gc.memory_allocator.FirstFit;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstFitTest {
    private final FirstFit firstFit = new FirstFit();

    @Test
    public void allocateFirstFit() {
        firstFit.implementFirstFit(new int[]{100, 50, 30, 120, 35},
                new int[]{20, 60, 70, 40});

        assertEquals(3, Arrays.stream(firstFit.getOccupied()).filter(val -> val > 0).count());
        assertEquals(-1, firstFit.getAllocate()[2]); //firstFit.getAllocate()[2] = 70 from processes array
    }

    @Test
    public void allocateFirstFitShareBlocks() {
        firstFit.implementFirstFitShareBlocks(new int[]{100, 50, 30, 120, 35},
                new int[]{20, 60, 70, 40});

        assertEquals(3, Arrays.stream(firstFit.getOccupied()).filter(val -> val > 0).count());
        assertEquals(0, firstFit.getAllocate()[0]); // 20 stored in the first block - 100
        assertEquals(0, firstFit.getAllocate()[1]); // 60 stored in the first block - 100
        assertEquals(3, firstFit.getAllocate()[2]); // 70 stored in the fourth block - 120
        assertEquals(1, firstFit.getAllocate()[3]); // 40 stored in the second block - 50
    }
}
