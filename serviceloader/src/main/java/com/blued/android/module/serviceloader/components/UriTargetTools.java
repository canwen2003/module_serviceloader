package com.blued.android.module.serviceloader.components;



import com.blued.android.module.serviceloader.common.NotExportedInterceptor;
import com.blued.android.module.serviceloader.core.UriHandler;
import com.blued.android.module.serviceloader.core.UriInterceptor;


/**
 * 跳转目标，支持ActivityClass, ActivityClassName, UriHandler。
 *
 * Created by jzj on 2018/3/26.
 */

public class UriTargetTools {

    public static UriHandler parse(Object target, boolean exported,
                                   UriInterceptor... interceptors) {
        UriHandler handler = toHandler(target);
        if (handler != null) {
            if (!exported) {
                handler.addInterceptor(NotExportedInterceptor.INSTANCE);
            }
            handler.addInterceptors(interceptors);
        }
        return handler;
    }

    private static UriHandler toHandler(Object target) {
        if (target instanceof UriHandler) {
            return (UriHandler) target;
        }  else {
            return null;
        }
    }

}
