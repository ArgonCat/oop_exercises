package uk.ac.cam.jj625.chess;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    public Knight(Position piecePosition, PieceColor pieceColor, Board board) {
        super(piecePosition, pieceColor, board);
    }
    @Override
    public int value() {
        return 3;
    }
    @Override
    public String name() {
        return "Knight";
    }
    @Override
    public char icon() {
        boolean colourSwitch = colour() == PieceColor.BLACK;
        return colourSwitch ? '♞' : '♘';
    }
    private void computeKnightNextPositions(List<Position> nextPositions) {
        // directions a knight can travel in.
        final int[][] nextPosDeltas =
                new int[][] {
                        {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
                        {2, 1}, {-2, 1}, {2, -1}, {-2, -1}
                };

        // iterate through all possible positions, getting any valid next positions
        for (int[] posDeltaPair : nextPosDeltas) {
            position().addPosAtDelta(posDeltaPair[0], posDeltaPair[1], board(), nextPositions);
        }
    }

    @Override
    public List<Position> validNextPositions() {
        List<Position> nextPositions = new ArrayList<>();
        computeKnightNextPositions(nextPositions);
        return nextPositions;
    }
}
