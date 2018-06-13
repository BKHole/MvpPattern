package com.taomi.mvppattern.network.callback;

import com.taomi.mvppattern.bean.BaseBean;
import com.taomi.mvppattern.network.NetConfig;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public abstract class RxConsumer<T> implements Consumer<BaseBean<T>> {

    @Override
    public void accept(@NonNull BaseBean<T> tBaseBean) throws Exception {
        if (tBaseBean.errorCode == NetConfig.REQUEST_SUCCESS) {
            onSuccess(tBaseBean.data);
        } else {
            onFail(tBaseBean.errorMsg);
        }
    }

    protected abstract void onFail(String errorMsg);

    protected abstract void onSuccess(T data);
}