package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.pojo.Story;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity.StoryActivity;

public class ShowStoryDetail extends AppCompatActivity {

    private TextView textViewStoryTitle;
    private TextView textViewStoryContent;

    private static String title = "";
    private static String content = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_story_detail);

        textViewStoryTitle = findViewById(R.id.textStoryTitle);
        textViewStoryContent = findViewById(R.id.textStoryContent);
        textViewStoryContent.setMovementMethod(new ScrollingMovementMethod());
        Intent intent = getIntent();

        title = intent.getStringExtra(StoryActivity.title);
        content = intent.getStringExtra(StoryActivity.content);
        textViewStoryTitle.setText(title);
        textViewStoryContent.setText(content);
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
}