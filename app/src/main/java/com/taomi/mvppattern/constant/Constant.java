package com.taomi.mvppattern.constant;

/**
 * App 常量类
 */

public class Constant {

    //用户相关
    public static class USERINFO_KEY {
        public static final String USER_INFO = "mUserInfo";  //用户信息
        public static final String IS_LOGIN = "mIsLogin";    //登录状态
        public static final String AES = "mAES";//用户信息密钥
    }

    //事件Action
    public static class EVENT_ACTION {
        public static final String REFRESH_DATA = "refresh_list_item";
    }

    //Intent传值
    public static class BUNDLE_KEY {
        public static final String ID = "_id";
        public static final String TITLE = "title";
        public static final String URL = "url";
        public static final String OBJ = "obj";
        public static final String CHAPTER_ID = "chapter_id";
        public static final String CHAPTER_NAME = "chapter_name";
        public static final String INTENT_ACTION_TYPE = "intent_action_type";
        public static final String COLLECT_TYPE = "collect_type";//1收藏列表文章 2收藏站内文章
        public static final int INTENT_ACTION_TREE = 1;
        public static final int INTENT_ACTION_LIST = 2;
    }


    //图片加载
    public static class IMAGE_LOADER {
        public static final int HEAD_IMG = 0;
        public static final int NORMAL_IMG = 1;
    }
}
