package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.dao.SavedStoryDao;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.database.AppDatabase;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedStory;

public class SavedStoryRepository {

    private SavedStoryDao mSavedStoryDao;
    private LiveData<List<SavedStory>> mAllStoryPosts;

    public SavedStoryRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mSavedStoryDao = db.savedStoryDao();
        mAllStoryPosts = mSavedStoryDao.getAllStoryPosts();
    }

    public LiveData<List<SavedStory>> getAllStoryPosts() {
        return mAllStoryPosts;
    }
    // Insert SavedStory object using AsyncTask
    public void insert(SavedStory savedStory) {
        new insertAsyncTask(mSavedStoryDao).execute(savedStory);
    }

    private static class insertAsyncTask extends AsyncTask<SavedStory, Void, Void> {
        private SavedStoryDao mAsyncTaskDao;

        insertAsyncTask(SavedStoryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final SavedStory... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
