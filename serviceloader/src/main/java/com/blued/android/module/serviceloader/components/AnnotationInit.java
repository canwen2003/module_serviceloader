package com.blued.android.module.serviceloader.components;


import com.blued.android.module.serviceloader.core.UriHandler;

/**
 * Created by jzj on 2018/4/28.
 */

public interface AnnotationInit<T extends UriHandler> {

    void init(T handler);
}
