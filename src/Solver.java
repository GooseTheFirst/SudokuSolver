import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solver {
    private Sudoku sudoku;
    private int values;
    private int sudokuSize;
    private boolean solved;

    public Solver(Sudoku sudoku) {
        this.sudoku = sudoku;
        this.sudokuSize = this.sudoku.getSize();
        this.values = (int) Math.pow(2,sudokuSize) - 1;
        this.solved = false;
        System.out.println(values);
    }

    public int findPossibleValues(int row, int col) {
        int box = this.sudoku.getBox(row,col);
        int possibleValues = values;
        Set<Integer> excluded = new HashSet<Integer>();
        for (int i = 0; i < this.sudoku.getSize(); i++) {
            int rowVal = this.sudoku.getValue(i,col);
            int colVal = this.sudoku.getValue(row,i);
            if (rowVal != 0) {
                int exclude = 1 << (rowVal - 1);
                if (!excluded.contains(exclude)) {
                    excluded.add(exclude);
                    possibleValues = possibleValues ^ exclude;
                }
            }
            if (colVal != 0) {
                int exclude = 1 << (colVal - 1);
                if (!excluded.contains(exclude)) {
                    excluded.add(exclude);
                    possibleValues = possibleValues ^ exclude;
                }
            }
        }
        for (int i = 0; i < this.sudoku.getSize(); i++) {
            for (int j = 0; j < this.sudoku.getSize(); j++) {
                if (this.sudoku.getBox(i,j) == box) {
                    int boxVal = this.sudoku.getValue(i,j);
                    if (boxVal != 0) {
                        int exclude = 1 << (boxVal - 1);
                        if (!excluded.contains(exclude)) {
                            excluded.add(exclude);
                            possibleValues = possibleValues ^ exclude;
                        }
                    }
                }
            }
        }
        return possibleValues;
    }

    public Sudoku deepCopy(Sudoku sudoku) {
        int size = sudoku.getSize();
        Sudoku deepCopy = new Sudoku(size);
        for (int i = 0; i < size * size; i++) {
            deepCopy.setValue(i,sudoku.getValue(i));
        }
        return deepCopy;
    }

    public boolean isSolved() {
        this.solved = true;
        int sudokusize = this.sudoku.getSize();
        for (int i = 0; i < sudokusize * sudokusize; i++) {
            if (this.sudoku.getValue(i) == 0) {
                this.solved = false;
                break;
            }
        }
        return this.solved;
    }

    public Sudoku solve() {
        while (!isSolved()) {
            for (int i = 0; i < this.sudokuSize; i++) {
                for (int j = 0; j < this.sudokuSize; j++) {
                    if (this.sudoku.getValue(i,j) == 0) {
                        int posVals = findPossibleValues(i, j);
                        switch (posVals) {
                            case 256:
                                this.sudoku.setValue(i,j,9);
                                break;
                            case 128:
                                this.sudoku.setValue(i,j,8);
                                break;
                            case 64:
                                this.sudoku.setValue(i,j,7);
                                break;
                            case 32:
                                this.sudoku.setValue(i,j,6);
                                break;
                            case 16:
                                this.sudoku.setValue(i,j,5);
                                break;
                            case 8:
                                this.sudoku.setValue(i,j,4);
                                break;
                            case 4:
                                this.sudoku.setValue(i,j,3);
                                break;
                            case 2:
                                this.sudoku.setValue(i,j,2);
                                break;
                            case 1:
                                this.sudoku.setValue(i,j,1);
                                break;
                            default:
                                break;
                        }
                    }
                }

            }
        }
        return this.sudoku;
    }

    public void detectRowPair() {
        for (int i = 0; i < this.sudokuSize; i++) {

        }
    }
}
