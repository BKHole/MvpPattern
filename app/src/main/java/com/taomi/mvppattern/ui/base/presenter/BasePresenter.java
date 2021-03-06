package com.taomi.mvppattern.ui.base.presenter;

import com.taomi.mvppattern.ui.base.view.IView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IView> implements IPresenter<V> {
    private V view;
    //用来存放Disposable的容器
    private CompositeDisposable mCompositeDisposable;

    //绑定View
    @Override
    public void attachView(V view) {
        this.view = view;
    }

    //解除View绑定
    @Override
    public void detachView() {
        this.view = null;
    }

    //获取绑定的View
    @Override
    public V getView() {
        checkAttachView();
        return view;
    }

    //检查View是否存在
    @Override
    public void checkAttachView() {
        if (view == null)
            throw new RuntimeException("You have no binding this view");
    }

    //添加指定的请求
    @Override
    public void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null)
            mCompositeDisposable = new CompositeDisposable();
        mCompositeDisposable.add(disposable);
    }

    //移除指定的请求
    @Override
    public void removeDisposable(Disposable disposable) {
        if (mCompositeDisposable != null)
            mCompositeDisposable.remove(disposable);
    }

    //取消所有的请求Tag
    @Override
    public void removeAllDisposable() {
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }

}
