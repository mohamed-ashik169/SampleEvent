package com.qinnovation.sample.helper.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by qinnovation on 12/14/17.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder> {

    private final Context mContext;
    private List<String> mData;

    public SimpleAdapter(Context context, List<String> data) {
        mContext = context;
//        if (data != null)
//            mData = new ArrayList<String>(Arrays.asList(data));
//        else mData = new ArrayList<String>();
        mData = data;
    }

    public void add(String s, int position) {
        position = position == -1 ? getItemCount() : position;
        mData.add(position, s);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        if (position < getItemCount()) {
            mData.remove(position);
            notifyItemRemoved(position);
        }
    }

    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {
        holder.title.setText(mData.get(position));
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Position =" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class SimpleViewHolder extends RecyclerView.ViewHolder {

        public final TextView title;

        public SimpleViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(android.R.id.text1);
        }

    }
}
