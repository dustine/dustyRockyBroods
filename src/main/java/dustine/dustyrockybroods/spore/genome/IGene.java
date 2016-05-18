package dustine.dustyrockybroods.spore.genome;

public interface IGene<T> {
    /**
     * Sets the gene to the corresponding value
     *
     * @param newValue
     * @return
     */
    boolean setValue(T newValue);

    boolean isDominant();
}
