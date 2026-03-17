public class DummySudoku {
    private String sudoku = "0,0,3,0,7,2,4,0,9,0,9,0,0,0,1,7,5,2,0,7,0,5,0,0,0,0,6,0,3,0,2,8,4,6,0,0,2,0,1,3,0,0,0,4,0,0,6,9,1,0,7,0,0,0,9,0,6,4,1,0,0,0,0,1,0,0,0,6,0,9,2,0,3,0,7,0,0,0,1,0,5";
    private Sudoku dummysudoku;

    public DummySudoku() {
        this.dummysudoku = new Sudoku(9);
        String[] sudokustring = sudoku.split(",");
        for (int i = 0; i < 81; i++) {
            this.dummysudoku.setValue(i,Integer.parseInt(sudokustring[i]));
        }
    }

    public Sudoku getDummySudoku() {
        return this.dummysudoku;
    }

    public static void main(String[] args) {
        DummySudoku dummysudoku = new DummySudoku();
        System.out.println(dummysudoku.getDummySudoku());
    }
}
