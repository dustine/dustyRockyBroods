package dustine.dustyrockybroods.proxy;

import dustine.dustyrockybroods.item.ItemMeshFolder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

import java.util.Map;

public abstract class CommonProxy {
    /**
     * Returns an instance of EntityPlayerSP on client, null otherwise
     *
     * @return Instance of client's player entity, if any
     */
    public EntityPlayer getEntityPlayerSP() {
        return null;
    }

    public void clientInit() {

    }

    public void forceInventoryModels(Item itemFromBlock, Map<Integer, String> models) {

    }

    public void forceInventoryModels(Item item, ItemMeshFolder itemMesh) {

    }
}
