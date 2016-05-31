package huffman;

import static java.lang.System.out;
import java.util.List;


/**
 *
 * @author Lorena Lunelli
 */
public class Huffman {
    
    /**
     * @brief   Calculate the number of bits for a fixed-length message
     * @param   textSize number of characters of the original message
     * @param   dictSize size of the dictionary
     * @return  How long would a fixed-length message be
     */
    public static float originalMessageSize(int textSize, int dictSize) {
        // #bits = log (base 2) (size of the dictionary)
        int bits = (int) Math.ceil(Math.log10(dictSize) / Math.log10(2));
        return textSize * bits;
    }

    /**
     * @param   args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length < 1){
            out.println("Not enough arguments");
            System.exit(0);
        }
        else {
            // Open file and read the message
            FileHandler handler = new FileHandler(args[0]);
            List Text = handler.readContent();
            
            // Create the Huffman tree for this message
            HuffmanTree tree = new HuffmanTree(Text);
            
            // Generates the codes for the characters
            tree.codeHuffman();
            
            // Compress the message
            Compress codec = new Compress(Text, tree.getCodesList());
            String output = codec.textToCode();
            
            // Prints the message and its length
            out.println("Message:");
            out.println(output);
            out.println("Length: "
                    + output.length()
                    + " bits, compared to the "
                    + (int) originalMessageSize(Text.size(), tree.getCodesList().size())
                    + " bits of the original message");
        }
    }
}
