package youyihj.entryregistry.action.register;

import com.blamejared.crafttweaker.api.actions.IAction;
import com.blamejared.crafttweaker.api.logger.ILogger;
import net.minecraftforge.fml.LogicalSide;
import youyihj.entryregistry.EntryRegistry;

/**
 * @author youyihj
 */
public abstract class ActionRegisterBase implements IAction {
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
