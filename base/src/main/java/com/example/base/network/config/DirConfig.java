package com.example.base.network.config;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import com.example.base.network.base.MyApp;

import java.io.File;

/**
 * create by libo
 * create on 2018/11/13
 * description 存储路径配置
 */
public class DirConfig {

    private static String rootPath;
    public final static String BASE_DIR = "MvvmFrame";
    public final static String DATA_PATH = "data";//保存的文件，清除缓存不清理此文件夹

    /**
     * 请求数据缓存
     */
    public static final String HTTP_CACHE = getBasePath(MyApp.getContext()) + File.separator + DATA_PATH + File.separator + "http_cache";

    public static String getBasePath(Context context) {
        String basePath;
        if (!TextUtils.isEmpty(rootPath)) {
            basePath = rootPath;
        } else {
            if (!externalStorageWriteable()) {
                basePath = context.getCacheDir().getAbsolutePath() + File.separator + BASE_DIR;
            } else {
                basePath = context.getExternalFilesDir(BASE_DIR).getAbsolutePath();
            }
        }
        rootPath = basePath;
        return basePath;
    }

    /**
     * 检测外部存储是否可写
     *
     * @return boolean 外部存储是否可写
     */
    private static boolean externalStorageWriteable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }
}