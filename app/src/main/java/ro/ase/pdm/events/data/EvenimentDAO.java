package ro.ase.pdm.events.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ro.ase.pdm.events.model.Eveniment;

@Dao
public interface EvenimentDAO {
    // data access object
    @Query("SELECT * FROM evenimente")
    List<Eveniment> getAll();

    @Insert
    long insert(Eveniment eveniment);

    // @Update
    // @Delete - un singur element
    @Delete
    void delete(Eveniment eveniment);

}
