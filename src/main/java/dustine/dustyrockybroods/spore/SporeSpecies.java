package dustine.dustyrockybroods.spore;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;

public class SporeSpecies {
    private final ResourceLocation lootTable;
    private final String name;
    private final int mainColor;
    private final int secondaryColor;

    public SporeSpecies(String name, Color main, Color secondary, ResourceLocation lootTable) {
        this.name = name;
        this.mainColor = main.getRGB();
        this.secondaryColor = secondary.getRGB();
        this.lootTable = lootTable;
    }

    public String getName() {
        return this.name;
    }

    public int getMainColor() {
        return this.mainColor;
    }

    public int getSecondaryColor() {
        return this.secondaryColor;
    }

    public ResourceLocation getLootTable() {
        return this.lootTable;
    }

    public Collection<ItemStack> getLoot(@NotNull WorldServer world, @Nullable EntityPlayer player) {
        LootTable loottable = world.getLootTableManager().getLootTableFromLocation(this.lootTable);
        if (loottable == null) return Collections.emptyList();

        LootContext.Builder builder = new LootContext.Builder(world);
        if (player != null) {
            builder.withPlayer(player).withLuck(player.getLuck());
        }

        return loottable.generateLootForPools(world.rand, builder.build());
    }
}
