
import java.util.Iterator;

interface BSTInterface<T> extends Iterable<T> {

    public enum Traversal {
        Inorder, Preorder, Postorder
    };

    T min();

    T max();
    String Height();

    public Iterator<T> getIterator(Traversal orderType);

}