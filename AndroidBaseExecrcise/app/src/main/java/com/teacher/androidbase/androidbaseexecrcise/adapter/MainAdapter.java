package com.teacher.androidbase.androidbaseexecrcise.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.teacher.androidbase.androidbaseexecrcise.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<String> mDatas;
    private MainViewHolder.MainOnClickListener mMainOnClickListener;
    private MainViewHolder.MainOnLongClickListener mMainOnLongClickListener;
    public MainAdapter(List<String> datas) {
        this.mDatas = datas;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false)
                                ,mMainOnClickListener, mMainOnLongClickListener);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        String title = mDatas.get(position);
        holder.mText.setText(title);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void setMainOnClickListener(MainViewHolder.MainOnClickListener onClickListener) {
        this.mMainOnClickListener = onClickListener;
    }

    public void setMainOnLongClickListener(MainViewHolder.MainOnLongClickListener onLongClickListener) {
        this.mMainOnLongClickListener = onLongClickListener;
    }
}
