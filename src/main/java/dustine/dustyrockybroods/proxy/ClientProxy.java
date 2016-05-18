package dustine.dustyrockybroods.proxy;

import dustine.dustyrockybroods.client.util.ModRenderer;
import dustine.dustyrockybroods.item.ItemMeshFolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

import java.util.HashMap;
import java.util.Map;

public class ClientProxy extends CommonProxy {
    @Override
    public EntityPlayer getEntityPlayerSP() {
        return Minecraft.getMinecraft().thePlayer;
    }

    @Override
    public void clientInit() {
        ModRenderer.init();
    }

    @Override
    public void forceInventoryModels(Item item, Map<Integer, String> models) {
        // if null, default behaviour
        if (models == null) {
            models = new HashMap<>(1);
            models.put(0, "inventory");
        }

        for (Map.Entry<Integer, String> entry : models.entrySet()) {
            ModelLoader.setCustomModelResourceLocation(item, entry.getKey(),
                    new ModelResourceLocation(item.getRegistryName(), entry.getValue()));
        }
    }

    @Override
    public void forceInventoryModels(Item item, ItemMeshFolder itemMesh) {
        ModelLoader.setCustomMeshDefinition(item, itemMesh);
        final ResourceLocation[] locations = itemMesh.getAllModelLocations().toArray(new ModelResourceLocation[]{});
        ModelBakery.registerItemVariants(item, locations);
    }
}
