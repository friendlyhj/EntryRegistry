package youyihj.entryregistry.action.register;

import youyihj.entryregistry.block.BlockContent;
import youyihj.entryregistry.block.BlockRepresentation;
import youyihj.entryregistry.data.DataGenerator;
import youyihj.entryregistry.registry.BlockRegistry;

/**
 * @author youyihj
 */
public class ActionRegisterBlock extends ActionRegisterBase {
    private final BlockRepresentation representation;

    public ActionRegisterBlock(BlockRepresentation representation) {
        this.representation = representation;
    }

    @Override
    public void apply() {
        BlockContent blockContent = new BlockContent(representation);
        BlockRegistry.registerBlock(blockContent);
        representation.setBlockContent(blockContent);
        DataGenerator.addToGenerateDataObject(representation);
    }

    @Override
    public String describe() {
        return "Registering Block: " + representation.getBuilder().getName();
    }
}
