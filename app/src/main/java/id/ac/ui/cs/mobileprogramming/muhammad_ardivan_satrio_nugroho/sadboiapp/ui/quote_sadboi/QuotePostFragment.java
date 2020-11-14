package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.quote_sadboi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.R;

public class QuotePostFragment extends Fragment {

    private QuotePostViewModel quotePostViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        quotePostViewModel =
                ViewModelProviders.of(this).get(QuotePostViewModel.class);
        View root = inflater.inflate(R.layout.fragment_quote_sadboi, container, false);
        final TextView textView = root.findViewById(R.id.text_quote_sadboi);
        quotePostViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        textView.setText("WELCOME");
        return root;
    }
}