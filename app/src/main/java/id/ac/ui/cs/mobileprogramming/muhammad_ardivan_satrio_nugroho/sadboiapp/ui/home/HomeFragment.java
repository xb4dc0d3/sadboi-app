package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.R;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity.QuoteActivity;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity.SavedStoryActivity;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.ui.activity.StoryActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        root.findViewById(R.id.button_story_activity).setOnClickListener(mListener);
        root.findViewById(R.id.button_quote_activity).setOnClickListener(mListener);
        root.findViewById(R.id.button_draft_story_activity).setOnClickListener(mListener);
        return root;
    }

    private final View.OnClickListener mListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_story_activity:
                    Intent intent = new Intent(getActivity(), StoryActivity.class);
                    startActivity(intent);
                    break;
                case R.id.button_quote_activity:
                    Intent intent2 = new Intent(getActivity(), QuoteActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.button_draft_story_activity:
                    Intent intent3 = new Intent(getActivity(), SavedStoryActivity.class);
                    startActivity(intent3);
                    break;
            }
        }
    };

}
