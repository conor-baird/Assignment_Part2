package model;

import java.util.Arrays;

public class TicTacToe {
    public enum Cell {
        EMPTY, X, O
    }

    public enum Status {
        PLAYING, O_WON, X_WON, DRAW
    }

    private Cell[] cells;
    private boolean isCross;
    private int countMoves;

    public TicTacToe() {
        cells = new Cell[9];
        Arrays.fill(cells, Cell.EMPTY);
        isCross = true;
    }

    public String[] getState() {
        String[] letters = new String[9];
        for (int i = 0; i < letters.length; ++i) {
            switch (cells[i]) {
                case EMPTY:
                    letters[i] = " ";
                    break;
                case X:
                    letters[i] = "X";
                    break;
                case O:
                    letters[i] = "O";
                    break;
            }
        }
        return letters;
    }

    public boolean placeNextPiece(int position) {
        if (countMoves < cells.length && cells[position] == Cell.EMPTY) {
            ++countMoves;
            cells[position] = isCross ? Cell.X : Cell.O;
            isCross = !isCross;
            return true;
        }
        return false;
    }

    public Status checkStatus() {
        // check each row and each column for wins
        // Note: cells is 1D, so need to convert 2D (row,col) into 1D (position)
        // Note: we achieve simultaneous row and column checking via
        // two types of position!

        final int SIZE = cells.length / 3;
        int[] diagonalCounts = new int[4];  // first diagonal Os, first diagonal Xs, second diagonal Os, second diagonal Xs
        for (int row = 0; row < SIZE; ++row) {
            int[] counts = new int[4];  // horizontal Xs, horizontal Os, vertical Xs, vertical Os

            for (int col = 0; col < SIZE; ++col) {
                int positionX = row * 3 + col;
                int positionY = row + col * 3;

                if (cells[positionX] == Cell.O) {
                    ++counts[0];
                } else if (cells[positionX] == Cell.X) {
                    ++counts[1];
                }
                if (cells[positionY] == Cell.O) {
                    ++counts[2];
                } else if (cells[positionY] == Cell.X) {
                    ++counts[3];
                }
            }

            if (counts[0] == 3 || counts[2] == 3) {
                return Status.O_WON;
            } else if (counts[1] == 3 || counts[3] == 3) {
                return Status.X_WON;
            }

            int diagonal1 = row * 4;
            int diagonal2 = row * 2 + 2;

            if (cells[diagonal1] == Cell.O) {
                ++diagonalCounts[0];
            }
            if (cells[diagonal1] == Cell.X) {
                ++diagonalCounts[1];
            }
            if (cells[diagonal2] == Cell.O) {
                ++diagonalCounts[2];
            }
            if (cells[diagonal2] == Cell.X) {
                ++diagonalCounts[3];
            }
        }

        if (diagonalCounts[0] == 3 || diagonalCounts[2] == 3) {
            return Status.O_WON;
        } else if (diagonalCounts[1] == 3 || diagonalCounts[3] == 3) {
            return Status.X_WON;
        }

        if (countMoves == 9) {
            return Status.DRAW;
        }

        return Status.PLAYING;
    }
}
