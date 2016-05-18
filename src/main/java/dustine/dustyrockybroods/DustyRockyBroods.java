package dustine.dustyrockybroods;

import dustine.dustyrockybroods.block.ModBlocks;
import dustine.dustyrockybroods.event.ModEvents;
import dustine.dustyrockybroods.item.ModItems;
import dustine.dustyrockybroods.network.ModNetwork;
import dustine.dustyrockybroods.proxy.CommonProxy;
import dustine.dustyrockybroods.tile.ModTiles;
import dustine.dustyrockybroods.utility.ModConfig;
import dustine.dustyrockybroods.utility.ModLogger;
import dustine.dustyrockybroods.utility.ModRecipes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.Name.MOD, version = "@VERSION@")
public class DustyRockyBroods {
    @Mod.Instance
    public static DustyRockyBroods INSTANCE;

    @SidedProxy(modId = Reference.MOD_ID, clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy PROXY;

    public static CreativeTabs CREATIVE_TAB = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return null;
        }
    };

    public void preInit(FMLPreInitializationEvent event) {
        ModLogger.init(event);
        ModConfig.init(event);
        ModNetwork.init();

        ModItems.init();
        ModBlocks.init();
        ModTiles.init();
        PROXY.clientInit();

        ModEvents.init();
    }

    public void init(FMLInitializationEvent event) {
        ModRecipes.init();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
