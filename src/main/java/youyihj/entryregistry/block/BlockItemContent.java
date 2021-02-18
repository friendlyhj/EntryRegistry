package youyihj.entryregistry.block;

import net.minecraft.item.BlockItem;
import youyihj.entryregistry.data.IDataGeneratorTarget;

/**
 * @author youyihj
 */
public class BlockItemContent extends BlockItem implements IDataGeneratorTarget {
    public final BlockContent blockContent;

    public BlockItemContent(BlockContent blockIn, Properties builder) {
        super(blockIn, builder);
        this.blockContent = blockIn;
    }
}
