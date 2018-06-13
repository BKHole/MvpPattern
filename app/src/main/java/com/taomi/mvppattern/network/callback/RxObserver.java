package com.taomi.mvppattern.network.callback;

import com.taomi.mvppattern.bean.BaseBean;
import com.taomi.mvppattern.network.NetConfig;
import com.taomi.mvppattern.ui.base.presenter.BasePresenter;

/**
 * 通用Observer回调
 */

public abstract class RxObserver<T> extends RxBaseObserver<T> {
    public RxObserver(BasePresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public void onNext(BaseBean<T> mBaseBean) {

        //请求成功
        if (mBaseBean.errorCode == NetConfig.REQUEST_SUCCESS) {
            onSuccess(mBaseBean.data);
        } else {
            //失败
            onFail(mBaseBean.errorCode, mBaseBean.errorMsg);
        }
    }

    protected abstract void onSuccess(T data);

    protected abstract void onFail(int errorCode, String errorMsg);

}
