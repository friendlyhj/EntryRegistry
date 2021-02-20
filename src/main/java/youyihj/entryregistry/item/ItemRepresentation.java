package youyihj.entryregistry.item;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.action.item.ActionSetItemUse;
import youyihj.entryregistry.data.IDataGeneratorTarget;
import youyihj.entryregistry.function.IItemUse;

/**
 * @author youyihj
 */
@ZenRegister
@ZenCodeType.Name(EntryRegistry.ZC_HOME + "ItemRepresentation")
public class ItemRepresentation implements IDataGeneratorTarget {
    private final ItemBuilder builder;

    public IItemUse itemUse;

    public ItemRepresentation(ItemBuilder builder) {
        this.builder = builder;
    }

    public ItemBuilder getBuilder() {
        return builder;
    }

    @ZenCodeType.Method
    public ItemRepresentation setOnItemUse(IItemUse itemUse) {
        CraftTweakerAPI.apply(new ActionSetItemUse(this, itemUse));
        return this;
    }
}
