package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.R;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.api.ApiClient;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.api.ApiInterface;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);




        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        
    }
}