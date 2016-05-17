package dustine.dustyrockybroods.item;

import dustine.dustyrockybroods.DustyRockyBroods;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Map;

public class ModItems {
    public static void init() {

    }

    private static void registerItem(RockyItem item, String name) {
        registerItem(item, name, null);
    }

    private static void registerItem(RockyItem item, String name, Map<Integer, String> models) {
        item.setRegistryName(name);
        item.setUnlocalizedName(name);
        GameRegistry.register(item);

        DustyRockyBroods.PROXY.forceInventoryModel(item, models);
    }
}
