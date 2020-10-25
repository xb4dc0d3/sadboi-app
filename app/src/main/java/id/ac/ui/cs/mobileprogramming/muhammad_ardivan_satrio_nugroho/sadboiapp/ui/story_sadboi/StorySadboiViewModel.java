package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.story_sadboi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StorySadboiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StorySadboiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is story sadboi fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
