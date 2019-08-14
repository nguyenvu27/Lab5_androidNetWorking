package thent.kuzuki.vn.lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import thent.kuzuki.vn.lab5.adapter.EndlessRecyclerOnScrollListener;
import thent.kuzuki.vn.lab5.adapter.MessagesAdapter;
import thent.kuzuki.vn.lab5.helper.GetTimeAgo;
import thent.kuzuki.vn.lab5.network.callback.ResponseCallbackListener;
import thent.kuzuki.vn.lab5.network.manager.GetDataChatManager;
import thent.kuzuki.vn.lab5.network.model.ChatModel;
import thent.kuzuki.vn.lab5.network.response.GetDataChatResponse;

public class MainActivity extends AppCompatActivity {
    private ImageView imgBack;
    private TextView txtName;
    private TextView txtTimeOnline;
    private RecyclerView recyclerView;

    private List<ChatModel> list = new ArrayList<>();
    private MessagesAdapter messagesAdapter;
    private SwipeRefreshLayout swRefresh;
    private LinearLayoutManager linearLayoutManager;

    private int page = 1;
    private int per_page = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        swRefresh.setOnRefreshListener(() -> {
            list.clear();
            setUpAdapter();
            getDataChat(page, per_page);
        });
        setUpAdapter();
        imgBack.setOnClickListener(view -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        list.clear();
        swRefresh.setRefreshing(true);
        getDataChat(page, per_page);
    }

    private void setUpAdapter() {
        messagesAdapter = new MessagesAdapter(list);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(messagesAdapter);
        recyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getDataChat(page + 1, per_page);
            }
        });
    }

    private long formatDate(String time) throws ParseException {
        @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = formatter.parse(time);
        assert date != null;
        long output = date.getTime() / 1000L;
        String str = Long.toString(output);
        return Long.parseLong(str) * 1000;
    }

    private void getDataChat(int page, int per_page) {
        GetDataChatManager getDataChatManager = new GetDataChatManager(new ResponseCallbackListener<GetDataChatResponse>() {
            @Override
            public void onObjectComplete(String TAG, GetDataChatResponse data) {
                list.addAll(data);
                setTextTitle(data);
                setFalseOnLoadMore(data);
                swRefresh.setRefreshing(false);
                messagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onResponseFailed(String TAG, String message) {

            }
        });
        getDataChatManager.getGetDataCategories(page, per_page);
    }

    @SuppressLint("SetTextI18n")
    private void setTextTitle(GetDataChatResponse data) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAuthor() == 1) {
                txtName.setText(list.get(i).getAuthor_name());
            }
        }
        try {
            List<Long> listNew = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                try {
                    listNew.add(formatDate(data.get(i).getDate()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            Arrays.sort(new List[]{listNew});
            txtTimeOnline.setText("Last active: " + GetTimeAgo.getTimeAgo(listNew.get(0), MainActivity.this, data.get(0).getDate()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setFalseOnLoadMore(GetDataChatResponse data) {
        if (data.size() == 0) {
            recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
                @Override
                public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

                }
            });
            messagesAdapter.setOnLoadMore(false);
        }
    }

    private void initView() {
        imgBack = findViewById(R.id.imgBack);
        txtName = findViewById(R.id.txtName);
        txtTimeOnline = findViewById(R.id.txtTimeOnline);
        recyclerView = findViewById(R.id.recyclerView);
        swRefresh = findViewById(R.id.swRefresh);
    }
}
