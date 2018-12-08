package com.example.dnd.softwareengineeringdnd;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

public class TextMessageRepo {

        private TextMessageDao mTextDao;
        private LiveData<List<TextMessage>> mTextLive;

        TextMessageRepo(Application myApp){
            TextMessageDatabase db = TextMessageDatabase.getDatabase(myApp);
            mTextDao = db.Dao();
        }

        public LiveData<List<TextMessage>> getUserMessages(){
            return mTextDao.getLiveMessages();
        }

        public void insert(TextMessage message){
            new insertAsyncTask(mTextDao).execute(message);
        }

    private static class insertAsyncTask extends AsyncTask<TextMessage, Void, Void> {

        private TextMessageDao mAsyncTaskDao;

        insertAsyncTask(TextMessageDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final TextMessage... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
