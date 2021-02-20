package youyihj.entryregistry.action.item;

import com.blamejared.crafttweaker.api.actions.IUndoableAction;
import net.minecraftforge.fml.LogicalSide;
import youyihj.entryregistry.item.ItemRepresentation;

/**
 * @author youyihj
 */
public abstract class ActionSetItemFunctionBase<T> implements IUndoableAction {
    protected final ItemRepresentation representation;
    protected final T function;

    public ActionSetItemFunctionBase(ItemRepresentation representation, T function) {
        this.representation = representation;
        this.function = function;
    }

    @Override
    public String describe() {
        return "Setting function " + function.getClass().getInterfaces()[0].getName() + " of item representation " + representation.getBuilder().getName();
    }

    @Override
    public String describeUndo() {
        return "Undo function " + function.getClass().getInterfaces()[0].getName() + " of item representation " + representation.getBuilder().getName();
    }

    @Override
    public boolean shouldApplyOn(LogicalSide side) {
        return true;
    }
}
