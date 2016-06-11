package com.teacher.androidbase.androidbaseexecrcise.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.webkit.WebView;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/6/10.
 */
public class DemoUtils {
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void loadCodeAtWebView(Context context, String code, WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        InputStream inputStream = null;
        String templace = null;
        try {
            inputStream = context.getAssets().open("index.html");
            readTextFile(inputStream);
            templace = templace.replace("__CODE__", Html.escapeHtml(code));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(inputStream);
        }
        String baseUrl = "file:///android_asset/";
        webView.loadDataWithBaseURL(baseUrl, templace, "text/html", "UTF-8", "");
    }

    public static void closeQuietly(Closeable closeable) {

        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buff = new byte[8 * 1024];
        int len;
        try {
            while ((len = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toString();
    }
}
