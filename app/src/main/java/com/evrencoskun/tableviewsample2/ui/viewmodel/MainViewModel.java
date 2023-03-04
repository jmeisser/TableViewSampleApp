package com.evrencoskun.tableviewsample2.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.evrencoskun.tableviewsample2.ImportedDatabase.Word;
import com.evrencoskun.tableviewsample2.ImportedDatabase.WordRepository;

import java.util.List;

public class MainViewModel extends ViewModel {

    private final WordRepository mRepository;
    private final LiveData<List<Word>> mWordData;

    public MainViewModel(WordRepository mRepository) {
        this.mRepository = mRepository;
        this.mWordData = mRepository.getAllWords();
    }

    public LiveData<List<Word>> getWordList() {
        return mWordData;
    }

/*    public void postRequest(ServiceRequest serviceRequest) {
        mRepository.postServiceRequest(serviceRequest);
    }*/
}
