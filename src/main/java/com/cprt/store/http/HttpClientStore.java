package com.cprt.store.http;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import com.cprt.store.http.exception.HttpException;

public class HttpClientStore implements HttpAdapter {

    @Override
    public void post(String url, Map<String, Object> data) {
        try {
            this.executePost(url, data);
        } catch (Exception e) {
            throw new HttpException("Cannot create url");
        }
    }

    private void executePost(String url, Map<String, Object> data) throws IOException {
        URL apiUrl = new URL(url);
        URLConnection apiUrlConnection = apiUrl.openConnection();
        apiUrlConnection.connect();
    }

    

    
    
}
