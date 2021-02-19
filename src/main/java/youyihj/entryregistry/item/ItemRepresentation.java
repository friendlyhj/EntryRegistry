package youyihj.entryregistry.item;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.data.IDataGeneratorTarget;

/**
 * @author youyihj
 */
@ZenRegister
@ZenCodeType.Name(EntryRegistry.ZC_HOME + "ItemRepresentation")
public class ItemRepresentation implements IDataGeneratorTarget {
    private final ItemBuilder builder;

    public ItemRepresentation(ItemBuilder builder) {
        this.builder = builder;
    }

    public ItemBuilder getBuilder() {
        return builder;
    }
}
