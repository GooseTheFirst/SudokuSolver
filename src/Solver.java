import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solver {
    private Sudoku sudoku;
    private Map<Integer,Integer> values = new HashMap<Integer,Integer>();
    private int sudokuSize;
    private boolean solved;

    public Solver(Sudoku sudoku) {
        this.sudoku = sudoku;
        for (int i = 1; i <= this.sudoku.getSize(); i++) {
            values.put(i,i);
        }
        this.sudokuSize = this.sudoku.getSize();
        this.solved = false;
    }

    public Map<Integer,Integer> findPossibleValues(int row, int col) {
        int box = this.sudoku.getBox(row,col);
        Map<Integer,Integer> possibleValues = new HashMap<Integer,Integer>(values);
        for (int i = 0; i < this.sudoku.getSize(); i++) {
            int rowVal = this.sudoku.getValue(i,col);
            int colVal = this.sudoku.getValue(row,i);
            if (rowVal != 0) {
                possibleValues.remove(rowVal);
            }
            if (colVal != 0) {
                possibleValues.remove(colVal);
            }
        }
        for (int i = 0; i < this.sudoku.getSize(); i++) {
            for (int j = 0; j < this.sudoku.getSize(); j++) {
                if (this.sudoku.getBox(i,j) == box) {
                    int boxVal = this.sudoku.getValue(i,j);
                    if (boxVal != 0) {
                        possibleValues.remove(boxVal);
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
                        Map<Integer, Integer> posVals = findPossibleValues(i, j);
                        if (posVals.size() == 1) {
                            Set<Integer> val = posVals.keySet();
                            for (Integer key : val) {
                                this.sudoku.setValue(i, j, posVals.remove(key));
                            }
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
