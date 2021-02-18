package youyihj.entryregistry;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.ScriptLoadingOptions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import youyihj.entryregistry.data.DataGenerator;
import youyihj.entryregistry.data.IDataWriter;
import youyihj.entryregistry.registry.BlockRegistry;
import youyihj.entryregistry.registry.ItemRegistry;

import java.io.IOException;

@Mod(EntryRegistry.MODID)
public class EntryRegistry
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "entryregistry";
    public static final String ZC_HOME = "mods." + MODID + ".";

    public static boolean allowRegisterContent = true;

    public EntryRegistry() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);
        eventBus.addGenericListener(Block.class, EventPriority.HIGHEST, this::loadScript);
        eventBus.addGenericListener(Item.class, EventPriority.LOWEST, this::generateData);

        MinecraftForge.EVENT_BUS.register(this);

        DataGenerator.addWriter(IDataWriter.Item.INSTANCE);
        DataGenerator.addWriter(IDataWriter.Meta.INSTANCE);
        DataGenerator.addWriter(IDataWriter.Block.INSTANCE);
        DataGenerator.addWriter(IDataWriter.BlockItem.INSTANCE);

        DataGenerator.addToGenerateDataObject(IDataWriter.Meta.INSTANCE);

        ItemRegistry.register(eventBus);
        BlockRegistry.register(eventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void loadScript(RegistryEvent<Block> event) {
        CraftTweakerAPI.loadScripts(new ScriptLoadingOptions().setLoaderName("entryregistry").execute());
        allowRegisterContent = false;
    }

    private void generateData(RegistryEvent<Item> event) {
        try {
            DataGenerator.generate();
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
