package dustine.dustyrockybroods.network.message;

import dustine.dustyrockybroods.DustyRockyBroods;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public abstract class MessageBase<T extends MessageBase> implements IMessageHandler<T, IMessage>, IMessage {
    @Override
    public IMessage onMessage(T message, MessageContext ctx) {
        switch (ctx.side) {
            case CLIENT:
                onClientSide(message, DustyRockyBroods.PROXY.getEntityPlayerSP());
                break;
            case SERVER:
                onServerSide(message, ctx.getServerHandler().playerEntity);
                break;
        }

        return null;
    }

    protected abstract void onClientSide(T message, EntityPlayer player);

    protected abstract void onServerSide(T message, EntityPlayer player);
}
