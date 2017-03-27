package com.open.lib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by wenjie.shen on 16/4/27.
 */
public class ToastUtil {
    private static final String TAG = "ToastUtil";
    private static volatile ToastUtil mToastUtil = null;
    private static Context context;
    private Toast mToast = null;

    public static void init(Context targetContext) {
        context = targetContext;
    }

    /**
     * 获取实例
     *
     * @return
     */
    public static ToastUtil getInstance() {
        if (mToastUtil == null) {
            synchronized (ToastUtil.class) {
                if (mToastUtil == null) {
                    mToastUtil = new ToastUtil();
                }
            }
        }
        return mToastUtil;
    }

    protected Handler handler = new Handler(Looper.getMainLooper());

    /**
     * 显示Toast，多次调用此函数时，Toast显示的时间不会累计，并且显示内容为最后一次调用时传入的内容
     * 持续时间默认为short
     *
     * @param tips 要显示的内容
     *             {@link Toast#LENGTH_LONG}
     */
    public void showToast(final Object tips) {
        showToast(tips, Toast.LENGTH_SHORT);
    }

    /**
     * 显示Toast，多次调用此函数时，Toast显示的时间不会累计，并且显示内容为最后一次调用时传入的内容
     *
     * @param tips     要显示的内容
     * @param duration 持续时间，参见{@link Toast#LENGTH_SHORT}和
     *                 {@link Toast#LENGTH_LONG}
     */
    public void showToast(final Object tips, final int duration) {
        String content = String.valueOf(tips);
        if (android.text.TextUtils.isEmpty(content) || "null".equals(content)) {
            return;
        }

        try{
            handler.post(new Runnable() {
                @Override
                public void run() {

                    if (mToast == null) {
                        mToast = Toast.makeText(context, content, duration);
                        mToast.show();
                    } else {
                        //mToast.cancel();
                        //mToast.setView(mToast.getView());
                        mToast.setText(content);
                        mToast.setDuration(duration);
                        mToast.show();
                    }
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
