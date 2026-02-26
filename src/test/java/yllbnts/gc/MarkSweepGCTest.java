package yllbnts.gc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yllbnt.gc.mark_sweep_gc.MarkSweepGC;
import yllbnt.gc.mark_sweep_gc.MemoryBlock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MarkSweepGCTest {

    final MarkSweepGC markSweepGC = new MarkSweepGC();
    private final List<MemoryBlock> heap = new ArrayList<>();
    private final List<MemoryBlock> roots = new ArrayList<>();
    private final MemoryBlock A = new MemoryBlock("A");
    private final MemoryBlock B = new MemoryBlock("B");
    private final MemoryBlock C = new MemoryBlock("C");
    private final MemoryBlock D = new MemoryBlock("D");
    private final MemoryBlock E = new MemoryBlock("E");
    private final MemoryBlock F = new MemoryBlock("F");
    private final MemoryBlock G = new MemoryBlock("G");
    private final MemoryBlock H = new MemoryBlock("H");

    @BeforeEach
    public void setUp() {
        A.setLeft(B);

        heap.add(A);
        heap.add(B);
        heap.add(C);
        heap.add(D);
        heap.add(E);
        heap.add(F);
        heap.add(G);
        heap.add(H);

        roots.add(A);
    }

    @Test
    public void testMarkSweepGC() {
        assertEquals(8, heap.size());
        markSweepGC.markSweepGC(heap, roots);

        assertEquals(2, heap.size());
        assertTrue(A.isLive());
        assertTrue(B.isLive());
        assertFalse(C.isLive());
        assertFalse(D.isLive());
        assertFalse(E.isLive());
        assertFalse(F.isLive());
        assertFalse(G.isLive());
        assertFalse(H.isLive());
    }
}
