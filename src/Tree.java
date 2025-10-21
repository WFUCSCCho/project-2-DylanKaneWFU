public abstract class Tree<T extends Comparable<T>> {
    public abstract boolean contains(T key);
    public abstract void insert (T key);
}
