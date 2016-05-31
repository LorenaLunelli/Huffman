package huffman;

import static java.lang.System.out;
import java.util.*;
import java.io.*;

/**
 *
 * @author Lorena Lunelli
 */
public class FileHandler {
    // private final Path file;
    private final String filePath;

    /**
     * @brief   Constructor
     * @param   filePath Path for the file with the message to read
     */
    public FileHandler(String filePath) {
        // this.file = Paths.get(filePath);
        this.filePath = filePath;
    }
    
    /**
     * @brief   Reads the message in the text file and turns it into a list of characters
     * @return  List of characters as they are in the message
     */
    public List readContent() {
        FileReader inputStream;
        List text = new ArrayList();
        int c;
        
        // Open file for reading
        try {
            inputStream = new FileReader(this.filePath);
        }
        catch (FileNotFoundException e){
            out.println(e.getMessage());
            return null;
        }
        
        // Reads file by character until the end
        try {
            while ((c = inputStream.read()) != -1){
                text.add(c);
            }
        } catch (IOException e) {
            out.println(e.getMessage());
            return null;
        }
        return text;
    }
}
