package dustine.dustyrockybroods.spore.species;

import com.google.common.collect.ImmutableList;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import dustine.dustyrockybroods.spore.genome.SporeChromosome;
import dustine.dustyrockybroods.utility.BlockHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SporeSpecies {
    private final ResourceLocation lootTable;
    private final String unlocalizedName;
    private final Color mainColor;
    private final Color secondaryColor;
    private final SporeChromosome defaultGenes;
    private final double mutationChance;
    private final List<String> requiredSurroundings;

    public SporeSpecies(String unlocalizedName, Color main, Color secondary, ResourceLocation lootTable,
                        SporeChromosome defaultGenes, double mutationChance, List<String> requiredSurroundings) {
        this.unlocalizedName = unlocalizedName;
        this.mainColor = main;
        this.secondaryColor = secondary;
        this.lootTable = lootTable;
        this.defaultGenes = defaultGenes;
        this.mutationChance = mutationChance;
        this.requiredSurroundings = requiredSurroundings;
    }

    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    public int getMainColor() {
        return this.mainColor.getRGB();
    }

    public int getSecondaryColor() {
        return this.secondaryColor.getRGB();
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

    /**
     * Checks if a block inworld has the required surroundings to both support this spore species and allow for the species to form in case of mutation.
     *
     * @param world
     * @param pos
     * @return
     */
    public boolean hasRequiredSurroundings(World world, BlockPos pos) {
        final TileEntity tile = world.getTileEntity(pos);
        final ArrayList<IBlockState> surrounding = new ArrayList<>(Arrays.asList(
                world.getBlockState(pos.up()), world.getBlockState(pos.down()), world.getBlockState(pos.north()),
                world.getBlockState(pos.east()), world.getBlockState(pos.south()), world.getBlockState(pos.west())
        ));

        // iterate for the required, removing any match from the surroundings list to avoid repeated matching in the following tests
        for (String test : this.requiredSurroundings) {
            final Optional<IBlockState> result = surrounding.stream()
                    .filter(block -> BlockHelper.isSameBlock(block, test))
                    .findFirst();
            if (!result.isPresent()) return false;
            surrounding.remove(result.get());
        }

        return true;
    }

    public SporeChromosome getDefaultGenes() {
        return this.defaultGenes;
    }

    public double getMutationChance() {
        return this.mutationChance;
    }

    public List<String> getRequiredSurroundings() {
        return ImmutableList.copyOf(this.requiredSurroundings);
    }
}
