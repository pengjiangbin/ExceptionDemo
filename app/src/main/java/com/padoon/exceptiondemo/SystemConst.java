package com.padoon.exceptiondemo;

import java.io.File;

/**
 * Created by jiang on 2017/2/23.
 */

public class SystemConst {
    public static final String BASE_URL_SAMPLE = "http://192.115.47.168/";
    public static final String PATH_DATA = MyApplication.getContext().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + File.separator + "net";
}
