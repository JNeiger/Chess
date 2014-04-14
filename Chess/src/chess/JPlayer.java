/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author joseph.neiger
 */
public class JPlayer 
{
    PlyrColour color;  //Color of the player
    ArrayList<JPiece> pieces;  //All owned pieces
    
    /*
     * @param pc Color of the player
     */
    public JPlayer(PlyrColour pc) throws IOException
    {
        color = pc;
        pieces = new ArrayList<JPiece>();
        
        //adds the pieces in order from front to back
        //left to right
        for (int i = 0; i < 8; i++)
        {
            pieces.add(new JPiece(Piece.Pawn, color));
        }
        pieces.add(new JPiece(Piece.Rook, color));
        pieces.add(new JPiece(Piece.Knight, color));
        pieces.add(new JPiece(Piece.Bishop, color));
        pieces.add(new JPiece(Piece.Queen, color));
        pieces.add(new JPiece(Piece.King, color));
        pieces.add(new JPiece(Piece.Bishop, color));
        pieces.add(new JPiece(Piece.Knight, color));
        pieces.add(new JPiece(Piece.Rook, color));
    }
    
    /*
     * @return Color of the player
     */
    public PlyrColour getColor()
    {
        return color;
    }
    
    /*
     * @return ArrayList<Pieces> of the pieces the player currently has
     */
    public ArrayList<JPiece> getPieces()
    {
        return pieces;
    }
    
    /*
     * @param p Piece to remove from the players possesion
     */
    public void removePiece(JPiece p)
    {
        pieces.remove(p);
    }
    
    /*
     * @param p Piece to add to the players possesion
     */
    public void addPiece(JPiece p)
    {
        pieces.add(p);
    }
    
    //gets the king of the player, for many the tests of the way of the check/mate
    public JPiece getKing()
    {
        for (JPiece i : pieces)
        {
            if (i.getPiece() == Piece.King)
            {
                return i;
            }
        }
        //It should never get here but just in case it does
        //ERROR
        System.out.println("ERROR: KING NOT FOUND");
        return null;
    }
}
