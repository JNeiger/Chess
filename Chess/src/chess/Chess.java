/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author joseph.neiger
 */
import java.io.IOException;

public class Chess 
{
    boolean debug = false; //Ouput most things to the log for debug later, and maybe output to an debug panel
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        //creates the board itself
        //and shows the board to the user
        fmChess newForm = new fmChess();
        newForm.show();
    }
}
