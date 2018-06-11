package Business;

import Data.LevelLibraryPersistence;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="levellibrary")
public class LevelLibrary extends Observable implements Observer {

    //region Variablen

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "levellibrary_id")
    private long id;

    @OneToMany(mappedBy = "levelLibrary", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Level> levels;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Patient patient;


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

    public LevelLibrary(List<Level> levels, Patient patient, Observer observer) {
        this.levels = levels;
        this.patient = patient;
        this.addObserver(observer);
    }
    public LevelLibrary(List<Level> levels, Observer observer) {
        this.levels = levels;
        this.addObserver(observer);
    }

    // no-arg constructur needed by hibernate for object creation via reflection
    public LevelLibrary(){}

    //endregion

    //region Methoden

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
