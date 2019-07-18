package game6;

public class SolveCommand implements Command {

    Solve solve;

    public SolveCommand(Solve solve) {
        this.solve = solve;
    }

    @Override
    public void execute() {
        solve.click();
    }

}
