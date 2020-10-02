package epi.trees;

public class TreeNode<T> {
    public static final TreeNode NONE = null;

    private T value;
    private TreeNode<T> left = NONE, right = NONE;

    public TreeNode(T value) {
        this.value = value;
    }

    public static <R> TreeNode<R> leaf(R value) {
        return new TreeNode<R>(value);
    }

    public static <R> TreeNode<R> internal(R value, TreeNode<R> left, TreeNode<R> right) {
        var node = new TreeNode<R>(value);
        node.setLeft(left);
        node.setRight(right);
        return node;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T value() {
        return value;
    }

    public TreeNode<T> left() {
        return left;
    }

    public TreeNode<T> right() {
        return right;
    }
}
