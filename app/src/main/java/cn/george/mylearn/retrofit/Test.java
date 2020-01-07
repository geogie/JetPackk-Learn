package cn.george.mylearn.retrofit;

import android.util.Log;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created By George
 * Description:
 */
public class Test {
    private static final String TAG = "Test-";
    private static Retrofit mRetrofit;

    private static void initHttpBase() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("host")
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .build();
    }

    public static void test() {
        initHttpBase();
        TestParam param = mRetrofit.create(TestParam.class);
        Call<Bean> call = param.test("name", "password", "test");
        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean bean = response.body();
                assert bean != null;
                Log.d(TAG, "onResponse:" + bean.toString());
                String json = "{\"status\":1001,\"error\":\"no error\"}";
                Bean json2 = JsonUtils.parseDataToObject(json, Bean.class);
                if (json2 != null) {
                    Log.d(TAG, "onResponse-json2:" + json2.toString());
                }
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                Log.d(TAG, "onFailure");
            }
        });

    }

    public interface TestParam {
        @GET("url")
        Call<Bean> test(@Query("username") String username, @Query("password") String password, @Query("device") String device);
    }

    static class Bean {

        public int status;
        public String error;
        public Object data;

        @Override
        public String toString() {
            return "Bean{" +
                    "status=" + status +
                    ", error='" + error + '\'' +
                    ", data=" + data +
                    '}';
        }
    }

}
