package uk.ac.cam.jj625.chess;

import java.util.ArrayList;
import java.util.List;

import static uk.ac.cam.jj625.chess.PieceColor.BLACK;
import static uk.ac.cam.jj625.chess.PieceColor.WHITE;
import static uk.ac.cam.jj625.chess.Position.Rank.SEVEN;
import static uk.ac.cam.jj625.chess.Position.Rank.TWO;

public class Pawn extends Piece{

    public Pawn(Position piecePosition, PieceColor pieceColor, Board board) {
        super(piecePosition, pieceColor, board);
    }
    @Override
    public int value() {
        return 1;
    }
    @Override
    public String name() {
        return "Pawn";
    }
    @Override
    public char icon() {
        boolean colourSwitch = colour() == PieceColor.BLACK;
        return colourSwitch ? '♟' : '♙';
    }

    @Override
    public List<Position> validNextPositions() {
        List<Position> nextPositions = new ArrayList<>();
        computePawnNextPositions(nextPositions);
        return nextPositions;
    }


    private void computePawnNextPositions(List<Position> nextPositions) {
        // The En passant move is not included.
        // The Promotion is not included.

    /*
    pawns can move up 1 if it is a non occupied square.
    pawns can move (and take) up 1 and left or right 1 if the square is occupied by an opponent
    pawns can move up 2 if they are currently on their home row (pawns cannot go backwards)

     */

        int upDir = (colour() == WHITE ? 1 : -1);

        // move up by one
        addPawnPositionIfValid(upDir, 0, false, nextPositions);

        // move up left and right
        addPawnPositionIfValid(upDir, -1, true, nextPositions);
        addPawnPositionIfValid(upDir, 1, true, nextPositions);

        // move up two if on their home row
        if (position().getRank() == (colour() == BLACK ? SEVEN : TWO)) {
            addPawnPositionIfValid(upDir + upDir, 0, false, nextPositions);
        }
    }

    private void addPawnPositionIfValid(
            int deltaRank,
            int deltaFile,
            boolean allowIfOccupiedByOpponent,
            List<Position> nextPositions) {

        Position movePosition = position().getPosAtDelta(deltaRank, deltaFile);

        if (movePosition != null) {
            boolean movePosOccupied = board().positionOccupied(movePosition);
            // the up left and right cases
            if (allowIfOccupiedByOpponent
                    && movePosOccupied
                    && board().atPosition(movePosition).colour() != colour()) {
                nextPositions.add(movePosition);
            }
            // the "up straight ahead" and "up straight ahead two" moves.
            else if (!allowIfOccupiedByOpponent && !movePosOccupied) {
                nextPositions.add(movePosition);
            }
        }
    }
}
