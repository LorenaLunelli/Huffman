package huffman;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lorena Lunelli
 */
public class HuffmanTree {
    private final List Text;
    private ArrayList<Node> Tree;
    private ArrayList<CharFrequency> CodesList;

    /**
     * @brief   Constructor
     * @param   text The original message to be coded
     */
    public HuffmanTree(List text) {
        this.Text = text;
        this.Tree = new ArrayList<Node>();
        this.CodesList = new ArrayList<CharFrequency>();
        this.buildTree();
    }
    
    /**
     * @brief   getter
     * @return  List of the characters codes
     */
    public List<CharFrequency> getCodesList() {
        return this.CodesList;
    }
    
    /**
     * @brief   Gets first element in the list
     * @return  First element in the list
     */
    public Node getFirst() {
        return this.Tree.stream().findFirst().get();
    }
    
    /**
     * @brief   Removes first element in the list
     */
    private void removeFirst() {
        this.Tree.remove(0);
    }
    
    /**
     * @brief   Find position to insert element in order
     * @param   freq Frequency of the new element
     * @return  Position of the previous element
     */
    private int findPrevious(int freq) {
        int pos = 0;
        for (Node n : this.Tree) {
            if (n.getItem().getFrequency() < freq)
                pos++;
            else
                return pos;
        }
        return pos;
    }
    
    /**
     * @brief   Insert element in order on the list
     * @param   x Element to be inserted
     */
    private void insertNodeInOrder(Node x) {
        this.Tree.add(this.findPrevious(x.getItem().getFrequency()), x);
    }
    
    /**
     * @brief   First iteration of the loop,
     *          where we have only a list of nodes with no children
     */
    private void buildTree() {
        FrequencyCounter counter = new FrequencyCounter();
        List frequencies = counter.countFrequency(this.Text);
        // Create nodes for all the dictionary items
        for (Object o : frequencies) {
            CharFrequency c = (CharFrequency) o;
            Node node = new Node(c);
            this.Tree.add(node);
        }
    }
    
    /**
     *
     * @param   n Node
     * @param   code Incremental code -- grows as it goes through the tree
     * @return  List with the codes for their correspondent characters updated
     */
    private void generateCodes(Node n, String code) {
        if (n.getItem().getC() != -1) {
            n.getItem().setCode(code);
            this.CodesList.add(n.getItem());
        }
        else {
            /**
             * Convention:  left in the tree means 0,
             *              right in the tree means 1.
             */
            this.generateCodes(n.getLeft(), code + '0');
            this.generateCodes(n.getRight(), code + '1');
        }
    }
    
    /**
     * @brief   Algorithm for non-fixed-length codes, based on frequency
     */
    public void codeHuffman() {
        while (this.Tree.size() > 1) {
            /**
             * In each iteration, the two first elements in the tree
             * will be combined, and reinserted in the list
             * in order with the other elements.
             */
            Node n1 = this.getFirst();
            this.removeFirst();
            Node n2 = this.getFirst();
            this.removeFirst();
            CharFrequency c = new CharFrequency(-1);
            c.setFrequency(n1.getItem().getFrequency() + n2.getItem().getFrequency());
            Node newNode = new Node(c);
            newNode.setLeft(n1);
            newNode.setRight(n2);
            this.insertNodeInOrder(newNode);
        }
        // Once the tree is ready, it's time for the codes.
        this.generateCodes(this.getFirst(), "");
    }
}
