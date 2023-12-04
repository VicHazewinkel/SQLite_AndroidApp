package be.ehb.sqlite.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import be.ehb.sqlite.model.DataBase;
import be.ehb.sqlite.model.DatabaseTable;

// 4.
// aanmaken van de DataViewModel klasse
// zorgt voor de communicatie tussen de UI en de database
//


public class DataViewModel extends AndroidViewModel {

    private ExecutorService mExecutorService;
    private DataBase mDatabase;


    public DataViewModel(@NonNull Application application) {
        super(application);
        mExecutorService = Executors.newFixedThreadPool(2);
        mDatabase = DataBase.getInstance(application);
    }

    // insert data

    public void insertData(DatabaseTable f){
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                mDatabase.getDataDAO().insertData(f);
            }
        });
    }

    //
    public LiveData<List<DatabaseTable>> getAllData(){
        return mDatabase.getDataDAO().getAllData();
    }
}
