package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.dao.StoryPostDao;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.database.AppDatabase;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.StoryPost;

public class DraftStoryPostRepository {

    private StoryPostDao mStoryPostDao;
    private LiveData<List<StoryPost>> mAllStoryPosts;

    public DraftStoryPostRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mStoryPostDao = db.storyPostDao();
        mAllStoryPosts = mStoryPostDao.getAllStoryPosts();
    }

    public LiveData<List<StoryPost>> getAllStoryPosts() {
        return mAllStoryPosts;
    }

    // Insert StoryPost object using AsyncTask
    public void insert(StoryPost storyPost) {
        new insertAsyncTask(mStoryPostDao).execute(storyPost);
    }

    private static class insertAsyncTask extends AsyncTask<StoryPost, Void, Void> {
        private StoryPostDao mAsyncTaskDao;

        insertAsyncTask(StoryPostDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final StoryPost... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
