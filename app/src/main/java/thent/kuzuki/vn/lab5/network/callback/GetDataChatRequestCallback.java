package thent.kuzuki.vn.lab5.network.callback;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import thent.kuzuki.vn.lab5.config.Config;
import thent.kuzuki.vn.lab5.network.response.GetDataChatResponse;

public interface GetDataChatRequestCallback {

    @GET(Config.GET_COMMENT)
    Call<GetDataChatResponse> getDataChat(@Query("page") int page, @Query("per_page") int per_page);
}
