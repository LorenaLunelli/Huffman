package huffman;

/**
 *
 * @author Lorena Lunelli
 */
public class Node {
    private final CharFrequency item;
    private Node left;
    private Node right;

    /**
     * @brief   Constructor
     * @param   item A valid item for a tree node
     */
    public Node(CharFrequency item) {
        this.item = item;
        this.left = null;
        this.right = null;
    }

    /**
     * @brief   getter
     * @return  Item of the node
     */
    public CharFrequency getItem() {
        return this.item;
    }

    /**
     * @brief   getter
     * @return  Left child of this node
     */
    public Node getLeft() {
        return this.left;
    }

    /**
     * @brief   setter
     * @param   node Which node will be the left child
     */
    public void setLeft(Node node) {
        this.left = node;
    }

    /**
     * @brief   getter
     * @return  Right child of this node
     */
    public Node getRight() {
        return this.right;
    }

    /**
     * @brief   setter
     * @param   node Which node will be the right child
     */
    public void setRight(Node node) {
        this.right = node;
    }
}
