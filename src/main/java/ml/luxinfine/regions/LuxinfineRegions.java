package ml.luxinfine.regions;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import ml.luxinfine.regions.network.NetworkHandler;

//mbfix
@Mod(modid = "regions", name = "LuxinfineRegions")
public class LuxinfineRegions
{

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        NetworkHandler.init();
    }

}
