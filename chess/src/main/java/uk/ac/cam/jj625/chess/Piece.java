/*
 * Copyright 2024 Ben Philps <bp413@cam.ac.uk>, J. Jinkinson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.jj625.chess;

import static uk.ac.cam.jj625.chess.PieceColor.BLACK;
import static uk.ac.cam.jj625.chess.PieceColor.WHITE;
import static uk.ac.cam.jj625.chess.Position.Rank.SEVEN;
import static uk.ac.cam.jj625.chess.Position.Rank.TWO;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {


  private Position position;
  private final PieceColor pieceColor;
  private final Board board;

  public Piece(Position piecePosition, PieceColor pieceColor, Board board) {
    this.position = piecePosition;
    this.pieceColor = pieceColor;
    this.board = board;
  }

  /* naming convention:
     K -> king
     P -> pawn
     B -> bishop
     N -> knight
     R -> rook
     Q -> queen
  */

  public abstract List<Position> validNextPositions() ;

  public abstract char icon() ;

  public abstract int value() ;

  public Position position() {
    return position;
  }

  public void moveTo(Position newPosition) {
    position = newPosition;
  }

  public PieceColor colour() {
    return pieceColor;
  }

  public abstract String name();

  public String toString() {
    return name() + " " + position.toString();
  }

  public Board board() {
    return board;
  }
}
