package dustine.dustyrockybroods.item;

import dustine.dustyrockybroods.DustyRockyBroods;
import dustine.dustyrockybroods.Reference;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Map;

@GameRegistry.ObjectHolder(value = Reference.MOD_ID)
public class ModItems {
    @GameRegistry.ObjectHolder(value = Reference.Name.Item.MEGASPORE)
    public static ItemMegaspore MEGASPORE;
    @GameRegistry.ObjectHolder(value = Reference.Name.Item.MICROSPORE)
    public static ItemMicrospore MICROSPORE;

    public static void init() {

    }

    private static void registerItem(RockyItem item, String name) {
        registerItem(item, name, (Map<Integer, String>) null);
    }

    private static void registerItem(RockyItem item, String name, Map<Integer, String> models) {
        item.setRegistryName(name);
        item.setUnlocalizedName(name);
        GameRegistry.register(item);

        DustyRockyBroods.PROXY.forceInventoryModels(item, models);
    }

    private static void registerItem(RockyItem item, String name, ItemMeshFolder itemMesh) {
        item.setRegistryName(name);
        item.setUnlocalizedName(name);
        GameRegistry.register(item);

        DustyRockyBroods.PROXY.forceInventoryModels(item, itemMesh);
    }
}
