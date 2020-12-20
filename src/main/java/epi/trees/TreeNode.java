package epi.trees;

import java.util.Objects;

public class TreeNode<T> {
    private T value;
    private int nodesInSubTree = 0;
    private boolean locked = false;
    private TreeNode<T> left = null, right = null, parent = null, levelNext = null;

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

    public void setLevelNext(TreeNode<T> levelNext) {
        this.levelNext = levelNext;
    }

    public void lock() {
        boolean lockable = true;
        for (TreeNode<T> p = parent; p != null; p = p.parent) {
            if (p.isLocked()) {
                lockable = false;
                break;
            }
        }
        if (lockable) {
            lockable = isUnlockedTree(left) && isUnlockedTree(right);
        }
        if (lockable) {
            locked = true;
        } else {
            throw new IllegalStateException("Node can't be locked!");
        }
    }

    private boolean isUnlockedTree(TreeNode<T> root) {
        if (root == null) {
            return true;
        } else {
            return !root.locked && isUnlockedTree(root.left()) && isUnlockedTree(root.right());
        }
    }

    public boolean isLocked() {
        return locked;
    }

    public void unlock() {
        locked = false;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public T value() {
        return value;
    }

    public TreeNode<T> parent() {
        return parent;
    }

    public TreeNode<T> left() {
        return left;
    }

    public TreeNode<T> levelNext() {
        return levelNext;
    }

    public TreeNode<T> right() {
        return right;
    }

    public int nodesInSubTree() {
        return nodesInSubTree;
    }

    public void setNodesInSubTree(int nodesInSubTree) {
        this.nodesInSubTree = nodesInSubTree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }

    @Override
    public String toString() {
        return String.format(
                "V=%s (L=%s,R=%s,P=%s,#=%d)",
                this.value,
                (left != null) ? left.value : null,
                (right != null) ? right.value : null,
                (parent != null) ? parent.value : null,
                nodesInSubTree);
    }
}
