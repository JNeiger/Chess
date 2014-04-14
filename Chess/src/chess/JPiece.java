/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author joseph.neiger
 */
public class JPiece extends JPanel
{
    Piece piece;  //enumeration the piece reperesents
    PlyrColour color;  //color of the owner
    int location;  //location of the pice on the board 0-63
    Image img;  //Icon of the piece
    boolean hasntMove;
    int[][] movements = //This looked much cleaner to me then doing it in the player class
            {
               {8},                                 //Pawn 
               //or -8 depending on the player num
               {-10, -17, -15, -6, 6, 15, 17, 10},  //Knight
               {-7, -9, 7, 9},                      //Bishops
               {-8, -1, 1, 8},                      //Rooks
               {-7, -8, -9, -1, 1, 7, 8, 9},        //Queen
               {-7, -8, -9, -1, 1, 7, 8, 9}         //King
            };
    
    /*
     * @param p Piece type
     * @param c Player Color
     */
    public JPiece(Piece p, PlyrColour c) throws IOException
    {
        piece = p;
        color = c;
        img = ImageIO.read(new File(color.toString() + piece.toString() + ".png"));
        
        this.setPreferredSize(new Dimension(80,  80));
        setOpaque(false);
        
        hasntMove = true;
        
        if (c == PlyrColour.Black)  //if at the top of the board moving down
        {
            movements[0][0] *= -1; //set the pawn direction corretely
        }
    }

    
    /*
     * @return The enumeration the Piece represents
     */
    public Piece getPiece()
    {
        return piece;
    }
    
    /*
     * @return The Color of the player owner
     */
    public PlyrColour getColor()
    {
        return color;
    }
    
    /*
     * @param loc Location to move the referenced piece to
     */
    public void setSquare(int loc)
    {
        location = loc;
    }
    
    /*
     * @return The location of the referenced piece
     */
    public int getSquare()
    {
        return location;
    }
    
    public boolean hasntMoved()
    {
        return hasntMove;
    }
    
    //overrides the paint component so that it actually draws the picture
    //as it is supposed to be
    @Override
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        page.drawImage(img, 0, 0, null);
    }
    
    /*
     * @return The possible movement directions/locations depending on the piece
     */
    public int[] getMovements()
    {
        return movements[piece.ordinal()];
    }
    
    public String pieceString()
    {
        return color.toString() + " " + piece.toString();
    }
    
    //tell if its it first movement or not for castling, and pawns
    public void moved()
    {
        hasntMove = false;
    }


    
    
}
