package youyihj.entryregistry.item;

import net.minecraft.item.Item;

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
}
