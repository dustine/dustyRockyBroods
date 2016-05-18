package dustine.dustyrockybroods.spore.genome;

import com.google.common.collect.Range;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.List;

public class SporeChromosome implements INBTSerializable<NBTTagCompound> {
    public static List<Range<Double>> humidityRanges;
    public static int averageHumidityIndex;
    public static List<Range<Double>> temperatureRanges;
    public static int averageTemperatureIndex;
    public int germinationFactor;
    public int spreadFactor;
    public int spreadArea;
    public int lifespanFactor;
    public int fertility;
    public int humidityToleranceDown;
    public int humidityToleranceUp;
    public int humidityToleranceIndex;
    public int temperatureToleranceDown;
    public int temperatureToleranceUp;
    public int temperatureToleranceIndex;

    public GeneEffect effect;
    public int effectDuration;

    @Override

    public NBTTagCompound serializeNBT() {
        return null;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {

    }
}

