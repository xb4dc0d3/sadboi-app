package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.draft_story_sadboi;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.StoryPost;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.repository.DraftStoryPostRepository;

public class DraftStoryPostViewModel extends AndroidViewModel {

    private DraftStoryPostRepository mRepository;

    private LiveData<List<StoryPost>> mAllStoryPosts;

    public DraftStoryPostViewModel(Application application){
        super(application);
        mRepository = new DraftStoryPostRepository(application);
        mAllStoryPosts = mRepository.getAllStoryPosts();
    }

    LiveData<List<StoryPost>>getAllWords() { return mAllStoryPosts; }
    public void insert(StoryPost storyPost) { mRepository.insert(storyPost); }

}
