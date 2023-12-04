package be.ehb.sqlite.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// 3.
// specifies the entities included in the database
// storing data and provides methods for managing database connections and accessing data through DAOs.
//
//

// eerste versie  ||| entities in de database zijn allemaal van DatabaseTable
@Database(version = 1, entities = {DatabaseTable.class})
public abstract class DataBase extends RoomDatabase {

    private static DataBase INSTANCE;

    public static DataBase getInstance(Context context){
        if(INSTANCE == null){
            // maak database verbinding
            INSTANCE = Room.databaseBuilder(context,
                    DataBase.class,
                    "database")
                    .build();
        }
        return INSTANCE;
    }

    //
    public abstract DataDAO getDataDAO();



}
