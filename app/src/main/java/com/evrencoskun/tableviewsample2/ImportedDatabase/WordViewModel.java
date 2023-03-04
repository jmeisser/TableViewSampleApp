package com.evrencoskun.tableviewsample2.ImportedDatabase;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private final LiveData<List<Word>> mAllWords;
    //private final List<Word> mAllDeadWords;

    public WordViewModel (Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
        //mAllDeadWords = mRepository.getAllDeadWords();
    }

    LiveData<List<Word>> getAllWords() { return mAllWords; }


    public void insert(Word word) { mRepository.insert(word); }

    WordRoomDatabase getDb() {
       return mRepository.getDb();
    }
}
