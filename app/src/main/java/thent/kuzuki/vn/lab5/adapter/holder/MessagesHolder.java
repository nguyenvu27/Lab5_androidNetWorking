package thent.kuzuki.vn.lab5.adapter.holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import thent.kuzuki.vn.lab5.R;
import thent.kuzuki.vn.lab5.helper.GetTimeAgo;
import thent.kuzuki.vn.lab5.network.model.ChatModel;

public class MessagesHolder extends RecyclerView.ViewHolder {
    private TextView txtTime;
    private TextView textChat;
    private CircleImageView imageUser;
    @SuppressLint("SimpleDateFormat")
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    Date date;
    private Context context;

    public MessagesHolder(@NonNull View itemView) {
        super(itemView);
        txtTime = itemView.findViewById(R.id.txtTime);
        textChat = itemView.findViewById(R.id.text_chat);
        imageUser = itemView.findViewById(R.id.image_user);
        context = itemView.getContext();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setupData(List<ChatModel> list, ChatModel categoryModel, int position) {
        String name = categoryModel.getContent().getRendered().replace("<p>", "");
        String name1 = name.replace("</p>", "");
        String name2 = name1.replace("\n", "");
        String name3 = name2.replace("<br />", "");
        textChat.setText(name3);
        Glide.with(context).load(categoryModel.getAuthor_avatar_urls().get_$48()).into(imageUser);
        try {
            if (position != 0 && list.get(position - 1).getAuthor() == list.get(position).getAuthor()) {
                txtTime.setVisibility(View.GONE);
            } else {
                txtTime.setText(GetTimeAgo.getTimeAgo(formatDate(categoryModel.getDate()),
                        context, parseDateFormatString(categoryModel.getDate())));
                txtTime.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String parseDateFormatString(String strDate) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            Date date = format.parse(strDate);
            SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm dd-MM-yyyy ", Locale.US);
            return dateformat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    private long formatDate(String time) throws ParseException {
        date = formatter.parse(time);
        long output = date.getTime() / 1000L;
        String str = Long.toString(output);
        long timestamp = Long.parseLong(str) * 1000;
        return timestamp;
    }
}
