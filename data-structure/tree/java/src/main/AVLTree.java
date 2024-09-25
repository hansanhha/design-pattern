public class AVLTree<E> {

    Node<E> root;

    private int height(Node<E> node) {
        return node != null ? node.height : -1;
    }

    private void updateHeight(Node<E> node) {
        int leftSubtreeHeight = height(node.left);
        int rightSubtreeHeight = height(node.right);
        node.height = Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }

    private int balanceFactor(Node<E> node) {
        return height(node.right) - height(node.left);
    }

    public static class Node<E> {
        Node<E> left;
        Node<E> right;
        E element;
        int height;

        public Node(E element) {
            this.element = element;
        }
    }
}
