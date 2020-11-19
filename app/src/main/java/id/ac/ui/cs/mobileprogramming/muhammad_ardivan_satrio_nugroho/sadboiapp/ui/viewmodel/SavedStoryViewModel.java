package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.saved_story_sadboi;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedStory;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.repository.SavedStoryRepository;

public class SavedStoryViewModel extends AndroidViewModel {

    private SavedStoryRepository mRepository;
    private LiveData<List<SavedStory>> mAllStoryPosts;

    public SavedStoryViewModel(Application application){
        super(application);
        mRepository = new SavedStoryRepository(application);
        mAllStoryPosts = mRepository.getAllStoryPosts();
    }

    public LiveData<List<SavedStory>>getAllStories() { return mAllStoryPosts; }
    public void insert(SavedStory savedStory) { mRepository.insert(savedStory); }

}
