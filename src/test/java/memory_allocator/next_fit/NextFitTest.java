package memory_allocator.next_fit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yllbnt.gc.memory_allocator.next_fit.MemoryBlock;
import yllbnt.gc.memory_allocator.next_fit.NextFit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextFitTest {
    NextFit allocator = new NextFit();


    @BeforeEach
    public void setUp() {
        allocator.addMemoryBlock(generateMemoryBlock(1, 35));
        allocator.addMemoryBlock(generateMemoryBlock(2, 50));
        allocator.addMemoryBlock(generateMemoryBlock(3, 100));
        allocator.addMemoryBlock(generateMemoryBlock(4, 120));
        allocator.addMemoryBlock(generateMemoryBlock(5, 30));
        // 35 (20), 50 (-), 100 (60), 120 (70), 40 => will then go to 50
    }

    @Test
    public void implementNextFit() {
        allocator.implementNextFit(new int[]{20, 60, 70, 40});

        assertEquals(0, allocator.getAllocate()[0]); // 35 (20)
        assertEquals(2, allocator.getAllocate()[1]); // 50 (1st cycle: -; 2nd cycle: 40)
        assertEquals(3, allocator.getAllocate()[2]); // 100 (60)
        assertEquals(1, allocator.getAllocate()[3]); // 120 (70)
    }

    private MemoryBlock generateMemoryBlock(final int blockNumber, final int blockSize) {
        MemoryBlock block = new MemoryBlock();
        block.setBlockNumber(blockNumber);
        block.setSize(blockSize);
        block.setAllocated(false);
        return block;
    }
}
