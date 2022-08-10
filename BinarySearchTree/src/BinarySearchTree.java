
import java.util.*;

public class BinarySearchTree<T> implements BSTInterface<T>
{
    protected BSTNode<T> root; 
    protected Comparator<T> comp; 
    protected boolean found; 
    public BinarySearchTree()

    {
        root = null;
        comp = new Comparator<T>()
        {
            public int compare(T element1, T element2)
            {
                return ((Comparable)element1).compareTo(element2);
            }
        };
    }
    public BinarySearchTree(Comparator<T> comp)

    {
        root = null;
        this.comp = comp;
    }

    public boolean isFull()
    {
        return false;
    }
    public boolean isEmpty()

    {
        return (root == null);
    }
    public T min()

    {
        if (isEmpty())
            return null;
        else
        {
            BSTNode<T> node = root;
            while (node.getLeft() != null)
                node = node.getLeft();
            return node.getInfo();
        }
    }
    public T max()

    {
        if (isEmpty())
            return null;
        else {
            BSTNode<T> node = root;
            while (node.getRight() != null)
                node = node.getRight();
            return node.getInfo();
        }
    }

    @Override
    public Iterator<T> getIterator(BSTInterface.Traversal orderType)

    {
        final Queue<T> infoQueue = new LinkedList<T>();
      
        if (orderType == BSTInterface.Traversal.Preorder)
            preOrder(root, infoQueue);
        else
        if (orderType == BSTInterface.Traversal.Inorder)
            inOrder(root, infoQueue);

 else
        if (orderType == BSTInterface.Traversal.Postorder)
            postOrder(root, infoQueue);
        return new Iterator<T>()
        {
            public boolean hasNext()
            {
                return !infoQueue.isEmpty();
            }
            public T next()
            {
                if (!hasNext())
                    throw new IndexOutOfBoundsException("illegal invocation of next "
                            + " in BinarySearchTree iterator.\n");
                return infoQueue.remove();
            }
            public void remove()
            {
                throw new UnsupportedOperationException("Unsupported remove attempted "
                        + "on BinarySearchTree iterator.\n");
            }
        };
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
    public int size()
// Returns the number of elements in this BST.
    {
        return recSize(root);
    }
    private int recSize(BSTNode<T> node)
// Returns the number of elements in subtree rooted at node.
    {
        if (node == null)
            return 0;
        else
            return 1 + recSize(node.getLeft()) + recSize(node.getRight());
    }
    public T get(T target)

    {
        return recGet(target, root);
    }
    private T recGet(T target, BSTNode<T> node)

    {
        if (node == null)
            return null;
        else if (comp.compare(target, node.getInfo()) < 0)
            return recGet(target, node.getLeft()); 
        else
        if (comp.compare(target, node.getInfo()) > 0)
            return recGet(target, node.getRight()); 
        else
            return node.getInfo(); 
    }
    public boolean contains (T target)

    {
        return recContains(target, root);
    }
    private boolean recContains(T target, BSTNode<T> node)

    {
        if (node == null)
            return false; 
        else if (comp.compare(target, node.getInfo()) < 0)
            return recContains(target, node.getLeft()); 
        else if (comp.compare(target, node.getInfo()) > 0)
            return recContains(target, node.getRight()); 
        else
            return true; 
    }
    private void inOrder(BSTNode<T> node, Queue<T> q)

    {
        if (node != null)
        {
            inOrder(node.getLeft(), q);
            q.add(node.getInfo());
            inOrder(node.getRight(), q);
        }
    }
    private void preOrder(BSTNode<T> node, Queue<T> q)

    {
        if (node != null)
        {
            q.add(node.getInfo());
            preOrder(node.getLeft(), q);
            preOrder(node.getRight(), q);
        }
    }
    private void postOrder(BSTNode<T> node, Queue<T> q)

    {
        if (node != null)
        {
            postOrder(node.getLeft(), q);
            postOrder(node.getRight(), q);
            q.add(node.getInfo());
        }
    }
    public  boolean add (T element)

    {
        root = recAdd(element, root);
        System.out.print(element);
        return true;
    }
    private BSTNode<T> recAdd(T element, BSTNode<T> node)

    {
        if (node == null)
         
            node = new BSTNode<T>(element);
        else if (comp.compare(element, node.getInfo()) <= 0)
            node.setLeft(recAdd(element, node.getLeft())); 

 else
        node.setRight(recAdd(element, node.getRight())); 
        return node;
    }
    public boolean remove (T target)


    {
        root = recRemove(target, root);
        return found;
    }
    private BSTNode<T> recRemove(T target, BSTNode<T> node)
    {
        if (node == null)
            found = false;
        else if (comp.compare(target, node.getInfo()) < 0)
            node.setLeft(recRemove(target, node.getLeft()));
        else if (comp.compare(target, node.getInfo()) > 0)
            node.setRight(recRemove(target, node.getRight()));
        else
            node = removeNode(node);
        found = true;

 return node;
}

    private BSTNode<T> removeNode(BSTNode<T> node)

    {
        T data;
        if (node.getLeft() == null)
            return node.getRight();
        else if (node.getRight() == null)
            return node.getLeft();
        else
        {
            data = getPredecessor(node.getLeft());
            node.setInfo(data);
            node.setLeft(recRemove(data, node.getLeft()));
            return node;
        }
    }
    private T getPredecessor(BSTNode<T> subtree)

    {
        BSTNode<T> temp = subtree;

        while (temp.getRight() != null)
            temp = temp.getRight();
        return temp.getInfo();
    }
    public String Height(){
        int height =5;
        return "Height ="+height;
        
    }
}


