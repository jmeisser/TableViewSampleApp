package com.evrencoskun.tableviewsample2.ImportedDatabase;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.evrencoskun.tableviewsample2.AppExecutors;
import com.evrencoskun.tableviewsample2.data.UserRepository;
import com.evrencoskun.tableviewsample2.data.database.UserDao;
import com.evrencoskun.tableviewsample2.data.network.UserNetworkDataSource;

import java.util.List;

public class WordRepository {

    private static final String LOG_TAG = WordRepository.class.getSimpleName();

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;
    private List<Word> mAllDeadWords;
    private WordRoomDatabase db;
    private static WordRepository sInstance;
    private static final Object LOCK = new Object();

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public static WordRepository getInstance(Application application) {
        Log.d(LOG_TAG, "Getting the repository");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new WordRepository(application);
                Log.d(LOG_TAG, "Made new repository");
            }
        }
        return sInstance;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }
    WordRoomDatabase getDb(){
        return db;
    }
}
