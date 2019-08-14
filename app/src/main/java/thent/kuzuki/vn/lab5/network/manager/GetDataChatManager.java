package thent.kuzuki.vn.lab5.network.manager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thent.kuzuki.vn.lab5.network.callback.ResponseCallbackListener;
import thent.kuzuki.vn.lab5.network.response.GetDataChatResponse;

public class GetDataChatManager {

    private ResponseCallbackListener<GetDataChatResponse> mListener;
    private RestApiManager mRestApiManager = RestApiManager.getInstance();
    private static final String GET_DATA_CHAT = "GET_DATA_CHAT";

    public GetDataChatManager(ResponseCallbackListener<GetDataChatResponse> mListener) {
        this.mListener = mListener;
    }

    public void getGetDataCategories(int page, int per_page) {
        Call<GetDataChatResponse> call = mRestApiManager.getDataChatRequestCallback()
                .getDataChat(page, per_page);
        call.enqueue(new Callback<GetDataChatResponse>() {
            @Override
            public void onResponse(Call<GetDataChatResponse> call, Response<GetDataChatResponse> response) {
                if (response.isSuccessful()) {
                    mListener.onObjectComplete(GET_DATA_CHAT, response.body());
                } else {
                    mListener.onResponseFailed(GET_DATA_CHAT, response.message());
                    response.code();
                }
            }

            @Override
            public void onFailure(Call<GetDataChatResponse> call, Throwable t) {
                mListener.onResponseFailed(GET_DATA_CHAT, t.getMessage());
            }
        });
    }
}
