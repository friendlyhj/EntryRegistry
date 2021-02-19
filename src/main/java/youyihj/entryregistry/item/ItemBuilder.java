package youyihj.entryregistry.item;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.ToolType;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.action.register.ActionRegisterItem;

/**
 * @author youyihj
 */
@ZenRegister
@ZenCodeType.Name(EntryRegistry.ZC_HOME + "ItemBuilder")
public class ItemBuilder {
    private final Item.Properties properties;
    private final String name;

    @ZenCodeType.Constructor
    public ItemBuilder(String name) {
        this.name = name;
        this.properties = new Item.Properties().group(ItemGroup.MISC);
    }

    public Item.Properties getItemProperties() {
        return properties;
    }

    @ZenCodeType.Getter("name")
    public String getName() {
        return name;
    }

    @ZenCodeType.Method
    public ItemBuilder maxStackSize(int maxStackSize) {
        properties.maxStackSize(maxStackSize);
        return this;
    }

    @ZenCodeType.Method
    public ItemBuilder defaultMaxDamage(int defaultMaxDamage) {
        properties.defaultMaxDamage(defaultMaxDamage);
        return this;
    }

    @ZenCodeType.Method
    public ItemBuilder maxDamage(int maxDamage) {
        properties.maxDamage(maxDamage);
        return this;
    }

    @ZenCodeType.Method
    public ItemBuilder group(MCItemGroup groupIn) {
        properties.group(groupIn.getInternal());
        return this;
    }

    @ZenCodeType.Method
    public ItemBuilder rarity(String rarity) {
        properties.rarity(Rarity.valueOf(rarity));
        return this;
    }

    @ZenCodeType.Method
    public ItemBuilder isImmuneToFire() {
        properties.isImmuneToFire();
        return this;
    }

    @ZenCodeType.Method
    public ItemBuilder setNoRepair() {
        properties.setNoRepair();
        return this;
    }

    @ZenCodeType.Method
    public ItemBuilder addToolType(String toolType, int level) {
        properties.addToolType(ToolType.get(toolType), level);
        return this;
    }

    // TODO: food and containerItem

    @ZenCodeType.Method
    public void buildAndRegister() {
        CraftTweakerAPI.apply(new ActionRegisterItem(new ItemRepresentation(this)));
    }
}
