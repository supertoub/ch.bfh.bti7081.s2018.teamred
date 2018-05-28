package Business;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class LevelLibrary {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "levellibrary_id")
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="level_id")
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
    LevelLibrary(){
        levels = new ArrayList<>();
    }

    public LevelLibrary(List<Level> levels) {
        this.levels = levels;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    void createNewLevel(){
        levels.add(new Level("Level " + (levels.size()+1)));
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
