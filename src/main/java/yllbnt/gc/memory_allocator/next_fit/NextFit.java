package yllbnt.gc.memory_allocator.next_fit;

import java.util.ArrayList;
import java.util.List;

public class NextFit {
    private int[] allocate;
    private List<MemoryBlock> memoryBlocks;
    private int lastIndex;

    public NextFit() {
        this.memoryBlocks = new ArrayList<>();
        this.lastIndex = -1;
    }

    public void addMemoryBlock(final MemoryBlock memoryBlock) {
        this.memoryBlocks.add(memoryBlock);
    }

    public void implementNextFit(int[] processes) {
        int memoryBlocksSize = memoryBlocks.size();
        initializeAllocate(processes);

        for (int j = 0; j < processes.length; j++) {
            int i = lastIndex + 1;
            do {
                if (!memoryBlocks.get(i).isAllocated() && memoryBlocks.get(i).getSize() >= processes[j]) {
                    memoryBlocks.get(i).setAllocated(true);
                    lastIndex = i;
                    allocate[j] = i;
                    break;
                }

                i = (i + 1) % memoryBlocksSize;
            } while (i != lastIndex + 1);
        }

        printingResults(processes);
    }

    public int[] getAllocate() {
        return allocate;
    }

    private void initializeAllocate(int[] processes) {
        allocate = new int[processes.length];
        for (int i = 0; i < allocate.length; i++) {
            allocate[i] = -1;
        }
    }

    private void printingResults(int[] processes) {
        System.out.println("\nProcess No.\tProcess Size\tBlock no.\n");
        for (int i = 0; i < processes.length; i++) {
            System.out.print((i + 1) + "\t\t\t" + processes[i] + "\t\t\t\t");
            if (allocate[i] != -1)
                System.out.println(allocate[i] + 1);
            else
                System.out.println("Not Allocated");
        }
    }
}
