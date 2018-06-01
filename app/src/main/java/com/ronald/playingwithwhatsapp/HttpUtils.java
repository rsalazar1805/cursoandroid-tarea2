package com.ronald.playingwithwhatsapp;

import android.util.Log;

import com.loopj.android.http.*;


public class HttpUtils {
    //private static final String BASE_URL = "http://api.twitter.com/1/";
    private static final String BASE_URL = "https://reqres.in/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        String staticURL = getAbsoluteUrl(url);
        String staticURL2 = BASE_URL + url;

        client.post(staticURL2, params, responseHandler);

        Log.d("URL", url);
    }

    public static void post(String url, AsyncHttpResponseHandler responseHandler) {
        String staticURL = getAbsoluteUrl(url);
        String staticURL2 = BASE_URL + url;

        client.post(staticURL2, responseHandler);

        Log.d("URL", url);
    }

    public static void getByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(url, params, responseHandler);
    }

    public static void postByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(url, params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
