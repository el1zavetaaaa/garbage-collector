package yllbnt.gc.memory_allocator.next_fit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoryBlock {
    private int blockNumber;
    private int size;
    private boolean isAllocated;
}
