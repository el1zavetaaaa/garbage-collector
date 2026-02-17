package yllbnt.gc.memory_allocator;

import lombok.Getter;

@Getter
public class SequentialBump {
    private static final int WORD_SIZE = 8;
    private byte[] heap = new byte[1024];

    private int heapStart = 0;
    private int top = 0;

    // if user data is of size 3 bytes
    // it should be aligned by the size of machine word (usually 8 bytes)
    // to 8 bytes
    public int align(int n) {
        return (n + WORD_SIZE - 1) & ~(WORD_SIZE - 1);
    }

    // sequential bump allocator.
    // Each time we want to allocate a user payload of specified size
    // we check whether there is enough space on the heap
    // if there is enough space we move the pointer to the ned of the added space
    // return the start of the space
    public int allocate(int size) {
        size = align(size);
        int start = top;

        if (top + size > heap.length) {
            throw new OutOfMemoryError("There is not enough memory to allocate an object");
        } else {
            top += size;
        }

        return start;
    }

}
