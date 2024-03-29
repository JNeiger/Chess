/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author joseph.neiger
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class fmChess extends javax.swing.JFrame implements MouseListener {

    JPlayer[] players;
    boolean firstClick;
    JPiece piece2Move;
    PlyrColour currPly;

    /**
     * Creates new form fmChess
     */
    public fmChess() throws IOException {
        initComponents();

        JPanel sq;  //temporary square to represent each of the squares
        firstClick = true;
        Color[] clrs = {new Color(255, 215, 180), new Color(250, 145, 95)};  //array of the square colors
        currPly = PlyrColour.White;
        firstClick = true;

        //this.incrementPlyr();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                //creates a new jpanel with the set size and location
                //sets the color to alternate between the colors
                //and then sets the name of the panel to the location 0-63
                sq = new JSquare(row * 8 + col, clrs[((col % 2) + (row % 2)) % 2]);
                sq.setSize(80, 80);
                sq.setLocation(col * 80, row * 80);
                sq.setName("" + row * 8 + col);
                jPanel1.add(sq);
                sq.addMouseListener(this);
            }
        }
        //sets the players color and instaties the player objects
        players = new JPlayer[2];
        players[0] = new JPlayer(PlyrColour.Black);
        players[1] = new JPlayer(PlyrColour.White);

        //sets the white pieces in order
        for (int i = 0; i < 16; i++) {
            sq = (JSquare) jPanel1.getComponent(i + 48);
            sq.add(players[0].pieces.get(i));
            players[0].pieces.get(i).setSquare(i + 48);
        }
        //sets the front line of the black side
        for (int i = 0; i < 8; i++) {
            sq = (JSquare) jPanel1.getComponent(i + 8);
            sq.add(players[1].pieces.get(i));
            players[1].pieces.get(i).setSquare(i + 8);
        }
        //sets the back line of the black side
        for (int i = 8; i < 16; i++) {
            sq = (JSquare) jPanel1.getComponent(i - 8);
            sq.add(players[1].pieces.get(i));
            players[1].pieces.get(i).setSquare(i - 8);
        }
    }

    /*
     * Toggle the color of the square at the location specified
     */
    public void toggleColor(int loc) {
        ((JSquare) jPanel1.getComponent(loc)).toggleBackGround();
    }

    /*
     * Toggles off all the squares
     */
    public void toggleOff() {
        for (int i = 0; i < 64; i++) {
            ((JSquare) jPanel1.getComponent(i)).toggleOff();
        }
    }

    /*
     * @param loc : The location of the piece we want
     * @return  the color of the piece at that location
     */
    public PlyrColour pieceOwner(int loc) {
        for (int i = 0; i < 2; i++) {
            for (JPiece p : players[i].pieces) {
                if (p.getSquare() == loc) {
                    return p.getColor();
                }
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 750));

        jPanel1.setPreferredSize(new java.awt.Dimension(640, 640));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 640, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 640, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(139, 139, 139)
                .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(739, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(15, 15, 15)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(63, 63, 63)
                        .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fmChess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmChess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmChess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmChess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new fmChess().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(fmChess.class.getName()).log(Level.SEVERE, null);
                }

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {        
        this.toggleOff();
        //if there is no piece selected already
        //toggle open
        //otherwise
        //check to see if its possible
        //if it is then move
        //otherwise just toggle on the new space
        JSquare s = (JSquare) e.getComponent();
        JPiece p = this.getPiecesInSpace(s.getSquare());


        if (firstClick || p == piece2Move)//no piece selected
        {   //select a piece
            if (p != null && p.getColor() == currPly) //piece in that location and friendly
            {
                //if check, force to move king
                //else allow any piece to move
                firstClick = false;
                piece2Move = p;
                this.toggleColor(p.getSquare());
                this.toggleAllSquares(validMovements(p)); //toggle the pieces valid moves, not including all places that put your king in check

            }
        } else //piece selected already
        {
            firstClick = true;
            if (validMovements(piece2Move).contains(s.getSquare())) //if the selected space is a valid movement
            {

                System.out.println(checkMate()); //test to make sure check mate works

                //Movement specifics
                this.incrementPlyr();
                this.move(piece2Move, s);
                piece2Move.moved();

                //Check to see if its a pawn on teh edge
                //if it is, change
                if (piece2Move.getPiece() == Piece.Pawn
                        && //this works because the black will return a 0, and the white, a 1
                        //that * 56 would be either 56 or 0
                        //you then test if its between 0 and 8
                        //or between 56 and 64
                        ((piece2Move.getColor().ordinal()) % 2 * 56) <= piece2Move.getSquare() && //in the last row
                        ((piece2Move.getColor().ordinal()) % 2 * 56 + 16) > piece2Move.getSquare()) {
                    //if its in the last row
                    //we need to change the piece
                    int input = -1;
                    Scanner kbd = new Scanner(System.in);

                    do {
                        System.out.println("Pick your piece to change too");
                        System.out.println("[0]Knigh");
                        System.out.println("[1]Bishop");
                        System.out.println("[2]Rook");
                        System.out.println("[3]Queen");

                        try {
                            input = kbd.nextInt();
                        } catch (NumberFormatException ex) {
                            System.out.println("Pick a number between 0 and 3 to select your piece");
                        }

                    } while (input < 0);

                    input++; //increment input to align numbers with enum index
                    try { //try catch because of the picture of the peice inside the JPiece class, needs to be carried up with any other piece found
                        JPiece newPiece = new JPiece(Piece.values()[input], piece2Move.getColor());
                        
                        newPiece.setSquare(piece2Move.getSquare()); //sets the location of the piece
                        newPiece.moved();                           //used to help it not think they can still do special moves such as castling
                        
                        this.move(newPiece, s);
                        
                        players[0].removePiece(piece2Move);//it wont matter which players item it is
                        players[1].removePiece(piece2Move);//it will only remove if it has the same properties
                        
                        players[newPiece.getColor().ordinal()].addPiece(newPiece); //adds the piece to the player
                        
                        //System.out.println("Pawn reached the edge");
                    } catch (IOException ex) {
                        Logger.getLogger(fmChess.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else { //If friendly
                //just click the next space
                this.mouseClicked(e);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /*
     * @return Increments teh player
     */
    private void incrementPlyr() {
        //takes all the player colurs as an array, take the next one, and sets it as currPly
        currPly = PlyrColour.values()[(currPly.ordinal() + 1) % 2]; //increments the player
    }

    /*
     * @param loc : The location of the square we want to get the piece on
     * @return The piece on the square specified, null if none foudn
     */
    private JPiece getPiecesInSpace(int loc) {
        for (int i = 0; i < 2; i++) {
            for (JPiece p : players[i].getPieces()) {
                if (p.getSquare() == loc) {
                    return p;
                }
            }
        }

        return null;
    }

    //currently not inuse, but will be used as another layer ontop of the possible movements method to deal with special cases
    //will be used to get the valid movements of a piece, including special moves
    public ArrayList validMovements(JPiece pices) {
        ArrayList valid = new ArrayList();
        ArrayList possible = this.possibleMovements(pices);
        //make sure none of the spaces cause a check, if not, add to this new list

        for (int i = 0; i < possible.size(); i++) {
            if (!checkSpace(pices, (int) possible.get(i))) //if moveing doesn't put the king in check
            {
                valid.add(possible.get(i));
            }
        }

        //special cases like castling go here
        //add to array list if good
        //otherwise kill with fire

        //======Castling=========
        //if king, 1 or both rooks haven't moved
        //add it to the kings and rooks possible movements
        //use green to denote other piece movements
        //if (king.not moved && either rook not moved && space in between
        //allow castling
        if (pices.getPiece() == Piece.King || pices.getPiece() == Piece.Rook)
        {
            JPiece king = players[currPly.ordinal()].getKing();
            ArrayList<JPiece> rooks = this.getRooks();
            
            if (king.hasntMoved() && rooks.size() > 0) //at least 1 rook hasnt moved and the king hasnt moved
            {
                //go left / right
                //test to see if there is a thing there
                //if there is, then kick out, else, keep going
                
                for (JPiece j : rooks)
                {
                    int step = -1; //going left
                    if (king.getSquare()  < j.getSquare())//going right
                        step = 1;
                    for (int i = king.getSquare(); i != j.getSquare(); i += step)
                    {
                        if (((JSquare)jPanel1.getComponent(king.getSquare() + i)).getComponentCount() == 0)//if there is no piece in that square
                        {
                            //check if its the first or second space
                            //and make sure the king is not in check
                            //if its not
                            //add to possible moves, highlight rooks with green
                            //need to add a thing in the second click part of the .onclick
                            //to deal with the second piece moving
                            //Wont be too hard to get the direction, and grabbing the piece on that side
                            //always grab the last piece if you want the one on the right
                            //if you want the left side, get the first and test if there is 2
                            //if theres not 2, test the location against the king, and it should be negative
                            //if you subtract the rook from the king
                        }
                    }
                }
            }
        }

        return valid;
    }
    
    //gets the rooks that have not moved yet
    //used for the castling
    public  ArrayList getRooks()
    {
        ArrayList rooks = new ArrayList();
        
        for (JPiece j : players[currPly.ordinal()].getPieces())
        {
            if (j.getPiece() == Piece.Rook && j.hasntMoved())
            {
                rooks.add(j);
            }
        }
        return rooks;
    }

    /*
     * @param pices : Piece we want to get the possible movements for
     * @return The locations off all posible moves
     * Gets all the possible movements of a piece, not including if they put someone in check
     * or any of the special movements
     */
    public ArrayList possibleMovements(JPiece pices) {
        int[] movement = pices.getMovements();
        ArrayList valid = new ArrayList();

        if (pices.getPiece().ordinal() >= 2 && pices.getPiece().ordinal() <= 4) //The piece is a Queen, Bishop, and rook
        {
            for (int j : movement) {//for each of the possible movewments directions

                int distance = 1;
                int square = pices.getSquare() + (j * distance); //the next square to move to

                while (this.isValid(square, square - j) && (this.pieceOwner(square) == null)) //valid square && (space is empty)
                {
                    valid.add(square); //add the square
                    distance++;        //increment the distance we currently are
                    square = pices.getSquare() + (j * distance); //set the next location (square)
                }

                //next space is an enemy
                if (this.isValid(square, square - j) && this.pieceOwner(square) != pices.getColor()) {
                    valid.add(square); //add
                }
            }

        } else {
            //add all the valid places that are valid movement for the piece
            if (pices.getPiece() == Piece.Pawn) {
                //check space above
                //add if good
                //check if first move
                //add another
                //check for diagonals
                //add if enemy
                if (this.isValid(pices.getSquare() + movement[0], pices.getSquare()) && //valid space
                        this.pieceOwner(pices.getSquare() + movement[0]) == null) //nothing in the space we are trying to move too
                {
                    valid.add(pices.getSquare() + movement[0]); //add the space 1 above

                    //check for the double movement
                    if (pices.hasntMoved() //hasnt moved
                            && this.isValid(pices.getSquare() + (2 * movement[0]), pices.getSquare()) && //valid space
                            this.pieceOwner(pices.getSquare() + (2 * movement[0])) == null) {   //nobody there
                        valid.add((int) valid.get(0) + movement[0]); //add the space 2 above
                    }
                }
                //check for the diagonal enemies
                for (int i = -1; i < 2; i += 2) {
                    int space = pices.getSquare() + movement[0] + i; //getting the diagonal square loc #

                    if (this.isValid(space, pices.getSquare()) && //valid space
                            this.pieceOwner(space) != pices.getColor() && //not an ally piece
                            this.pieceOwner(space) != null) //and not empty
                    {
                        valid.add(space); //add to the list
                    }
                }

            } else {  //king and knight not included above !(Rook, queen, bishop, and pawn)
                //what I would also like to do is for the king
                //pass the arraylist over to another method
                //that will remove all "unmoveable" spaces due to check

                //I will need an accssor method sort of thing for this, in which it will play with all the special exceptions that there are with castling and such
                //Would like*

                for (int j : movement) {   //for each of the possible movements
                    if (this.isValid(pices.getSquare() + j, pices.getSquare()) && //if a valid space
                            this.pieceOwner(pices.getSquare() + j) != pices.getColor()) //not an ally
                    {
                        valid.add(pices.getSquare() + j); //add to the list of valid moves
                    }

                }
            }
        }

        return valid;  //return the valid array list
    }

    //checks to see if the king is in check mate
    //if he is in check
    //try to move his pieces to every possible location one at a time
    //if they break him out of check
    //he is not in checkmate
    //else yep, he lost
    private boolean checkMate() {
        //get all the possible movements of the king
        //"move" to all of them
        //checking to see if it kicks you out of check
        //a way to simplify the moving of it would be to see if any of the surrounding spaces are contained int he check
        //if they aren't return true
        //otherwise, check for enemyies in the surrounding spaces
        //remove that enemy from the board
        //test for movmenets again
        //if works, quit
        //otherwise
        //do some crazy code for checking if your pieces and block the check

        if (this.check())//if in cehck
        {
            //move to all the spaces to see if I get out of check
            //create a dummy board to hold original config
            JPanel dPanel = jPanel1;
            JPlayer[] dPlayers = players;
            //move to each of the spaces


            //check all the other possible movements for our pieces
            //move all pieces to every location
            //check if check
            for (JPiece p : players[currPly.ordinal()].getPieces()) {

                if (!checkMovements(p)) {
                    jPanel1 = dPanel;
                    players = dPlayers;
                    refreshBoard();
                    return false;
                }

                jPanel1 = dPanel;
                players = dPlayers;
                refreshBoard();
            }
            return true;
        }
        return false;
    }

    /*
     * @return false if Not in check, true if it is
     */
    private boolean check() {
        //get the kings space
        //compare it to the arraylist of enemy movements
        //if there is one in the enemy movements then return true
        //else return false
        JPiece king = players[currPly.ordinal()].getKing();
        ArrayList enemy = this.getEnemyPiecesAttacks();

        //gets a list of enemy moves, if the king is on one of them, he is in check
        if (this.contains(enemy, king.getSquare())) {
            return true;
        }

        return false;
    }

    //checks if the moving of the piece will cause the king to be in check
    //by movign them there and testing for check
    private boolean checkSpace(JPiece j, int i) {
        //move king, update pieces
        boolean found = true;
        if (this.isValid(i, j.getSquare()) //valid square
                && this.pieceOwner(i) != j.getColor()) {  //not a friendly, (empty or enemy)

            int pre = j.getSquare();
            JPiece removed = this.move(j, (JSquare) jPanel1.getComponent(i)); //move to new location, grab the piece that was removed at the location

            if (!this.check()) //there is some way to get out of check
            {
                found = false;
            }
            //move back
            this.move(j, (JSquare) jPanel1.getComponent(pre));

            if (removed != null) //assuming there is a piece that was taken off
            {
                ((JSquare) jPanel1.getComponent(i)).add(removed); //add it back
                players[removed.color.ordinal()].addPiece(removed); //add it back into the players hand
            }
        }


        return found; //no way out of check
    }

    //checks all the possible movements of a certain piece, to see if it will block the check by the enemy
    private boolean checkMovements(JPiece j) {
        ArrayList possible = this.possibleMovements(j);
        for (int i = 0; i < possible.size(); i++) { //for each of the possible movements
            if (!checkSpace(j, (int) possible.get(i))) //its not in check
            {
                return false; //pass back
            }
        }
        return true;  //else your in check
    }

    /*
     * @return The locations of all possible enemy attacks
     */
    private ArrayList getEnemyPiecesAttacks() {
        ArrayList move = new ArrayList();
        for (JPiece j : players[(currPly.ordinal() + 1) % 2].getPieces()) {
            //make sure not a pawn
            //add all peices to arraylist
            //for pawn, add the diagonals
            //return all the spaces
            if (j.getPiece() != Piece.Pawn) {
                move.addAll(this.possibleMovements(j));
            } else {
                //adds the 2 diagonal pieces to the board
                for (int i = -1; i < 2; i += 2) {
                    int space = j.getSquare() + j.getMovements()[0];
                    if (this.isValid(space + i, space)) {
                        move.add(j.getSquare() + i);
                    }
                }
            }
        }
        return move; //returns the list of all possible enemy movements. Or in other terms, where the king cant be
    }

    //mvoes the piece
    //used for moving the pieces by ther person, and by the test for check
    private JPiece move(JPiece p, JSquare moveTo) {
        JSquare moveFrom = ((JSquare) jPanel1.getComponent(p.getSquare()));  //gets the square we are movign from

        JPiece removed = this.getPiecesInSpace(moveTo.getSquare()); //gets the piece that is occuping the space we are movign to

        players[0].removePiece(removed);//it wont matter which players item it is
        players[1].removePiece(removed);//it will only remove if it has the same properties

        moveFrom.removeAll();  //removes all from the current space
        moveFrom.repaint();    //and repaints it
        p.setSquare(moveTo.getSquare());  //sets the new square for the piece
        moveTo.removeAll();   //removes all fromt eh piece on the new square
        moveTo.add(p);        //adds the current piece to that location
        moveTo.repaint();     //repaints to show the pircture on the board

        return removed;       //the reutrn is only used for the testing for check
        //and whether it is check mate or just check
    }

    
    private void refreshBoard() //this was just a test to see if it would help, ---- It didn't
    {
        //goes through each of the panels, and repaints them
        for (int i = 0; i < 64; i++) {
            ((JSquare) jPanel1.getComponent(i)).repaint();
        }
    }

    /*
     * @param a : All the possible movements
     * Toggles all the squares to blue (that are in the array list
     */
    private void toggleAllSquares(ArrayList a) {
        for (int i = 0; i < a.size(); i++) {
            this.toggleColor((int) a.get(i));
        }
    }

    //checks to see if an arraylist contains a certain integer value
    //Used in the check to see if any of the enemys pieces
    private boolean contains(ArrayList a, int j) {
        for (int i = 0; i < a.size(); i++) {
            if (j == (int) a.get(i)) {
                return true;
            }
        }
        return false;
    }

    /*
     * @param space : Space we want to know is valid
     * @param pre : Space that was sequentually before the space we are testing on
     * @return whether it is a valid space
     */
    public boolean isValid(int space, int pre) {
        if (space < 0 || space > 63) { //above or below the boudns of the board
            return false;
        }

        //makes sure it doesn't pass over the left or right edge of the board
        if (pre % 8 == 0 && space % 8 == 7) //left edge
        {
            return false;
        }
        if (pre % 8 == 7 && space % 8 == 0) //right edge
        {
            return false;
        }

        if (this.getPiecesInSpace(pre) != null && //makes sure not empty space
                this.getPiecesInSpace(pre).getPiece() == Piece.Knight) //knights are special in taht they can move accros the boundries of the left and right side of the board without touching the edge
        {
            int overall = space - pre;
            //get the overall left right directions
            //such as
            /*
             * -9  -8  -7
             * -1  0   1
             * 7   8   9
             * 
             * the -9, -1, and 7 will return a negative number
             * while the -7, 1, 9 will returna positive number
             */
            while (Math.abs(overall) > 4) {
                if (overall < 0) {
                    overall += 8;
                } else {
                    overall -= 8;
                }
            }

            if (pre % 8 > space % 8 && overall > 0)//where it is on the left (of the previous loc) and the overall direction is going right
            {
                return false;
            } else if (pre % 8 < space % 8 && overall < 0) //it is on the right (of the previous loc) and the overall direction is going left
            {
                return false;
            }
        }

        return true; //valid space
    }
}
