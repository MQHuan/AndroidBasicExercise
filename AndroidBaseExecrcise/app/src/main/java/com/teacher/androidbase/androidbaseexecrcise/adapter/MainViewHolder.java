package com.teacher.androidbase.androidbaseexecrcise.adapter;

/**
 * Created by Administrator on 2016/6/11.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.teacher.androidbase.androidbaseexecrcise.R;

public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public TextView mText;
    public MainOnClickListener mMainOnClickListener;
    public MainOnLongClickListener mMainOnLongClickListener;

    public MainViewHolder(View itemView, MainOnClickListener mainOnClickListener, MainOnLongClickListener mainOnLongClickListener) {
        super(itemView);
        mText = (TextView) itemView.findViewById(R.id.main_title);
        this.mMainOnClickListener = mainOnClickListener;
        this.mMainOnLongClickListener = mainOnLongClickListener;
    }

    @Override
    public void onClick(View v) {
        if (v != null) {
            mMainOnClickListener.onItemClick(v, getLayoutPosition());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v != null) {
            mMainOnLongClickListener.onItemLongClick(v, getLayoutPosition());
        }
        return false;
    }

    public interface MainOnClickListener {
        void onItemClick(View view, int position);
    }

    public interface MainOnLongClickListener {
        void onItemLongClick(View view, int position);
    }
}


