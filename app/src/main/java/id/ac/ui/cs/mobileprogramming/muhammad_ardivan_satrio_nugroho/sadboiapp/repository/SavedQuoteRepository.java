package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.dao.SavedQuoteDao;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.database.AppDatabase;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedQuote;

public class SavedQuoteRepository{

    private SavedQuoteDao mSavedQuoteDao;
    private LiveData<List<SavedQuote>> mAllQuotePosts;

    public SavedQuoteRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mSavedQuoteDao = db.savedQuoteDao();
        mAllQuotePosts = mSavedQuoteDao.getAllQuotePosts();
    }

    public LiveData<List<SavedQuote>> getAllQuotePosts() {
        return mAllQuotePosts;
    }

    public void insert(SavedQuote savedQuote) {
        new insertAsyncTask(mSavedQuoteDao).execute(savedQuote);
    }

    private static class insertAsyncTask extends AsyncTask<SavedQuote, Void, Void> {
        private SavedQuoteDao mAsyncTaskDao;

        insertAsyncTask(SavedQuoteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final SavedQuote... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}