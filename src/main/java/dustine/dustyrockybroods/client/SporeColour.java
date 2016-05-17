package dustine.dustyrockybroods.client;

import dustine.dustyrockybroods.spore.SporeSpecies;
import dustine.dustyrockybroods.utility.SporeHelper;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class SporeColour implements IItemColor {
    @Override
    public int getColorFromItemstack(ItemStack stack, int tintIndex) {
        final NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound.hasKey("species")) {
            final SporeSpecies species = SporeHelper.getSporeSpecies(tagCompound.getString("species"));
            if (species == null) return -1;

            switch (tintIndex) {
                case 0:
                    return species.getMainColor();
                case 1:
                    return species.getSecondaryColor();
            }
        }
        return -1;
    }
}
