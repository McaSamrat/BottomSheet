package com.example.bottomsheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<String> mItems;
    private ItemListener mListener;

     ItemAdapter(List<String> mItems, ItemListener mListener) {
        this.mItems = mItems;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bottom_sheet_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        holder.setData(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mTextView;
        String item;

         ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTextView = itemView.findViewById(R.id.textView);
        }

         void setData(String s) {
            this.item = s;
            mTextView.setText(s);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null){
                mListener.onItemClick(item);
            }
        }
    }

    interface ItemListener{
        void onItemClick(String item);
    }

}
