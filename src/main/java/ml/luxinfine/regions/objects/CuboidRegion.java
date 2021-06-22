package ml.luxinfine.regions.objects;

import ml.luxinfine.regions.Config;
import ml.luxinfine.regions.render.RenderHelper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;

public class CuboidRegion
{

    private final Point first = new Point(true);
    private final Point second = new Point(false);

    public void render(double offsetX, double offsetY, double offsetZ)
    {
        this.first.render(offsetX, offsetY, offsetZ);
        this.second.render(offsetX, offsetY, offsetZ);
        if (this.first.isValid() && this.second.isValid())
            this.renderOutline(offsetX, offsetY, offsetZ);
    }

    private void renderOutline(double offsetX, double offsetY, double offsetZ)
    {
        double offset = 0.03D;
        int minX = Math.min(this.first.coord.posX, this.second.coord.posX);
        int minY = Math.min(this.first.coord.posY, this.second.coord.posY);
        int minZ = Math.min(this.first.coord.posZ, this.second.coord.posZ);
        int maxX = Math.max(this.first.coord.posX, this.second.coord.posX) + 1;
        int maxY = Math.max(this.first.coord.posY, this.second.coord.posY) + 1;
        int maxZ = Math.max(this.first.coord.posZ, this.second.coord.posZ) + 1;
        AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(minX, minY, minZ, maxX, maxY, maxZ).expand(offset, offset, offset).offset(-offsetX, -offsetY, -offsetZ);
        RenderHelper.drawBox(aabb, Config.selection_colour, Config.selection_opaque);
    }

    public boolean isSelected()
    {
        return this.first.isValid() || this.second.isValid();
    }

    public void setFirstPoint(int worldID, int x, int y, int z)
    {
        this.first.coord = new ChunkCoordinates(x, y, z);
        this.first.worldID = worldID;
    }

    public void setSecondPoint(int worldID, int x, int y, int z)
    {
        this.second.coord = new ChunkCoordinates(x, y, z);
        this.second.worldID = worldID;
    }

    public void reset()
    {
        this.first.coord = this.second.coord = null;
    }

}
