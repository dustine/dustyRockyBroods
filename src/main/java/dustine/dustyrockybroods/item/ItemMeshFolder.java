package dustine.dustyrockybroods.item;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import java.util.Collection;

public interface ItemMeshFolder extends ItemMeshDefinition {
    Collection<ModelResourceLocation> getAllModelLocations();
}
