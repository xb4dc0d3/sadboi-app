package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedStory;

@Dao
public interface SavedStoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(SavedStory savedStory);

    @Query("SELECT*FROM storypost_table WHERE id = :id")
    LiveData<List<SavedStory>> getStoryById(int id);

    @Query("SELECT * FROM storypost_table")
    LiveData<List<SavedStory>> getAllStoryPosts();

}
