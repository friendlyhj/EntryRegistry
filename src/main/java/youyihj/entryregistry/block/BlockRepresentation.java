package youyihj.entryregistry.block;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.data.IDataGeneratorTarget;

/**
 * @author youyihj
 */
@ZenRegister
@ZenCodeType.Name(EntryRegistry.ZC_HOME + "BlockRepresentation")
public class BlockRepresentation implements IDataGeneratorTarget, IItemProvider {
    private final BlockBuilder builder;
    private BlockContent blockContent;

    public BlockRepresentation(BlockBuilder builder) {
        this.builder = builder;
    }

    public BlockBuilder getBuilder() {
        return builder;
    }

    public void setBlockContent(BlockContent blockContent) {
        if (this.blockContent == null) {
            this.blockContent = blockContent;
        }
    }

    @Override
    public Item asItem() {
        return blockContent.asItem();
    }
}
