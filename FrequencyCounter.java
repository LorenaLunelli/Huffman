package huffman;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lorena Lunelli
 */
public class FrequencyCounter {
    // This is the dictionary, with all frequencies listed
    private ArrayList<CharFrequency> Frequencies;
    
    /**
     * @brief Constructor
     */
    public FrequencyCounter() {
        this.Frequencies = new ArrayList<CharFrequency>();
    }
    
    /**
     * @brief   Verify if character x is in the dictionary already
     * @param   x ASCII value for the character
     * @return  boolean
     */
    private boolean isInList(int x) {
        return this.Frequencies.stream().anyMatch((f) -> (f.getC() == x));
    }
    
    /**
     * @brief   Find item, given its character
     * @param   x ASCII value for the character
     * @return  dictionary item
     */
    private CharFrequency findItem(int x) {
        return (CharFrequency) this.Frequencies.stream().filter((f) -> (f.getC() == x)).findFirst().get();
    }
    
    /**
     * @brief   Count the frequency of each character of the dictionary
     * @param   text List of all characters, in the order they are presented in the text
     * @return  Dictionary, with all the characters and their respective frequencies
     */
    public List countFrequency(List text) {
        CharFrequency f;
        for (Object c : text){
            /**
             * For each character found in the text,
             * if it already exists in the dictionary,
             * just update the frequency.
             */
            if (this.isInList((int) c)) {
                f = this.findItem((int) c);
                // frequency++;
                f.setFrequency();
            }
            /**
             * If not, create a new entry in the dictionary
             * and update its frequency.
             */
            else {
                f = new CharFrequency((int) c);
                // frequency++;
                f.setFrequency();
                this.Frequencies.add(f);                
            }
        }
        // Sort elements in the dictionary non-decreasingly by their frequencies
        this.Frequencies.sort((a, b) -> (a.getFrequency() - b.getFrequency()));
        return this.Frequencies;
    }
}
