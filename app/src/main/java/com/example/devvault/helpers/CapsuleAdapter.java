package com.example.devvault.helpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.devvault.R;
import com.example.devvault.data.Capsule;

import java.util.List;

public class CapsuleAdapter extends RecyclerView.Adapter<CapsuleAdapter.ViewHolder> {

    private List<Capsule> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleText;
        private final TextView typeText;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            // textView = (TextView) view.findViewById(R.id.textView);
            titleText = view.findViewById(R.id.titleTextView);
            typeText = view.findViewById(R.id.typeTextView);
        }

        public TextView getTitleText() {
            return titleText;
        }

        public TextView getTypeText() {
            return typeText;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public CapsuleAdapter(List<Capsule> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout_capsule, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        // viewHolder.getTextView().setText(localDataSet[position]);
        Capsule capsule = localDataSet.get(position);
        viewHolder.getTitleText().setText(capsule.getTitle());
        viewHolder.getTypeText().setText(capsule.getType());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}