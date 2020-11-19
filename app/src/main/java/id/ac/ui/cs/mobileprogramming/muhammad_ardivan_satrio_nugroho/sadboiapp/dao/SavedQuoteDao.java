package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedQuote;

@Dao
public interface SavedQuoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(SavedQuote savedQuote);

    @Query("SELECT*FROM quotepost_table WHERE id = :id")
    LiveData<List<SavedQuote>> getQuoteById(int id);

    @Query("SELECT * FROM quotepost_table")
    LiveData<List<SavedQuote>> getAllQuotePosts();

}