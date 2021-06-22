package ml.luxinfine.regions;

import ml.luxinfine.config.ConfigFloat;
import ml.luxinfine.config.ConfigString;

@ml.luxinfine.config.Config(name = "LuxinfineRegions")
public class Config
{

    @ConfigString(syncable = true)
    public static String selection_colour = "#000000";

    @ConfigString(syncable = true)
    public static String first_point_colour = "#b42b0b";

    @ConfigString(syncable = true)
    public static String second_point_colour = "#b42b0b";

    @ConfigFloat(syncable = true, min = 0F, max = 1F)
    public static float selection_opaque = 0.25F;

    @ConfigFloat(syncable = true, min = 0F, max = 1F)
    public static float first_point_opaque = 0.5F;

    @ConfigFloat(syncable = true, min = 0F, max = 1F)
    public static float second_point_opaque = 0.5F;

}
