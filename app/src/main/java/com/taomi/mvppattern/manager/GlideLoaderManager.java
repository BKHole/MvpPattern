package com.taomi.mvppattern.manager;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.taomi.mvppattern.R;
import com.taomi.mvppattern.application.AppContext;
import com.taomi.mvppattern.constant.Constant;

/**
 * Glide图片加载
 */

public class GlideLoaderManager {
    private static RequestOptions normal_image_options = RequestOptions.placeholderOf(R.mipmap.ic_launcher)
            .centerCrop();
    private static RequestOptions head_options = RequestOptions.placeholderOf(R.mipmap.ic_launcher);

    public static void loadImage(String url, final ImageView imageView, int type) {

        switch (type) {
            case Constant.IMAGE_LOADER.HEAD_IMG:
                Glide.with(AppContext.getContext()).load(url).apply(head_options).into(imageView);
                break;
            case Constant.IMAGE_LOADER.NORMAL_IMG:
                Glide.with(AppContext.getContext()).load(url).apply(normal_image_options).into(imageView);
                break;
            default:
                break;
        }

    }

}
