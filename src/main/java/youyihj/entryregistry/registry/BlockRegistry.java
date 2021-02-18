package youyihj.entryregistry.registry;

import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.block.BlockContent;

/**
 * @author youyihj
 */
public class BlockRegistry {
    private static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, EntryRegistry.MODID);

    public static void register(IEventBus bus) {
        REGISTER.register(bus);
    }

    public static void registerBlock(BlockContent block) {
        REGISTER.register(block.getRepresentation().getBuilder().getName(), () -> block);
        ItemRegistry.registerBlockItem(block);
    }
}
