package com.taomi.mvppattern.network.callback;

import com.taomi.mvppattern.bean.BaseBean;
import com.taomi.mvppattern.network.NetConfig;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * 用来处理嵌套请求的操作
 */

public abstract class RxFunction<T, R> implements Function<BaseBean<T>, Observable<BaseBean<R>>> {

    @Override
    public Observable<BaseBean<R>> apply(BaseBean<T> tBaseBean) throws Exception {
        if (tBaseBean.errorCode == NetConfig.REQUEST_SUCCESS) {
            return doOnNextRequest();
        }
        return null;
    }

    protected abstract Observable<BaseBean<R>> doOnNextRequest();

}
