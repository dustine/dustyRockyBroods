package dustine.dustyrockybroods.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

import java.util.Map;

public class CommonProxy {
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

    public void forceInventoryModel(Item itemFromBlock, Map<Integer, String> models) {

    }
}
