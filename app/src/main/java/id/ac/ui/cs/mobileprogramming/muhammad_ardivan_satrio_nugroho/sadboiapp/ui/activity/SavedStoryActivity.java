package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.adapter.SavedStoryListAdapter;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.databinding.ContentSavedStoryBinding;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedStory;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.viewmodel.SavedStoryViewModel;

public class SavedStoryActivity extends AppCompatActivity {

    private SavedStoryViewModel mSavedStoryViewModel;
    private ContentSavedStoryBinding contentSavedStoryBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contentSavedStoryBinding = ContentSavedStoryBinding.inflate(getLayoutInflater());
        View view = contentSavedStoryBinding.getRoot();
        setContentView(view);

        RecyclerView recyclerView = contentSavedStoryBinding.recyclerViewSavedStory;
        final SavedStoryListAdapter adapter = new SavedStoryListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSavedStoryViewModel = ViewModelProviders.of(this).get(SavedStoryViewModel.class);
        mSavedStoryViewModel.getAllStories().observe(this, new Observer<List<SavedStory>>() {
            @Override
            public void onChanged(@Nullable final List<SavedStory> stories) {
                // Update the cached copy of the words in the adapter.
                adapter.setStories(stories);
            }
        });
    }
}