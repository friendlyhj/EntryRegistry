package youyihj.entryregistry.block;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.action.register.ActionRegisterBlock;
import youyihj.entryregistry.item.ItemBuilder;
import youyihj.entryregistry.item.MCItemGroup;

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
            throw new IllegalArgumentException("Item Builder name must be equal to Block Builder!");
        }
        this.itemBuilder = itemBuilder;
    }

    @ZenCodeType.Constructor
    public BlockBuilder(String name, Material material) {
        this(name, material, new ItemBuilder(name));
    }

    @ZenCodeType.Getter("name")
    public String getName() {
        return name;
    }

    @ZenCodeType.Method
    public BlockBuilder doesNotBlockMovement() {
        properties.doesNotBlockMovement();
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder notSolid() {
        properties.notSolid();
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder harvestLevel(int level) {
        properties.harvestLevel(level);
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder harvestTool(String toolType) {
        properties.harvestTool(ToolType.get(toolType));
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder slipperiness(float slipperiness) {
        properties.slipperiness(slipperiness);
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder speedFactor(float factor) {
        properties.speedFactor(factor);
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder jumpFactor(float factor) {
        properties.jumpFactor(factor);
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder setLightLevel(int lightLevel) {
        // TODO: BlockState support
        properties.setLightLevel((state) -> lightLevel);
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder hardnessAndResistance(float hardness, float resistance) {
        properties.hardnessAndResistance(hardness, resistance);
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder zeroHardnessAndResistance() {
        properties.zeroHardnessAndResistance();
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder tickRandomly() {
        properties.tickRandomly();
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder variableOpacity() {
        properties.variableOpacity();
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder noDrops() {
        properties.noDrops();
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder setAir() {
        properties.setAir();
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder setRequiresTool() {
        properties.setRequiresTool();
        return this;
    }

    @ZenCodeType.Method
    public BlockBuilder group(MCItemGroup group) {
        itemBuilder.group(group);
        return this;
    }

    // TODO: sound

    @ZenCodeType.Method
    public void buildAndRegister() {
        CraftTweakerAPI.apply(new ActionRegisterBlock(new BlockRepresentation(this)));
    }

    public AbstractBlock.Properties getBlockProperties() {
        return properties;
    }

    public Item.Properties getItemProperties() {
        return itemBuilder.getItemProperties();
    }
}
