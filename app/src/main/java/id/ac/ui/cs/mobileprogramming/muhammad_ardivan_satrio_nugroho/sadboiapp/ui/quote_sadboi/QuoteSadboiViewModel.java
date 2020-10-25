package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.quote_sadboi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuoteSadboiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QuoteSadboiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is quote sadboi fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
