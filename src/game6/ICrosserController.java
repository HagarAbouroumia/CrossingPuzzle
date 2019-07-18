package game6;

import java.util.List;

public interface ICrosserController {

    /**
     * * this method initialize the controller with game strategy according *
     * to the level * @param gameStrategy
     */
    public void newGame(ICrosserStrategy gameStrateegy);

    /**
     * * resets the game without changing the strategy
     */
    public void resetGame();

    /**
     * * @return the current strategy instructions if the user want to see them
     */
    public String[] getInstructions();

    /**
     * * @return list of crossers on the right bank of the river
     */
    public List<ICrosser> getCrossersOnRightBank();

    /**
     * * @return list of crossers on the left bank of the river
     */
    public List<ICrosser> getCrossersOnLeftBank();

    public boolean isBoatOnTheLeftBank();

    public int getNumberofSails();

    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank);

    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank);

    public boolean canRdo();

    public void undo();

    public void redo();

    public void loadGame();

    public List<List<ICrosser>> solveGame();

    public boolean canMoveToBoat(List<ICrosser> crossers, ICrosser crooser, boolean fromLeftToRightBank);
}
