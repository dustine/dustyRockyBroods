package dustine.dustyrockybroods.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy extends CommonProxy {
    @Override
    public EntityPlayer getEntityPlayerSP() {
        return Minecraft.getMinecraft().thePlayer;
    }
}
