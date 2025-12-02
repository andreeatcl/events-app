package ro.ase.pdm.events.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ro.ase.pdm.events.model.Eveniment;

@Database(entities = Eveniment.class, version = 1)
public abstract class EvenimenteDatabase extends RoomDatabase {
    private static EvenimenteDatabase instanta;
    public static EvenimenteDatabase getInstance(Context context) {
        if (instanta == null) {
            instanta = Room.databaseBuilder(context, EvenimenteDatabase.class, "events.db")
                    .fallbackToDestructiveMigration(true)
                    // de eliminat! - permitem accesul in main thread pt testare
                    // .allowMainThreadQueries() // toate apelurile trb sa fie asincrone!!
                    .build();
        }
        return instanta;
    }
    public abstract EvenimentDAO getEvenimentDao();
}
