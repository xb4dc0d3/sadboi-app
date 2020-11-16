package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.pojo.Story;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity.StoryActivity;

public class ShowStoryDetail extends AppCompatActivity {

    private TextView textViewStoryTitle;
    private TextView textViewStoryContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_story_detail);

        textViewStoryTitle = findViewById(R.id.textStoryTitle);
        textViewStoryContent = findViewById(R.id.textStoryContent);
        textViewStoryContent.setMovementMethod(new ScrollingMovementMethod());
        Intent intent = getIntent();

        textViewStoryTitle.setText(intent.getStringExtra(StoryActivity.title));
        textViewStoryContent.setText(intent.getStringExtra(StoryActivity.content));

    }
}