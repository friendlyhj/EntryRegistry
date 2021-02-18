package youyihj.entryregistry.block;

import net.minecraft.block.Block;

/**
 * @author youyihj
 */
public class BlockContent extends Block {
    private final BlockRepresentation representation;

    public BlockContent(BlockRepresentation representation) {
        super(representation.getBuilder().getBlockProperties());
        this.representation = representation;
    }

    public BlockRepresentation getRepresentation() {
        return representation;
    }
}
