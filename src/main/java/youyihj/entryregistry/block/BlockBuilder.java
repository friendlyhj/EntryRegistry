package youyihj.entryregistry.block;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.item.ItemBuilder;

/**
 * @author youyihj
 */
@ZenRegister
@ZenCodeType.Name(EntryRegistry.ZC_HOME + "BlockBuilder")
public class BlockBuilder {
    private final AbstractBlock.Properties properties;
    private final ItemBuilder itemBuilder;
    private final String name;

    @ZenCodeType.Constructor
    public BlockBuilder(String name, Material material, ItemBuilder itemBuilder) {
        this.name = name;
        this.properties = AbstractBlock.Properties.create(material).hardnessAndResistance(5.0f, 30.0f);
        if (!itemBuilder.getName().equals(this.name)) {
            throw new IllegalArgumentException("Item Builder Name must be equal to Block Builder!");
        }
        this.itemBuilder = itemBuilder;
    }

    @ZenCodeType.Constructor
    public BlockBuilder(String name, Material material) {
        this(name, material, new ItemBuilder(name));
    }

    public AbstractBlock.Properties getBlockProperties() {
        return properties;
    }

    public Item.Properties getItemProperties() {
        return itemBuilder.getItemProperties();
    }

    public String getName() {
        return name;
    }

    @ZenCodeType.Method
    public BlockRepresentation build() {
        return new BlockRepresentation(this);
    }
}
