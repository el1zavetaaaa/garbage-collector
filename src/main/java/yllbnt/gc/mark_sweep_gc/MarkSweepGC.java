package yllbnt.gc.mark_sweep_gc;

import java.util.List;

public class MarkSweepGC {

    public void markSweepGC(List<MemoryBlock> heap, List<MemoryBlock> roots) {
        reset(heap);
        roots.forEach(root -> mark(root));
        sweep(heap);
    }

    private void reset(List<MemoryBlock> heap) {
        heap.forEach(block -> block.setLive(false));
    }

    private void mark(MemoryBlock root) {
        if (root == null) return;
        if (root.isLive()) return;

        root.setLive(true);
        mark(root.getLeft());
        mark(root.getRight());
    }

    private void sweep(List<MemoryBlock> heap) {
        heap.removeIf(memoryBlock -> !memoryBlock.isLive());
    }

}
