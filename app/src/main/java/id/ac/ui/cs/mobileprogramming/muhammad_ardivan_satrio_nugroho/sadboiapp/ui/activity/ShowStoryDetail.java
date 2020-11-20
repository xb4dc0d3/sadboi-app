package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.databinding.ActivityShowStoryDetailBinding;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedStory;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.viewmodel.SavedStoryViewModel;

public class ShowStoryDetail extends AppCompatActivity {

    private TextView textViewStoryTitle;
    private TextView textViewStoryContent;

    private static String title = "";
    private static String content = "";

    private SavedStoryViewModel mSavedStoryViewModel;

    private ActivityShowStoryDetailBinding activityShowStoryDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityShowStoryDetailBinding = ActivityShowStoryDetailBinding.inflate(getLayoutInflater());
        View view = activityShowStoryDetailBinding.getRoot();
        setContentView(view);

        textViewStoryTitle = activityShowStoryDetailBinding.textStoryTitle;
        textViewStoryContent = activityShowStoryDetailBinding.textStoryContent;
        textViewStoryContent.setMovementMethod(new ScrollingMovementMethod());
        Intent intent = getIntent();

        title = intent.getStringExtra(StoryActivity.title);
        content = intent.getStringExtra(StoryActivity.content);
        textViewStoryTitle.setText(title);
        textViewStoryContent.setText(content);


        mSavedStoryViewModel = ViewModelProviders.of(this).get(SavedStoryViewModel.class);
    }

    public void shareStory(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TITLE, title);
        sendIntent.putExtra(Intent.EXTRA_TEXT, content);
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

    public void saveStory(View view) {

        try {
            SavedStory savedStory = new SavedStory(title, content);
            Log.d("WHATTT", savedStory.toString());
            Log.d("Title ", savedStory.getTitle());
            Log.d("Content", savedStory.getContent());
            mSavedStoryViewModel.insert(savedStory);
        } catch (Exception e) {
            Toast.makeText(
                    getApplicationContext(),
                    "Something's wrong",
                    Toast.LENGTH_LONG).show();
            Log.d("ERROR", "exception", e);
        }

        Intent intent = new Intent(this, SavedStoryActivity.class);
        startActivity(intent);
    }
}