package dustine.dustyrockybroods.item;

public class ItemSpore extends RockyItem {
    public ItemSpore() {
        super();
        setHasSubtypes(true);
        setMaxDamage(-1);
    }

    @Override
    public boolean canItemEditBlocks() {
        return true;
    }
}
