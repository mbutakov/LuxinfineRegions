package ml.luxinfine.regions.render;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import ml.luxinfine.regions.objects.CuboidRegion;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

public class CubeRender
{

    public static final CubeRender INSTANCE = new CubeRender();
    public final CuboidRegion selection = new CuboidRegion();

    private CubeRender()
    {
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);
    }

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event)
    {
    	GL11.glPushMatrix();
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        double offsetX = player.lastTickPosX + (player.posX - player.lastTickPosX) * (double)event.partialTicks;
        double offsetY = player.lastTickPosY + (player.posY - player.lastTickPosY) * (double)event.partialTicks;
        double offsetZ = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * (double)event.partialTicks;
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPushMatrix();
        GL11.glDepthMask(false);
        GL11.glDisable(3008);
        GL11.glPolygonOffset(-3.0F, -3.0F);
        GL11.glEnable(32823);
        GL11.glEnable(3008);
        GL11.glDisable(3553);
        GL11.glEnable(2912);
        if (this.selection.isSelected())
        {
            GL11.glLineWidth(3.0F);
            GL11.glDisable(2929);
            this.selection.render(offsetX, offsetY, offsetZ);
            GL11.glEnable(2929);
        }
        GL11.glDisable(2912);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(3008);
        GL11.glPolygonOffset(0.0F, 0.0F);
        GL11.glDisable(32823);
        GL11.glEnable(3008);
        GL11.glDepthMask(true);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    @SubscribeEvent
    public void onDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent event)
    {
        this.selection.reset();
    }

}
