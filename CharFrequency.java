package huffman;

/**
 *
 * @author Lorena Lunelli
 */
public class CharFrequency {
    private final int C;
    private int Frequency;
    private String Code;

    /**
     * @brief   Constructor
     * @param   c Character we are referring to
     */
    public CharFrequency(int c) {
        this.C = c;
        this.Frequency = 0;
        this.Code = null;
    }

    /**
     * @brief   getter
     * @return  The character we are referring to
     */
    public int getC() {
        return this.C;
    }

    /**
     * @brief   getter
     * @return  The character's frequency in the text
     */
    public int getFrequency() {
        return this.Frequency;
    }
    
    /**
     * @brief   getter
     * @return  The attributed code for this character
     */
    public String getCode() {
        return this.Code;
    }

    /**
     * @brief   setter
     * frequency++
     */
    public void setFrequency() {
        this.Frequency += 1;
    }
    
    /**
     * @brief   setter
     * @param   freq The new frequency of this character
     * Used when manipulating nodes in the Huffman tree
     */
    public void setFrequency(int freq) {
        this.Frequency = freq;
    }
    
    /**
     * @brief   setter
     * @param   code The given code for this character
     */
    public void setCode(String code) {
        this.Code = code;
    }
}
