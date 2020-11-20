package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.R;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedQuote;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedStory;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.viewmodel.SavedQuoteViewModel;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.viewmodel.SavedStoryViewModel;

public class ShowQuoteDetail extends AppCompatActivity {

    private TextView textViewQuoteTitle;
    private TextView textViewQuote;
    private TextView textViewQuoteFrom;

    private static String title = "";
    private static String quote = "";
    private static String quote_from = "";

    private SavedQuoteViewModel mSavedQuoteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_quote_detail);

        textViewQuoteTitle = findViewById(R.id.textQuoteTitle);
        textViewQuote = findViewById(R.id.textQuote);
        textViewQuoteFrom = findViewById(R.id.textQuoteFrom);

        Intent intent = getIntent();
        title = intent.getStringExtra(QuoteActivity.title);
        quote = intent.getStringExtra(QuoteActivity.quote);
        quote_from = intent.getStringExtra(QuoteActivity.quote_from);
        textViewQuoteTitle.setText(title);
        textViewQuote.setText(quote);
        textViewQuoteFrom.setText(quote_from);

        mSavedQuoteViewModel = ViewModelProviders.of(this).get(SavedQuoteViewModel.class);
    }

    public void shareQuote(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TITLE, title);
        sendIntent.putExtra(Intent.EXTRA_TEXT, quote);
        sendIntent.putExtra(Intent.EXTRA_TEXT, quote_from);
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

    public void saveQuote(View view) {

        try {
            SavedQuote savedQuote = new SavedQuote(title, quote, quote_from);
            mSavedQuoteViewModel.insert(savedQuote);
        } catch (Exception e) {
            Toast.makeText(
                    getApplicationContext(),
                    "Something's wrong",
                    Toast.LENGTH_LONG).show();
            Log.d("ERROR", "exception", e);
        }

        Intent intent = new Intent(this, SavedQuoteActivity.class);
        startActivity(intent);
    }
}