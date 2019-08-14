package thent.kuzuki.vn.lab5.network.callback;

public interface ResponseCallbackListener<T> {

    void onObjectComplete(String TAG, T data);

    void onResponseFailed(String TAG, String message);
}
