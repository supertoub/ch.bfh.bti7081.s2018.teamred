package Business;

import java.util.ArrayList;
import java.util.List;

class LevelLibrary {
    private List<Level> levels;

    List<Level> getLevels(){
        return levels;
    }

    LevelLibrary(){
        levels = new ArrayList<>();
    }

    void createNewLevel(){
        levels.add(new Level("Level " + (levels.size()+1)));
    }

    void delete(Challange challange){}
}
