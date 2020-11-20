package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.R;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedQuote;

public class SavedQuoteListAdapter extends RecyclerView.Adapter<SavedQuoteListAdapter.QuoteViewHolder> {

    private final LayoutInflater mInflater;
    private List<SavedQuote> mQuotes; // Cached copy of quotes

    public SavedQuoteListAdapter(Context context) { mInflater = LayoutInflater.from(context); }


    @NonNull
    @Override
    public SavedQuoteListAdapter.QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item_saved_quote, parent, false);
        return new QuoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {

        if (mQuotes != null){
            SavedQuote current = mQuotes.get(position);
            holder.quoteItemView.setText(current.getTitle());
        }
        else{
            holder.quoteItemView.setText(R.string.no_quote_text);
        }
    }


    public void setQuotes(List<SavedQuote> quotes) {
        mQuotes = quotes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        if(mQuotes != null){
            return mQuotes.size();
        }
        else return 0;
    }


    public class QuoteViewHolder extends RecyclerView.ViewHolder {

        private final TextView quoteItemView;

        public QuoteViewHolder(View itemView) {
            super(itemView);
            quoteItemView = itemView.findViewById(R.id.savedQuoteTitleTextView);
        }
    }
}
