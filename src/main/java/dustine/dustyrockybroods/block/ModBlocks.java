package dustine.dustyrockybroods.block;

import dustine.dustyrockybroods.DustyRockyBroods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Map;

public class ModBlocks {
    public static void init() {

    }

    private static void registerBlock(RockyBlock block, String name) {
        registerBlock(block, name, null, null);
    }

    private static void registerBlock(RockyBlock block, String name, Map<Integer, String> models) {
        registerBlock(block, name, new ItemBlock(block), models);
    }

    private static void registerBlock(RockyBlock block, String name, ItemBlock itemBlock, Map<Integer, String> models) {
        block.setRegistryName(name);
        block.setUnlocalizedName(name);
        GameRegistry.register(block);

        // allows for blocks to not have an
        if (itemBlock != null) {
            if (itemBlock.getRegistryName() == null) {
                itemBlock.setRegistryName(block.getRegistryName());
            }
            itemBlock.setUnlocalizedName(block.getUnlocalizedName());
            GameRegistry.register(itemBlock);

            DustyRockyBroods.PROXY.forceInventoryModel(Item.getItemFromBlock(block), models);
        }
    }
}
