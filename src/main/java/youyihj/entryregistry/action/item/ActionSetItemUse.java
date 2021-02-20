package youyihj.entryregistry.action.item;

import youyihj.entryregistry.function.IItemUse;
import youyihj.entryregistry.item.ItemRepresentation;

/**
 * @author youyihj
 */
public class ActionSetItemUse extends ActionSetItemFunctionBase<IItemUse> {
    public ActionSetItemUse(ItemRepresentation representation, IItemUse function) {
        super(representation, function);
    }

    @Override
    public void undo() {
        representation.itemUse = null;
    }

    @Override
    public void apply() {
        representation.itemUse = function;
    }
}
