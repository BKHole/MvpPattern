package com.taomi.mvppattern.ui.base.model;

import com.taomi.mvppattern.api.ApiServer;

public interface IModel {
    /**
     * 使用RxRetrofit请求数据
     *
     * @return
     */
    ApiServer doRxRequest();
}
