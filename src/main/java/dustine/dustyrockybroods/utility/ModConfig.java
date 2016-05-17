package dustine.dustyrockybroods.utility;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModConfig {
    private static Configuration CONFIG;

    public static void init(FMLPreInitializationEvent event) {
        if (CONFIG == null) {
            CONFIG = new Configuration(event.getSuggestedConfigurationFile());
        }
    }
}
