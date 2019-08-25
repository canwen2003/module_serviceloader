package com.blued.android.module.serviceloader.common;

import android.support.annotation.NonNull;

import com.blued.android.module.serviceloader.components.UriSourceTools;
import com.blued.android.module.serviceloader.core.UriCallback;
import com.blued.android.module.serviceloader.core.UriInterceptor;
import com.blued.android.module.serviceloader.core.UriRequest;
import com.blued.android.module.serviceloader.core.UriResult;


/**
 * 节点的exported为false，不允许来自外部的跳转，拦截并返回 {@link UriResult#CODE_FORBIDDEN}
 *
 * Created by jzj on 2018/3/26.
 */

public class NotExportedInterceptor implements UriInterceptor {

    public static final NotExportedInterceptor INSTANCE = new NotExportedInterceptor();

    private NotExportedInterceptor() {
    }

    @Override
    public void intercept(@NonNull UriRequest request, @NonNull UriCallback callback) {
        if (UriSourceTools.shouldHandle(request, false)) {
            callback.onNext();
        } else {
            callback.onComplete(UriResult.CODE_FORBIDDEN);
        }
    }
}
