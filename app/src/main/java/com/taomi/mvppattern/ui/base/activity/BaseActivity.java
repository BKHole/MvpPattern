package com.taomi.mvppattern.ui.base.activity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.taomi.mvppattern.R;
import com.taomi.mvppattern.widget.MyToolBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.subjects.PublishSubject;

/**
 * activity基类
 * Created by LBT on 2018/5/22.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected FrameLayout mContainerLayout;
    private ProgressDialog loadingDialog = null;
    private PublishSubject mSubject;
    private Unbinder unBinder;
    protected MyToolBar mToolbar;

    @Override
    protected void onCreate(Bundle bundle) {
        if (bundle != null) {
            //如果系统回收Activity,但是系统却保留了Fragment,当Activity被重新初始化,此时,系统保存的Fragment 的getActivity为空，
            //所以要移除旧的Fragment,重新初始化新的Fragment
            String FRAGMENTS_TAG = "android:support:fragments";
            bundle.remove(FRAGMENTS_TAG);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_base);
        Intent intent = getIntent();
        if (intent != null)
            getIntent(intent);
        mToolbar = findViewById(R.id.toolbar);
        mContainerLayout = findViewById(R.id.frameLayout);
        //初始化ToolBar
        boolean isToolbar = initToolbar();
        if (isToolbar) {
            mToolbar.setLeftTitleClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNavigationClick();
                }
            });
        } else {
            mToolbar.setVisibility(View.GONE);
        }
        //初始化Content
        initContent(getLayoutId());

        unBinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unBinder.unbind();
    }

    protected void onNavigationClick() {
        finish();
    }

    protected abstract int getLayoutId();

    protected abstract boolean initToolbar();

    protected abstract void getIntent(Intent intent);

    protected abstract void initViews();

    private void initContent(int layoutId) {
        if (layoutId != 0) {
            View contentView = LayoutInflater.from(this).inflate(layoutId, mContainerLayout, false);
            mContainerLayout.addView(contentView);
            initViews();
        } else {
            throw new NullPointerException("getLayoutId() is null");
        }
    }

    /**
     * 显示带消息的进度框
     *
     * @param title 提示
     */
    protected void showLoadingDialog(String title) {
        createLoadingDialog();
        loadingDialog.setMessage(title);
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }

    /**
     * 显示进度框
     */
    protected void showLoadingDialog() {
        createLoadingDialog();
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }

    /**
     * 创建LodingDialog
     */
    private void createLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new ProgressDialog(this);
            loadingDialog.setCancelable(true);
            loadingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /**
     * 隐藏进度框
     */
    protected void hideLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

}
