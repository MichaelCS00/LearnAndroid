package com.example.michaelcs.networktest;

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
