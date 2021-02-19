package youyihj.entryregistry.item;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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

    public String getName() {
        return name;
    }

    @ZenCodeType.Method
    public void buildAndRegister() {
        CraftTweakerAPI.apply(new ActionRegisterItem(new ItemRepresentation(this)));
    }
}
