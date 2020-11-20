package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.databinding.ActivityShowQuoteDetailBinding;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedQuote;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.viewmodel.SavedQuoteViewModel;

public class ShowQuoteDetail extends AppCompatActivity {

    private TextView textViewQuoteTitle;
    private TextView textViewQuote;
    private TextView textViewQuoteFrom;

    private static String title = "";
    private static String quote = "";
    private static String quote_from = "";

    private SavedQuoteViewModel mSavedQuoteViewModel;

    private ActivityShowQuoteDetailBinding activityShowQuoteDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityShowQuoteDetailBinding = ActivityShowQuoteDetailBinding.inflate(getLayoutInflater());
        View view = activityShowQuoteDetailBinding.getRoot();
        setContentView(view);

        textViewQuoteTitle = activityShowQuoteDetailBinding.textQuoteTitle;
        textViewQuote = activityShowQuoteDetailBinding.textQuote;
        textViewQuoteFrom = activityShowQuoteDetailBinding.textQuoteFrom;

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