package com.evrencoskun.tableviewsample2.utility;

import android.app.Application;
import android.content.Context;

import com.evrencoskun.tableviewsample2.AppExecutors;
import com.evrencoskun.tableviewsample2.ImportedDatabase.WordDao;
import com.evrencoskun.tableviewsample2.ImportedDatabase.WordRepository;
import com.evrencoskun.tableviewsample2.ImportedDatabase.WordRoomDatabase;
import com.evrencoskun.tableviewsample2.data.UserRepository;
import com.evrencoskun.tableviewsample2.data.database.UserDao;
import com.evrencoskun.tableviewsample2.data.database.UserDatabase;
import com.evrencoskun.tableviewsample2.data.network.UserNetworkDataSource;
import com.evrencoskun.tableviewsample2.ui.viewmodel.MainViewModelFactory;

public class InjectorUtils {

    public static WordRepository getRepository(Application application, Context context) {
        // Get all we need
        WordDao wordDao = WordRoomDatabase.getDatabase(context).wordDao();
        AppExecutors executors = AppExecutors.getInstance();
        UserNetworkDataSource networkDataSource = UserNetworkDataSource.getInstance(executors);

        return WordRepository.getInstance(application);
    }

    public static MainViewModelFactory getMainViewModelFactory(Application application, Context context){
        WordRepository repository = getRepository(application, context);
        return new MainViewModelFactory(repository);
    }

}
