package yllbnt.gc.memory_allocator;

public class BestFit {
    private int[] allocate;

    public void implementBestFit(int[] blocks, int[] processes) {
        initializeAllocate(processes);

        for (int i = 0; i < processes.length; i++) {
            int indexPlaced = -1;
            for (int j = 0; j < blocks.length; j++) {
                if (blocks[j] >= processes[i]) {
                    if (indexPlaced == -1) {
                        indexPlaced = j;
                    } else if (blocks[j] < blocks[indexPlaced]) {
                        indexPlaced = j;
                    }
                }
            }

            if (indexPlaced != -1) {
                allocate[i] = indexPlaced;
                blocks[indexPlaced] -= processes[i];
            }
        }
        printingResults(processes);
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

    public int[] getAllocate() {
        return allocate;
    }
}
