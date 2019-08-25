package com.blued.android.module.serviceloader.common;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;


import com.blued.android.module.serviceloader.components.ActivityLauncher;
import com.blued.android.module.serviceloader.components.UriSourceTools;
import com.blued.android.module.serviceloader.core.OnCompleteListener;
import com.blued.android.module.serviceloader.core.UriRequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * UriRequest的默认封装子类，增加了常用参数的辅助方法，方便使用
 * <p>
 * Created by jzj on 2018/3/27.
 */

public class DefaultUriRequest extends UriRequest {

    public DefaultUriRequest(@NonNull Context context, @NonNull Uri uri) {
        super(context, uri);
    }

    public DefaultUriRequest(@NonNull Context context, @NonNull String uri) {
        super(context, uri);
    }

    public DefaultUriRequest(@NonNull Context context, @NonNull String uri,
                             HashMap<String, Object> extra) {
        super(context, uri, extra);
    }

    @Override
    public DefaultUriRequest onComplete(OnCompleteListener listener) {
        return (DefaultUriRequest) super.onComplete(listener);
    }

    @Override
    public DefaultUriRequest setErrorMessage(String message) {
        return (DefaultUriRequest) super.setErrorMessage(message);
    }

    @Override
    public DefaultUriRequest setResultCode(int resultCode) {
        return (DefaultUriRequest) super.setResultCode(resultCode);
    }

    @Override
    public DefaultUriRequest skipInterceptors() {
        return (DefaultUriRequest) super.skipInterceptors();
    }



    /**
     * 设置跳转来源
     *
     * @see UriSourceTools
     */
    public DefaultUriRequest from(int from) {
        putField(UriSourceTools.FIELD_FROM, from);
        return this;
    }

    /**
     * 用于startActivityForResult的requestCode
     *
     * @see android.app.Activity#startActivityForResult(Intent, int)
     */
    public DefaultUriRequest activityRequestCode(int requestCode) {
        putField(ActivityLauncher.FIELD_REQUEST_CODE, requestCode);
        return this;
    }

    /**
     * 设置Activity切换动画
     *
     * @see android.app.Activity#overridePendingTransition(int, int)
     */
    public DefaultUriRequest overridePendingTransition(int enterAnim, int exitAnim) {
        putField(ActivityLauncher.FIELD_START_ACTIVITY_ANIMATION,
                new int[]{enterAnim, exitAnim});
        return this;
    }


    /**
     * 设置Intent的Flags
     *
     * @see Intent#setFlags(int)
     */
    public DefaultUriRequest setIntentFlags(int flags) {
        putField(ActivityLauncher.FIELD_START_ACTIVITY_FLAGS, flags);
        return this;
    }

    /**
     * 设置ActivityOptionsCompat
     *
     * @see ActivityOptions
     * @see ActivityOptionsCompat
     */
    @RequiresApi(16)
    public DefaultUriRequest setActivityOptionsCompat(ActivityOptionsCompat options) {
        if (options != null) {
            putField(ActivityLauncher.FIELD_START_ACTIVITY_OPTIONS, options.toBundle());
        }
        return this;
    }

    /**
     * 是否限制Intent的packageName，限制后只会启动当前APP的页面，不启动外部页面，bool型
     *
     * @see ActivityLauncher#FIELD_LIMIT_PACKAGE
     */
    public DefaultUriRequest limitPackage(boolean limit) {
        putField(ActivityLauncher.FIELD_LIMIT_PACKAGE, limit);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, boolean value) {
        extra().putBoolean(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, byte value) {
        extra().putByte(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, char value) {
        extra().putChar(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, short value) {
        extra().putShort(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, int value) {
        extra().putInt(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, long value) {
        extra().putLong(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, float value) {
        extra().putFloat(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, double value) {
        extra().putDouble(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, String value) {
        extra().putString(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, CharSequence value) {
        extra().putCharSequence(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, Parcelable value) {
        extra().putParcelable(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, Parcelable[] value) {
        extra().putParcelableArray(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putIntentParcelableArrayListExtra(String name,
                                                               ArrayList<? extends Parcelable> value) {
        extra().putParcelableArrayList(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putIntentIntegerArrayListExtra(String name, ArrayList<Integer> value) {
        extra().putIntegerArrayList(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putIntentStringArrayListExtra(String name, ArrayList<String> value) {
        extra().putStringArrayList(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putIntentCharSequenceArrayListExtra(String name,
                                                                 ArrayList<CharSequence> value) {
        extra().putCharSequenceArrayList(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, Serializable value) {
        extra().putSerializable(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, boolean[] value) {
        extra().putBooleanArray(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, byte[] value) {
        extra().putByteArray(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, short[] value) {
        extra().putShortArray(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, char[] value) {
        extra().putCharArray(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, int[] value) {
        extra().putIntArray(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, long[] value) {
        extra().putLongArray(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, float[] value) {
        extra().putFloatArray(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, double[] value) {
        extra().putDoubleArray(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, String[] value) {
        extra().putStringArray(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, CharSequence[] value) {
        extra().putCharSequenceArray(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtra(String name, Bundle value) {
        extra().putBundle(name, value);
        return this;
    }

    /**
     * 附加到Intent的Extra
     */
    public DefaultUriRequest putExtras(Bundle extras) {
        if (extras != null) {
            extra().putAll(extras);
        }
        return this;
    }

    @NonNull
    private synchronized Bundle extra() {
        Bundle extra = getField(Bundle.class, ActivityLauncher.FIELD_INTENT_EXTRA, null);
        if (extra == null) {
            extra = new Bundle();
            putField(ActivityLauncher.FIELD_INTENT_EXTRA, extra);
        }
        return extra;
    }
}
