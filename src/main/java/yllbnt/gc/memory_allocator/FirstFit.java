package yllbnt.gc.memory_allocator;

import lombok.Getter;

@Getter
public class FirstFit {
    private int[] allocate;
    private int[] occupied;

    public void implementFirstFit(int[] blocks, int[] processes) {
        initializeAllocate(processes);
        initializeOccupied(blocks);

        for (int i = 0; i < processes.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if (!(occupied[j] > 0) && blocks[j] >= processes[i]) {
                    allocate[i] = j;
                    occupied[j] = processes[i];

                    break;
                }
            }
        }

        printingResults(processes);
    }

    public void implementFirstFitShareBlocks(int[] blocks, int[] processes) {
        initializeAllocate(processes);
        initializeOccupied(blocks);

        for (int i = 0; i < processes.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if (blocks[j] >= occupied[j] + processes[i]) {
                    allocate[i] = j;
                    occupied[j] += processes[i];

                    break;
                }
            }
        }

        printingResults(processes);

    }

    private void initializeAllocate(int[] processes){
        allocate = new int[processes.length];
        for (int i = 0; i < allocate.length; i++) {
            allocate[i] = -1;
        }
    }

    private void initializeOccupied(int[] blocks){
        occupied = new int[blocks.length];

        for (int i = 0; i < occupied.length; i++) {
            occupied[i] = 0;
        }
    }

    private void printingResults(int[] processes){
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
