package redblacktree;

public class RedBlackTree<K extends Comparable<K>, V> implements MapInterface<K, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {

        K key;
        V value;
        Node leftNode, rightNode;
        boolean color;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.color = RED;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return this.rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public V getNodeValue() {
            return this.value;
        }

        public void setNodeValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public boolean getNodeColor() {
            return this.color;
        }

        public void setNodeColor(boolean color) {
            this.color = color;
        }

        @Override
        public String toString() {
            String nodeColor;
            if (this.color) {
                nodeColor = "Red";
            } else {
                nodeColor = "Black";
            }

            K left;
            K right;
            if (leftNode != null) {
                left = leftNode.getKey();
            } else {
                left = null;
            }
            if (rightNode != null) {
                right = rightNode.getKey();
            } else {
                right = null;
            }
            return String.format("[%s] %s left: %s right: %s", nodeColor, this.key, left, right);
        }
    }

    boolean isNodeRed(Node node) {
        try {
            return node.getNodeColor();
        } catch (NullPointerException e) {
            return BLACK;
        }
    }

    @Override
    public V getValue(K key) {
        Node node = root;
        while (node != null) {
            int comparisonResult = key.compareTo(node.key);
            if (comparisonResult < 0) {
                node = node.getLeftNode();
            } else if (comparisonResult > 0) {
                node = node.getRightNode();
            } else {
                return node.getNodeValue();
            }
        }
        return null;
    }

    private Node insertNode(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        int comparisonResult = key.compareTo(node.key);
        if (comparisonResult == 0) {
            node.setNodeValue(value);
        } else if (comparisonResult < 0) {
            node.setLeftNode(insertNode(node.getLeftNode(), key, value));
        } else {
            node.setRightNode(insertNode(node.getRightNode(), key, value));
        }
        if (isNodeRed(node.getRightNode()) && !isNodeRed(node.getLeftNode())) {
            node = rotateLeft(node);
        }
        if (isNodeRed(node.getLeftNode()) && isNodeRed(node.getLeftNode().getLeftNode())) {
            node = rotateRight(node);
        }
        if (isNodeRed(node.getLeftNode()) && isNodeRed(node.getRightNode())) {
            colorFlip(node);
        }
        return node;
    }

    @Override
    public void setValue(K key, V value) {
        root = insertNode(root, key, value);
        root.setNodeColor(BLACK);
    }

    void colorFlip(Node node) {
        node.setNodeColor(!node.getNodeColor());
        node.getLeftNode().setNodeColor(!node.getLeftNode().getNodeColor());
        node.getRightNode().setNodeColor(!node.getRightNode().getNodeColor());
    }

    Node rotateLeft(Node node) {
        Node rotatedNode = node.getRightNode();
        node.setRightNode(rotatedNode.getLeftNode());
        rotatedNode.setLeftNode(node);
        rotatedNode.setNodeColor(node.getNodeColor());
        node.setNodeColor(RED);
        return rotatedNode;
    }

    Node rotateRight(Node node) {
        Node rotatedNode = node.getLeftNode();
        node.setLeftNode(rotatedNode.getRightNode());
        rotatedNode.setRightNode(node);
        rotatedNode.setNodeColor(node.getNodeColor());
        node.setNodeColor(RED);
        return rotatedNode;
    }

    public Node getRoot() {
        return root;
    }

    public void printTree(Node node) {
        if (node == null) {
            return;
        }
        printTree(node.getLeftNode());
        System.out.println(node);
        printTree(node.getRightNode());
    }

}
