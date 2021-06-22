package ml.luxinfine.regions.render;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;

public class OverlayRender
{

    public static OverlayRender INSTANCE = new OverlayRender();
    private String regionName;
    private int HEXColor;

    private OverlayRender()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setRegionName(String name, int HEXColor)
    {
        this.regionName = name;
        this.HEXColor = HEXColor;
    }

    @SubscribeEvent
    public void onDrawText(RenderGameOverlayEvent.Text event)
    {
        if(StringUtils.isNullOrEmpty(this.regionName)) return;
        FontRenderer fontRender = Minecraft.getMinecraft().fontRenderer;
        fontRender.drawString(this.regionName, event.resolution.getScaledWidth() / 2 - fontRender.getStringWidth(this.regionName) / 2, 0, this.HEXColor);
    }

}
