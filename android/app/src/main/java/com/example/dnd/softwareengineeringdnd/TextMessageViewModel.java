package com.example.dnd.softwareengineeringdnd;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.dnd.softwareengineeringdnd.TextMessage;
import com.example.dnd.softwareengineeringdnd.TextMessageRepo;

import java.util.ArrayList;
import java.util.List;

public class TextMessageViewModel extends AndroidViewModel {

    private TextMessageRepo mRepo;
    private LiveData<List<TextMessage>> mLiveData;

    public TextMessageViewModel(@NonNull Application application) {
        super(application);
        mRepo = new TextMessageRepo(application);
        mLiveData = mRepo.getUserMessages();
    }

    public void insert(TextMessage message){ mRepo.insert(message); }

    public LiveData<List<TextMessage>> getmLiveData() {
        return mLiveData;
    }
}
