package youyihj.entryregistry.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.block.BlockContent;
import youyihj.entryregistry.block.BlockItemContent;
import youyihj.entryregistry.data.DataGenerator;
import youyihj.entryregistry.item.ItemContent;


/**
 * @author youyihj
 */
public class ItemRegistry {
    private static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, EntryRegistry.MODID);

    public static void register(IEventBus bus) {
        REGISTER.register(bus);
    }

    public static void registerBlockItem(BlockContent block) {
        BlockItemContent blockItemContent = new BlockItemContent(block, block.getRepresentation().getBuilder().getItemProperties());
        DataGenerator.addToGenerateDataObject(blockItemContent);
        REGISTER.register(block.getRepresentation().getBuilder().getName(), () -> blockItemContent);
    }

    public static void registerItem(ItemContent item) {
        REGISTER.register(item.getRepresentation().getBuilder().getName(), () -> item);
    }
}
