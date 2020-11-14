package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.StoryPost;

@Dao
public interface StoryPostDao {

    @Insert
    void insert(StoryPost storyPost);

    @Query("SELECT*FROM storypost WHERE id = :id")
    LiveData<List<StoryPost>> getStoryById(int id);

    @Query("SELECT * FROM storypost")
    LiveData<List<StoryPost>> getAllStoryPosts();

}
