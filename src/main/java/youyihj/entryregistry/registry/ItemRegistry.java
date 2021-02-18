package youyihj.entryregistry.registry;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.item.ItemContent;


/**
 * @author youyihj
 */
public class ItemRegistry {
    private static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, EntryRegistry.MODID);

    public static void register(IEventBus bus) {
        REGISTER.register(bus);
    }

//    public static void registerBlockItem(BlockContent block) {
//        REGISTER.register(blockBase.getName(), blockBase.getBlockItemSupplier());
//    }

    public static void registerItem(ItemContent item) {
        REGISTER.register(item.getRepresentation().getBuilder().getName(), () -> item);
    }
}
