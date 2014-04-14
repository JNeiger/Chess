/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author joseph.neiger
 */
public class JSquare extends JPanel{

    int location;
    Color col;
    
    public JSquare(int loc, Color c)
    {
        location = loc;
        col = c;
        this.toggleOff();
    }
    
    public void toggleBackGround()
    {
        this.setBackground(Color.blue);
    }
    
    public void toggleOff()
    {
        this.setBackground(col);
    }
    
    public int getSquare()
    {
        return location;
    }
    
    public Color getColor()
    {
        return col;
    }

    
}
