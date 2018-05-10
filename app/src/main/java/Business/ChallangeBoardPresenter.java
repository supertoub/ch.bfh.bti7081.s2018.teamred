package Business;

import UserInterface.ChallangeBoardView;

import java.util.List;

// implemented as singleton
public class ChallangeBoardPresenter  {

    private static ChallangeBoardPresenter instance;

    private ChallangeBoardView boardView;

    private LevelLibrary lvlLibrary;

    //<editor-fold desc="getter">

    public ChallangeBoardView getBoardView (){
        return boardView;
    }

    public static ChallangeBoardPresenter getInstance(){
        if (instance == null){
            instance = new ChallangeBoardPresenter();
        }

        return instance;
    }

    //</editor-fold>

    //<editor-fold desc="constructors">

    private ChallangeBoardPresenter(){
        boardView = new ChallangeBoardView();
        lvlLibrary = new LevelLibrary();
        for (int i = 1; i <= 15; i++){
            lvlLibrary.createNewLevel();
        }
        updateLevelView();
    }

    //</editor-fold>

    private void updateLevelView(){
        List<Level> levels = lvlLibrary.getLevels();
        for (Level level : levels){
            boardView.addLevel(level.getLevelLabel(), level.getLevelState());
        }
    }

    void addClick(){}

    void deleteClick(Object sender){}

    void changeClick(){}
}
