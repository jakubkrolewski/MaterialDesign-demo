package com.allegrogroup.demo.material.recyclerview;

import android.support.v7.widget.RecyclerView;

public interface RecyclerViewItemClickListener<T extends RecyclerView.ViewHolder> {
	void onItemClick(int position, T viewHolder, long itemId);
}
