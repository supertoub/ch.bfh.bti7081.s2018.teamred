package Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class LevelLibrary extends Observable implements Observer {
    private List<Level> levels;

    List<Level> getLevels(){
        return levels;
    }

    LevelLibrary(Observer observer){
        this.addObserver(observer);
        this.levels = new ArrayList<>();
    }

    Level createNewLevel(){
        int levelCount = levels.size();
        Level newLevel = new Level("Level " + (levels.size()+1), levelCount, this);
        levels.add(newLevel);
        return newLevel;
    }

    Level createNewLevel(LevelState levelState){
        int levelCount = levels.size();
        Level newLevel = new Level("Level " + (levels.size()+1), levelCount, this);
        newLevel.setLevelState(levelState);
        levels.add(newLevel);
        return newLevel;
    }

    void delete(Challenge challenge){}

    //region Events

    @Override
    public void update(Observable o, Object arg) {
        Level updatedLevel = (Level) o;
        Level nextLevel = levels.get(updatedLevel.getLevelCount() + 1);
        nextLevel.setLevelState(LevelState.open);
        this.setChanged();
        this.notifyObservers();
    }

    //endregion
}
