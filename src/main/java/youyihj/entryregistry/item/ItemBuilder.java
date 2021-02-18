package youyihj.entryregistry.item;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.item.Item;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.entryregistry.EntryRegistry;

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
        this.properties = new Item.Properties();
    }

    public Item.Properties getItemProperties() {
        return properties;
    }

    public String getName() {
        return name;
    }

    @ZenCodeType.Method
    public ItemRepresentation build() {
        return new ItemRepresentation(this);
    }
}
