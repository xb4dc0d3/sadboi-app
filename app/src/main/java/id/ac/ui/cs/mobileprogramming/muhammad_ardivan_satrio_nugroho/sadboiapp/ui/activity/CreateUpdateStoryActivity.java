package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.R;

public class CreateUpdateStoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_update_story);
        getSupportActionBar().setTitle("Create/Update Story");
    }

    // TODO: Click and publish story to Firebase
    public void publishStory(View view) {
    }


    // TODO: Click and save story locally
    public void saveStoryLocal(View view) {
    }
}