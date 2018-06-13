package com.taomi.mvppattern.network;

import android.content.Context;

import com.google.gson.Gson;
import com.taomi.mvppattern.api.ApiServer;
import com.taomi.mvppattern.utils.LogUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络工具类
 */
public class RxRetrofit {
    private Retrofit retrofit;
    private static ApiServer apiServer;

    private static final class Holder {
        private static final RxRetrofit INSTANCE = new RxRetrofit();
    }

    public void initRxRetrofit(final Context context, String baseUrl) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //链接超时
                .connectTimeout(10, TimeUnit.SECONDS)
                //读取超时
                .readTimeout(10, TimeUnit.SECONDS)
                //缓存
                .cache(new Cache(context.getExternalFilesDir("http_cache"), 10 << 20))
                //添加Cookie拦截器
                .addInterceptor(basicBodyInterceptor)
                .addInterceptor(loggingInterceptor)
                .sslSocketFactory(getSocketFactory(), x509TrustManager)
                .hostnameVerifier(hostnameVerifier)
//                .addInterceptor(new SaveCookieInterceptor())
//                .addInterceptor(new LoadCookieInterceptor())
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiServer = retrofit.create(ApiServer.class);
    }

    public static RxRetrofit getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 获取ApiServer对象
     *
     * @return apiServer
     */
    public static ApiServer Api() {
        if (apiServer == null)
            throw new IllegalStateException("You must invoke init method first in Application");
        return apiServer;
    }

    /**
     * post body公共请求参数插值器
     */
    private Interceptor basicBodyInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json;charset=UTF-8")
                    .build();
            return chain.proceed(request);
        }
    };

    /**
     * 日志打印拦截插值器
     */
    private HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            LogUtils.d(message);
        }
    }).setLevel(HttpLoggingInterceptor.Level.BODY);

    /**
     * https证书验证
     */
    private SSLSocketFactory getSocketFactory() {
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{x509TrustManager}, new java.security.SecureRandom());
            return sc.getSocketFactory();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * https证书验证
     */
    private X509TrustManager x509TrustManager = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    };

    /**
     * https证书验证
     */
    private HostnameVerifier hostnameVerifier = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };


}
