package dustine.dustyrockybroods.spore;

import dustine.dustyrockybroods.spore.SporeSpecies;
import dustine.dustyrockybroods.utility.ModLogger;

import java.util.HashMap;

public class SporeRegistry {
    private static final HashMap<String, SporeSpecies> SPECIES_MAP = new HashMap<>();

    public static void addSporeSpecies(SporeSpecies species) {
        if (SPECIES_MAP.containsKey(species.getName())) {
            ModLogger.warn("Repeated species added with key %s, ignored", species.getName());
            return;
        }
        SPECIES_MAP.put(species.getName(), species);
    }

    public static SporeSpecies getSporeSpecies(String species) {
        return SPECIES_MAP.getOrDefault(species, null);
    }
}
