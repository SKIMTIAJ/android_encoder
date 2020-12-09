package com.imtiaj.recyclerview_pro.adaptor;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imtiaj.recyclerview_pro.R;
import com.imtiaj.recyclerview_pro.model.ChildItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChildItemAdapter extends RecyclerView.Adapter<ChildItemAdapter.ChildViewHolder> {

    private List<ChildItem> ChildItemList;

    public ChildItemAdapter(List<ChildItem> childItemList) {
        ChildItemList = childItemList;
    }

    @NonNull
    @Override
    public ChildItemAdapter.ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Here we inflate the corresponding
        // layout of the child item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildItemAdapter.ChildViewHolder holder, int position) {

        ChildItem childItem = ChildItemList.get(position);
        ((ChildViewHolder)holder).ChildItemTitle.setText(childItem.getChildItemTitle());

    }

    @Override
    public int getItemCount() {
        return ChildItemList.size();
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {
        TextView ChildItemTitle;
        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            ChildItemTitle = (TextView) itemView.findViewById(R.id.child_item_title);
        }
    }
}
