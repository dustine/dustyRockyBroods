package dustine.dustyrockybroods.network;

import dustine.dustyrockybroods.Reference;
import dustine.dustyrockybroods.network.message.MessageBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class ModNetwork {
    private static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    public static void init() {
    }

    public static void sendTo(MessageBase message, EntityPlayerMP player) {
        INSTANCE.sendTo(message, player);
    }

    public static void sendToServer(MessageBase message) {
        INSTANCE.sendToServer(message);
    }

    public static void sendToAll(MessageBase message) {
        INSTANCE.sendToAll(message);
    }

    public static void sendToDimension(MessageBase message, int dimension) {
        INSTANCE.sendToDimension(message, dimension);
    }

    public static void sendToAllAround(MessageBase message, NetworkRegistry.TargetPoint point) {
        INSTANCE.sendToAllAround(message, point);
    }
}
