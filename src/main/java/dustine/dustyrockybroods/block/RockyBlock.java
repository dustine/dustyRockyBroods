package dustine.dustyrockybroods.block;

import dustine.dustyrockybroods.DustyRockyBroods;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RockyBlock extends Block {
    public RockyBlock() {
        super(Material.rock);
        setCreativeTab(DustyRockyBroods.CREATIVE_TAB);
    }
}
