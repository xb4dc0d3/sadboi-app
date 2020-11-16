package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.R;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ShowStoryDetail;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.api.ApiClient;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.api.ApiInterface;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.pojo.Story;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//TODO: Implement StoryActivity RecyclerView
public class StoryActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    public static final String PK = "pk";
    public static final String title = "title";
    public static final String content = "content";
    public static final String created_at = "created_at";

    private ListView listView;
    private List<Story> stories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        listView = (ListView) findViewById(R.id.listViewStory);
        getStories();
        listView.setOnItemClickListener(this);

    }


    private void getStories() {
        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data",
                "Wait for a moment..", false, false);
        // Create api service
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Story>> call = apiService.getStories();
        call.enqueue(new Callback<List<Story>>() {
            @Override
            public void onResponse(Call<List<Story>> call, Response<List<Story>> response) {
                loading.dismiss();
                List<Story> story = response.body();
                stories = story;
                showStoriesList();
            }
            @Override
            public void onFailure(Call<List<Story>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showStoriesList() {
        String[] items = new String[stories.size()];
        for (int i = 0; i < stories.size(); i++) {
            items[i] = stories.get(i).getTitle();
            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview_story, items);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pk, long id) {
            Intent intent = new Intent(this, ShowStoryDetail.class);
            Story story = stories.get(pk);
            intent.putExtra(title, story.getTitle());
            intent.putExtra(content, story.getContent());
            startActivity(intent);
    }
}