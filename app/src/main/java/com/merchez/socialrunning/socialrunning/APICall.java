package com.merchez.socialrunning.socialrunning;

import android.net.Credentials;
import android.util.Log;

import java.io.IOException;
import java.util.logging.Level;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;

/**
 * Created by Youssra on 21/03/2017.
 */

public class APICall {


    //GET network request
    public static ResponseBody GET(OkHttpClient client, HttpUrl url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body();
    }


    //POST network request
    public static ResponseBody POST(OkHttpClient client, HttpUrl url, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body();
    }
}
