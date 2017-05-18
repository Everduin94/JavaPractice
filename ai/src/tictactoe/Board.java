package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Erik Verduin
 */
public class Board {
    private List<Cell> emptyCells;
    private Scanner scanner;
    private CellState[][] board;
    private List<Cell> rootValues;

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        this.rootValues = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.board = new CellState[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
    }

    public boolean isRunning() {
        if (isWinning(CellState.COMPUTER)) {
            return false;
        }
        if (isWinning(CellState.USER)) {
            return false;
        }

        if (getEmptyCells().isEmpty()) {
            return false;
        }

        return true;
    }

    public Cell getBestMove() {
        int max = Integer.MIN_VALUE;
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < rootValues.size(); ++i) {
            if (max < rootValues.get(i).getMinimaxValue()) {
                max = rootValues.get(i).getMinimaxValue();
                best = i;
            }
        }

        return rootValues.get(best);
    }

    public void makeUserInput() {
        System.out.println("User's move: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Cell cell = new Cell(x, y);
        move(cell, CellState.USER);
    }

    public void setupBoard() {
        for (int i = 0; i < Constants.BOARD_SIZE; ++i) {
            for (int j = 0; j < Constants.BOARD_SIZE; ++j) {
                board[i][j] = CellState.EMPTY;
            }
        }
    }

    public boolean isWinning(CellState player) {

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        for (int i = 0; i < Constants.BOARD_SIZE; ++i) {

            // Rows
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }

            // Columns
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        return false;
    }

    private List<Cell> getEmptyCells() {
        emptyCells = new ArrayList<>();
        for (int i = 0; i < Constants.BOARD_SIZE; ++i) {
            for (int j = 0; j < Constants.BOARD_SIZE; ++j) {
                if (this.board[i][j] == CellState.EMPTY) {
                    emptyCells.add(new Cell(i, j));
                }
            }
        }

        return emptyCells;
    }

    public int returnMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int index = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) < min) {
                min = list.get(i);
                index = i;
            }
        }

        return list.get(index);
    }

    public int returnMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        int index = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }

        return list.get(index);
    }

    public void move(Cell cell, CellState player) {
        this.board[cell.getX()][cell.getY()] = player;
    }

    public void displayBoard() {
        System.out.println();

        for (int i = 0; i < Constants.BOARD_SIZE; ++i) {
            for (int j = 0; j < Constants.BOARD_SIZE; ++j) {
                System.out.print(this.board[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void setEmptyCells(List<Cell> emptyCells) {
        this.emptyCells = emptyCells;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public CellState[][] getBoard() {
        return board;
    }

    public void setBoard(CellState[][] board) {
        this.board = board;
    }

    public List<Cell> getRootValues() {
        return rootValues;
    }

    public void setRootValues(List<Cell> rootValues) {
        this.rootValues = rootValues;
    }

    public void callMinimax(int depth, CellState player) {
        rootValues.clear(); //Depth how many layers in game tree
        miniMax(depth, player);
    }

    private int miniMax(int depth, CellState player) {
        //Simulates playing against the player
        if (isWinning(CellState.COMPUTER)) {
            return 1;
        }

        if (isWinning(CellState.USER)) {
            return -1;
        }

        List<Cell> availableCells = getEmptyCells();
        if (availableCells.isEmpty()) {
            return 0;
        }

        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < availableCells.size(); i++) {
            Cell point = availableCells.get(i);

            if (player == CellState.COMPUTER) {
                move(point, CellState.COMPUTER); // Move for the computer

                //Calculate next step for the user
                int currentScore = miniMax(depth + 1, CellState.USER); //Keep traversing game tree in DFS manner
                scores.add(currentScore);

                if (depth == 0) {
                    point.setMinimaxValue(currentScore);
                    rootValues.add(point);
                }
            } else if (player == CellState.USER) {
                move(point, CellState.USER); // Make move for user

                //Calculate next step for computer
                scores.add(miniMax(depth + 1, CellState.COMPUTER));
            } // simulating the players moves

            board[point.getX()][point.getY()] = CellState.EMPTY;
        }

        if (player == CellState.COMPUTER) {
            return returnMax(scores); // return maximum score for computer
        }

        return returnMin(scores); //return minimum score for user
    }
}
