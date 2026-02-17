package yllbnt.gc.memory_allocator;

public class Block {

    private int size;
    private boolean used;
    private Block next;
    private int dataOffset;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public Block getNext() {
        return next;
    }

    public void setNext(Block next) {
        this.next = next;
    }

    public int getDataOffset() {
        return dataOffset;
    }

    public void setDataOffset(int dataOffset) {
        this.dataOffset = dataOffset;
    }
}
