package broccoli;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represent a logg of the simulator.
 * 
 * @author Vinh Tran, Thomas Todal, Kristoffer Martinsen
 * @version 31.03.2017
 */
public class Logger
{
    
    private BufferedWriter writer;
    private final ArrayList<String> messageList;

    /**
     * 
     * @param name 
     */
    public Logger(String name)
    {
        this.messageList = new ArrayList<>();
        try {
            this.writer = new BufferedWriter(new FileWriter(name + ".csv", false));
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

    }
    
    /**
     * 
     * @param message 
     */
    public void addMessage(String message)
    {
        this.messageList.add(message + "\n");
    }

    /**
     * 
     */
    public void writeToFile()
    {
        try {
            for (String string : this.messageList) {
                // Make one line for the file
                this.writer.write(string);

            }
            this.writer.close();
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}
