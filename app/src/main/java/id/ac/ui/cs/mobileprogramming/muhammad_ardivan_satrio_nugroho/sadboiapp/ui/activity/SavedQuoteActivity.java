package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.R;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.adapter.SavedQuoteListAdapter;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedQuote;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.viewmodel.SavedQuoteViewModel;

public class SavedQuoteActivity extends AppCompatActivity {


    private SavedQuoteViewModel mSavedQuoteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_saved_quote);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewSavedQuote);
        final SavedQuoteListAdapter adapter = new SavedQuoteListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSavedQuoteViewModel = ViewModelProviders.of(this).get(SavedQuoteViewModel.class);
        mSavedQuoteViewModel.getAllQuotes().observe(this, new Observer<List<SavedQuote>>() {
            @Override
            public void onChanged(@Nullable final List<SavedQuote> quotes) {
                // Update the cached copy of the words in the adapter.
                adapter.setQuotes(quotes);
            }
        });
    }
}