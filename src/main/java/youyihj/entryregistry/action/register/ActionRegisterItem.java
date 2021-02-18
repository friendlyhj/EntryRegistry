package youyihj.entryregistry.action.register;

import com.blamejared.crafttweaker.api.actions.IAction;
import com.blamejared.crafttweaker.api.logger.ILogger;
import net.minecraftforge.fml.LogicalSide;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.data.DataGenerator;
import youyihj.entryregistry.item.ItemContent;
import youyihj.entryregistry.item.ItemRepresentation;
import youyihj.entryregistry.registry.ItemRegistry;

/**
 * @author youyihj
 */
public class ActionRegisterItem implements IAction {
    private final ItemRepresentation representation;

    public ActionRegisterItem(ItemRepresentation representation) {
        this.representation = representation;
    }

    @Override
    public void apply() {
        ItemRegistry.registerItem(new ItemContent(representation));
        DataGenerator.addToGenerateDataObject(representation);
    }

    @Override
    public String describe() {
        return "Registering Item " + representation.getBuilder().getName();
    }

    @Override
    public boolean validate(ILogger logger) {
        if (EntryRegistry.allowRegisterContent) {
            return true;
        }
        logger.throwingErr("register the item too late! Registering must be done during #loader entryregistry!", new IllegalStateException());
        return false;
    }

    @Override
    public boolean shouldApplyOn(LogicalSide side) {
        return true;
    }
}
