package com.blued.android.module.serviceloader.common;

import android.support.annotation.NonNull;

import com.blued.android.module.serviceloader.core.UriCallback;
import com.blued.android.module.serviceloader.core.UriHandler;
import com.blued.android.module.serviceloader.core.UriRequest;


/**
 * Created by jzj on 2018/3/30.
 */

public class WrapperHandler extends UriHandler {

    private final UriHandler mDelegate;

    public WrapperHandler(UriHandler delegate) {
        mDelegate = delegate;
    }

    public UriHandler getDelegate() {
        return mDelegate;
    }

    @Override
    protected boolean shouldHandle(@NonNull UriRequest request) {
        return true;
    }

    @Override
    protected void handleInternal(@NonNull UriRequest request, @NonNull UriCallback callback) {
        mDelegate.handle(request, callback);
    }

    @Override
    public String toString() {
        return "Delegate(" + mDelegate.toString() + ")";
    }
}
