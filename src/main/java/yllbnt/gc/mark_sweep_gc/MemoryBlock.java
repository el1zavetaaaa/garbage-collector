package yllbnt.gc.mark_sweep_gc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoryBlock {
    private boolean isLive;
    private String name;
    private MemoryBlock left;
    private MemoryBlock right;

    public MemoryBlock(String name) {
        this.name = name;
    }
}
