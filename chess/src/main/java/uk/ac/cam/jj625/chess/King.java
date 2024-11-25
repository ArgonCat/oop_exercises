package uk.ac.cam.jj625.chess;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public static int KING_VALUE = 10000;

    public King(Position piecePosition, PieceColor pieceColor, Board board) {
        super(piecePosition, pieceColor, board);
    }
    @Override
    public int value() {
        return KING_VALUE;
    }
    @Override
    public String name() {
        return "King";
    }

    @Override
    public char icon() {
        boolean colourSwitch = colour() == PieceColor.BLACK;
        return colourSwitch ? '♚' : '♔';
    }
    @Override
    public List<Position> validNextPositions() {
        List<Position> nextPositions = new ArrayList<>();
        position().getAllDiagonalMoves(1, board(), nextPositions);
        position().getAllStraightMoves(1, board(), nextPositions);
        return nextPositions;
    }

}