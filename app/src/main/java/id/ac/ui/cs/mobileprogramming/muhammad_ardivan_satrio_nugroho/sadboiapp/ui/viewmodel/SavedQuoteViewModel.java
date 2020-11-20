package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedQuote;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.repository.SavedQuoteRepository;

public class SavedQuoteViewModel extends AndroidViewModel {

    private SavedQuoteRepository mRepository;
    private LiveData<List<SavedQuote>> mAllQuotePosts;

    public SavedQuoteViewModel(@NonNull Application application) {
        super(application);
        mRepository = new SavedQuoteRepository(application);
        mAllQuotePosts = mRepository.getAllQuotePosts();
    }

    public LiveData<List<SavedQuote>>getAllQuotes() { return mAllQuotePosts; }
    public void insert(SavedQuote savedQuote) { mRepository.insert(savedQuote); }

}