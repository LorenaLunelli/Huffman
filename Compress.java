package huffman;

import static java.lang.System.out;
import java.util.List;

/**
 *
 * @author  Lorena Lunelli
 */
public class Compress {
    private final List Text;
    private final List<CharFrequency> CodesList;

    /**
     * @brief   Constructor
     * @param   Text List of all characters thar form the original message
     * @param   CodesList Dictionary of characters and their codes
     */
    public Compress(List Text, List<CharFrequency> CodesList) {
        this.Text = Text;
        this.CodesList = CodesList;
    }
    
    /**
     * @brief   Realizes de codification
     * @return  Coded message
     */
    public String textToCode() {
        /**
         * The result of this program is a String,
         * representing the bits that compose the compressed message.
         * 
        **/
        String codeText = "";
        for (Object o : this.Text)
            /**
             * For each character in the text,
             * search in the dictionary for its correspondent code,
             * and attach it to the previous coded message.
             */
            for (CharFrequency n : this.CodesList)
                if (n.getC() == (int) o)
                    codeText += n.getCode();
        return codeText;
    }
}
