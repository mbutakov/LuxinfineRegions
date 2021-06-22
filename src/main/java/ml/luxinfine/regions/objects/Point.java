package ml.luxinfine.regions.objects;

import ml.luxinfine.regions.Config;
import ml.luxinfine.regions.render.RenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;

public class Point
{

    private final Minecraft mc = Minecraft.getMinecraft();

    public ChunkCoordinates coord;
    public int worldID;
    private final boolean isFirst;

    public Point(boolean isFirst)
    {
        this.isFirst = isFirst;
    }

    public void render(double offsetX, double offsetY, double offsetZ)
    {
        if (this.isValid())
        {
            AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(this.coord.posX, this.coord.posY, this.coord.posZ, (double)this.coord.posX + 1.0D, (double)this.coord.posY + 1.0D, (double)this.coord.posZ + 1.0D).expand(0.02D, 0.02D, 0.02D).offset(-offsetX, -offsetY, -offsetZ);
            RenderHelper.drawBox(aabb, this.isFirst ? Config.first_point_colour : Config.second_point_colour, this.isFirst ? Config.first_point_opaque : Config.second_point_opaque);
        }
    }

    public boolean isValid()
    {
        return this.coord != null && this.mc.theWorld != null && this.mc.theWorld.provider.dimensionId == this.worldID;
    }

}
