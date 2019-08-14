package thent.kuzuki.vn.lab5.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import thent.kuzuki.vn.lab5.R;
import thent.kuzuki.vn.lab5.adapter.holder.LoadingViewHolder;
import thent.kuzuki.vn.lab5.adapter.holder.MessagesHolder;
import thent.kuzuki.vn.lab5.network.model.ChatModel;

public class MessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ChatModel> list;
    private static final int MES_TYPE_LEFT = 0;
    private static final int MES_TYPE_RIGHT = 1;
    private final int VIEW_TYPE_LOADING = 11;
    private boolean onLoadMore = true;

    public MessagesAdapter(List<ChatModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MES_TYPE_RIGHT) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_text_right, parent, false);
            return new MessagesHolder(itemView);
        } else if (viewType == MES_TYPE_LEFT) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_text_left, parent, false);
            return new MessagesHolder(itemView);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(parent.getContext()).inflate(LoadingViewHolder.LAYOUT_ID, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    public boolean isOnLoadMore() {
        return onLoadMore;
    }

    public void setOnLoadMore(boolean onLoadMore) {
        this.onLoadMore = onLoadMore;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MessagesHolder) {
            final ChatModel chatModel = list.get(position);
            ((MessagesHolder) holder).setupData(list,chatModel, position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int getItemViewType(int position) {
        if (onLoadMore) {
            if (position == list.size() - 1) {
                return VIEW_TYPE_LOADING;
            } else {
                if (list.get(position).getAuthor() != 1) {
                    return MES_TYPE_RIGHT;
                } else {
                    return MES_TYPE_LEFT;
                }
            }
        } else {
            if (list.get(position).getAuthor() != 1) {
                return MES_TYPE_RIGHT;
            } else {
                return MES_TYPE_LEFT;
            }
        }
    }
}
