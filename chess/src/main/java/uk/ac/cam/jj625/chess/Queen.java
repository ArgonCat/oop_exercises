package uk.ac.cam.jj625.chess;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{


    public Queen(Position piecePosition, PieceColor pieceColor, Board board) {
        super(piecePosition, pieceColor, board);
    }
    @Override
    public int value() {
        return 10;
    }
    @Override
    public String name() {
        return "Queen";
    }
    @Override
    public char icon() {
        boolean colourSwitch = colour() == PieceColor.BLACK;
        return colourSwitch ? '♛' : '♕';
    }
    @Override
    public List<Position> validNextPositions() {
        List<Position> nextPositions = new ArrayList<>();
        position().getAllDiagonalMoves(8, board(), nextPositions);
        position().getAllStraightMoves(8, board(), nextPositions);
        return nextPositions;
    }
}
