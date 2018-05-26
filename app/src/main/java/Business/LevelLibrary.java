package Business;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class LevelLibrary {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "levellibrary_id")
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="level_id")
    private List<Level> levels;

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
    }

    void delete(Challenge challenge){}

}
