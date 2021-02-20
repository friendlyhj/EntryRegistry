package youyihj.entryregistry.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;

/**
 * @author youyihj
 */
public class ItemContent extends Item {
    private final ItemRepresentation representation;

    public ItemContent(ItemRepresentation representation) {
        super(representation.getBuilder().getItemProperties());
        this.representation = representation;
    }

    public ItemRepresentation getRepresentation() {
        return representation;
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        if (representation.itemUse == null) {
            return super.onItemUse(context);
        } else {
            return ActionResultType.valueOf(representation.itemUse.apply(context));
        }
    }
}
