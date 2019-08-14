package thent.kuzuki.vn.lab5.adapter.holder;

import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import thent.kuzuki.vn.lab5.R;

public class LoadingViewHolder extends RecyclerView.ViewHolder {

    ProgressBar progressBar;
    public static final int LAYOUT_ID = R.layout.item_progress;

    public LoadingViewHolder(@NonNull View itemView) {
        super(itemView);
        progressBar = itemView.findViewById(R.id.pBar);
    }

    public void showLoadingView(LoadingViewHolder viewHolder, int position) {

    }
}