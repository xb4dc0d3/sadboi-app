package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.story_sadboi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.R;

public class StoryPostFragment extends Fragment {

    // API Service initialize
    // ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

    private StoryPostViewModel storyPostViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        storyPostViewModel =
                ViewModelProviders.of(this).get(StoryPostViewModel.class);
        View root = inflater.inflate(R.layout.fragment_story_sadboi, container, false);
        final TextView textView = root.findViewById(R.id.text_story_sadboi);
        storyPostViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}