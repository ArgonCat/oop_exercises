package uk.ac.cam.jj625.chess;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{

    public Bishop(Position piecePosition, PieceColor pieceColor, Board board) {
        super(piecePosition, pieceColor, board);
    }
    @Override
    public int value() {
        return 3;
    }

    @Override
    public String name() {
        return "Bishop";
    }

    @Override
    public char icon() {
        boolean colourSwitch = colour() == PieceColor.BLACK;
        return colourSwitch ? '♝' : '♗';
    }
    @Override
    public List<Position> validNextPositions() {
        List<Position> nextPositions = new ArrayList<>();
        position().getAllDiagonalMoves(8, board(), nextPositions);
        return nextPositions;
    }
}
