package Business;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class LevelLibrary extends Observable implements Observer {

    //region Variablen

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "levellibrary_id")
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="level_id")
    private List<Level> levels;

    //endregion

    //region Getter

    public List<Level> getLevels(){
        return levels;
    }

    public long getId() {
        return id;
    }

    //endregion

    //region Setter

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    //endregion

    //region Konstruktor

    public LevelLibrary(Observer observer){
        this.addObserver(observer);
        this.levels = new ArrayList<>();
    }

    //endregion

    //region Methoden

    public Level createNewLevel() {
        int levelCount = levels.size();
        Level newLevel = new Level("Level " + (levels.size() + 1), levelCount, this);
        levels.add(newLevel);
        return newLevel;
    }

    public Level createNewLevel(LevelState levelState){
        int levelCount = levels.size();
        Level newLevel = new Level("Level " + (levels.size()+1), levelCount, this);
        newLevel.setLevelState(levelState);
        levels.add(newLevel);
        return newLevel;
    }

    //endregion

    //region Events

    @Override
    public void update(Observable o, Object arg) {
        Level updatedLevel = (Level) o;

        int levelCount = updatedLevel.getLevelCount();
        if ((levelCount + 1) > (levels.size() - 1)){
            return;
        }

        Level nextLevel = levels.get(updatedLevel.getLevelCount() + 1);
        nextLevel.setLevelState(LevelState.open);
        this.setChanged();
        this.notifyObservers();
    }

    //endregion

}
