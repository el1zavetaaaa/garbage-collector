package memory_allocator;

import org.junit.jupiter.api.Test;
import yllbnt.gc.memory_allocator.BestFit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestFitTest {
    private final BestFit bestFit = new BestFit();

    @Test
    public void allocateBestFit() {
        bestFit.implementBestFit(new int[]{100, 50, 30, 120, 35},
                new int[]{20, 60, 70, 40});

        assertEquals(2, bestFit.getAllocate()[0]); //20 => 30
        assertEquals(0, bestFit.getAllocate()[1]); //60 => 100
        assertEquals(3, bestFit.getAllocate()[2]); //70 => 120
        assertEquals(0, bestFit.getAllocate()[3]); //40 => 100 ( at this point in time 100 will be 100 - 60 from the first step)
    }
}
