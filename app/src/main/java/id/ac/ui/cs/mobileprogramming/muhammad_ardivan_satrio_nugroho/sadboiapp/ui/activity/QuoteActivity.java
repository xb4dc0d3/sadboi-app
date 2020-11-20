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
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.api.ApiClient;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.api.ApiInterface;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.pojo.Quote;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// TODO:
public class QuoteActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    public static final String title = "title";
    public static final String quote = "quote";
    public static final String quote_from = "quote_from";

    private ListView listView;
    private List<Quote> quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        listView = (ListView) findViewById(R.id.listViewQuote);
        getQuotes();
        listView.setOnItemClickListener(this);
    }

    private void getQuotes() {
        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data",
                "Wait for a moment..", false, false);
        // Create api service
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Quote>> call = apiService.getQuotes();
        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                loading.dismiss();
                List<Quote> quote = response.body();
                quotes = quote;
                showQuotesList();
            }
            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private void showQuotesList() {
        String[] items = new String[quotes.size()];
        for (int i = 0; i < quotes.size(); i++) {
            items[i] = quotes.get(i).getTitle();
            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview_quote, items);
            listView.setAdapter(adapter);
        }
    }
//
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pk, long id) {
        Intent intent = new Intent(this, ShowQuoteDetail.class);
        Quote qt = quotes.get(pk);
        intent.putExtra(title, qt.getTitle());
        intent.putExtra(quote, qt.getQuote());
        intent.putExtra(quote_from, qt.getQuote_from());
        Log.d("TITLE", qt.getTitle());
        startActivity(intent);
    }

}