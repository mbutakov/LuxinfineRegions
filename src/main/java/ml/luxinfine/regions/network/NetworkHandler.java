package ml.luxinfine.regions.network;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import io.netty.buffer.ByteBuf;
import ml.luxinfine.regions.render.CubeRender;
import ml.luxinfine.regions.render.OverlayRender;

public class NetworkHandler
{
    private static final FMLEventChannel CHANNEL = NetworkRegistry.INSTANCE.newEventDrivenChannel("regions");

    private NetworkHandler() {}

    public static void init()
    {
        CHANNEL.register(new NetworkHandler());
    }

    @SubscribeEvent
    public void onPacket(FMLNetworkEvent.ClientCustomPacketEvent event)
    {
        ByteBuf buffer = event.packet.payload();
        switch (buffer.readByte())
        {
            case 0:
                CubeRender.INSTANCE.selection.setFirstPoint(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
                break;
            case 1:
                CubeRender.INSTANCE.selection.setSecondPoint(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
                break;
            case 2:
                CubeRender.INSTANCE.selection.reset();
                break;
            case 3:
                OverlayRender.INSTANCE.setRegionName(ByteBufUtils.readUTF8String(buffer), buffer.readInt());
                break;
        }
    }

}
