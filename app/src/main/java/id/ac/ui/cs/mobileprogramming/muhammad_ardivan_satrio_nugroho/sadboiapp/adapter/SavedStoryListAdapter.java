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
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.SavedStory;

public class SavedStoryListAdapter extends RecyclerView.Adapter<SavedStoryListAdapter.StoryViewHolder> {

    private final LayoutInflater mInflater;
    private List<SavedStory> mStories; // Cached copy of words

    public SavedStoryListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item_saved_story, parent, false);
        return new StoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {

        if (mStories != null){
            SavedStory current = mStories.get(position);
            holder.storyItemView.setText(current.getTitle());
        }
        else{
            holder.storyItemView.setText(R.string.no_story_text);
        }

    }

    public void setStories(List<SavedStory> stories){
        mStories = stories;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        if(mStories != null){
            return mStories.size();
        }
        else return 0;
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder {

        private final TextView storyItemView;

        public StoryViewHolder(View itemView) {
            super(itemView);
            storyItemView = itemView.findViewById(R.id.savedStoryTitleTextView);
        }
    }
}
