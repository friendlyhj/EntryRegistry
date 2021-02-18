package youyihj.entryregistry.action.register;

import youyihj.entryregistry.data.DataGenerator;
import youyihj.entryregistry.item.ItemContent;
import youyihj.entryregistry.item.ItemRepresentation;
import youyihj.entryregistry.registry.ItemRegistry;

/**
 * @author youyihj
 */
public class ActionRegisterItem extends ActionRegisterBase {
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
}
