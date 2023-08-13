package bst1;

public class BST {
	Node node;

    // Right rotate a given node
    private Node rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }

    // Convert BST to skewed tree
    private Node modifyToSkewedTree(Node root) {
        if (root == null)
            return null;

        while (root.left != null) {
            root = rightRotate(root);
        }

        root.right = modifyToSkewedTree(root.right);

        return root;
    }

    // Inorder traversal of skewed tree
    private void inorderTraversal(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);

        // Remove left nodes and convert to skewed tree
        tree.node = tree.modifyToSkewedTree(tree.node);

        // Display node values in ascending order
        tree.inorderTraversal(tree.node);
    }

}
