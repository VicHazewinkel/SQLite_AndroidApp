package be.ehb.sqlite.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// 2.
//  aanmaken van de Data Access Object (DAO) interface
//  met de methoden insertData, getAllData, getByNaam, getByKleur, getDataByKleur, updateData en deleteData
//  zorgt voor de communicatie met de database
//

@Dao
public interface DataDAO {
    @Insert
    void insertData(DatabaseTable f);

    @Query("SELECT * FROM DatabaseTable")                               // select all
    LiveData<List<DatabaseTable>> getAllData();

    @Query("SELECT * FROM DatabaseTable ORDER By naam")                 // sorteren op naam
    LiveData<List<DatabaseTable>> getByNaam();

    @Query("SELECT * FROM DatabaseTable ORDER By kleur")                // sorteren op kleur
    LiveData<List<DatabaseTable>> getByKleur();

    @Query("SELECT * FROM DatabaseTable WHERE kleur LIKE :kleur")       // filteren op kleur
    LiveData<List<DatabaseTable>> getDataByKleur(String kleur);

    @Update
    void updateData(DatabaseTable f);                                   // update

    @Delete
    void deleteData(DatabaseTable f);                                   // delete
}
