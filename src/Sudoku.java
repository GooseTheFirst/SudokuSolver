public class Sudoku {
    private int[][] sudoku;
    private int size;

    public Sudoku(int size) {
        this.sudoku = new int[size][size];
        this.size = size;
    }

    public Sudoku(int[][] sudoku) {
        this.sudoku = sudoku;
        this.size = sudoku.length;
    }

    public void setValue(int row, int col, int value) {
        this.sudoku[row][col] = value;
    }

    public void setValue(int index, int value) {
        this.sudoku[index/9][index%9] = value;
    }

    public int getValue(int row, int col) {
        return this.sudoku[row][col];
    }

    public int getValue(int index) {
        return this.sudoku[index/9][index%9];
    }

    public int getSize() {
        return this.size;
    }

    public int getBox(int row, int col) {
        double box = Math.sqrt(this.size) * (row/3) + (col/3);
        return (int) box;
    }

    public String toString() {
        String sudokustring = "";
        for (int i = 0; i < this.size; i++) {
            if (i != 0 && i % 3 == 0) {
                sudokustring += "---------+---------+---------\n";
            }
            for (int j = 0; j < this.size; j++) {
                if (j % 3 == 0 && j != 0) {
                   sudokustring += "|";
                }
                int val = this.sudoku[i][j];
                if (val != 0) {
                    sudokustring += " " + val + " ";
                }
                else {
                    sudokustring += "   ";
                }
            }
            sudokustring += "\n";
        }
        return sudokustring;
    }
}
