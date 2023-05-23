package ratings.datastructures;

public class BST<A> {
    private BinaryTreeNode<A> root;
    private Comparator<A> comparator;
    public BST(Comparator<A> comparator) {
        this.comparator = comparator;
        this.root = null;
    }
    public void insert(A value) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(value, null, null);
        } else {
            this.insertHelper(this.root, value);
        }
    }
    private void insertHelper(BinaryTreeNode<A> node, A toInsert) {
        if (this.comparator.compare(toInsert,node.getValue())) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getLeft(), toInsert);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getRight(), toInsert);
            }
        }
    }
    public BinaryTreeNode<A> getRoot(){
        return this.root;
    }
}
