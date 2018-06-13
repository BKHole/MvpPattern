package com.taomi.mvppattern.api;

import com.taomi.mvppattern.bean.BaseBean;
import com.taomi.mvppattern.bean.UserBean;
import com.taomi.mvppattern.constant.UrlContainer;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 接口管理
 */
public interface ApiServer {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @FormUrlEncoded
    @POST(UrlContainer.LOGIN)
    Observable<BaseBean<UserBean>> login(@Field("username") String username, @Field("password") String password);

    /**
     * 更新版本
     *
     * @param body
     * @return
     */
    @POST("version/update")
    Observable<BaseBean<UserBean>> updateVersion(@Body RequestBody body);
}
