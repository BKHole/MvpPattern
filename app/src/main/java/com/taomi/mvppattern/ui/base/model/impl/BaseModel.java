package com.taomi.mvppattern.ui.base.model.impl;

import com.taomi.mvppattern.api.ApiServer;
import com.taomi.mvppattern.network.RxRetrofit;
import com.taomi.mvppattern.ui.base.model.IModel;

public class BaseModel implements IModel {
    @Override
    public ApiServer doRxRequest() {
        return RxRetrofit.Api();
    }
}
