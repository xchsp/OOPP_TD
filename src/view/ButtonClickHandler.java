package view;

import model.game.tower.Tower;
import utils.Vector;

/**
 * @author Sebastian
 * An interface for a controller used by the view to add new buttons.
 */
public interface ButtonClickHandler {
    /**
     * Adds a button without an argument
     *
     * @param percentStartPos        startPos as a percent of window size
     * @param percentSize            size of button as a percent of window size
     * @param onClickWithoutArgument what will happen when button is clicked on
     */
    void addButtonWithoutArgument(Vector percentStartPos, Vector percentSize, OnClickWithoutArgument onClickWithoutArgument);

    /**
     * Sets the selected tower as the tower class from the corresponding button.
     * @param towerClass the tower to be selected.
     */
    void setSelectedTower(Class<? extends Tower> towerClass);
}
