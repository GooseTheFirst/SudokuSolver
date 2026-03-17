public static void main(String[] args) {
    DummySudoku dummy = new DummySudoku();
    Solver solver = new Solver(dummy.getDummySudoku());
    System.out.println(dummy.getDummySudoku());
    System.out.println("\n\n");
    System.out.println(solver.solve());
}