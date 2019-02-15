package com.example.exoplayerhlsdemo;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import adapterAll.CustomAdaptor;
import dataClassAll.ApiClient;
import dataClassAll.VideoDetail;
import dataClassAll.VideoList;
import intefacesAll.ApiInterface;
import intefacesAll.RecycleCallBack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context context;
    boolean connected = false;
    private static final String TAG = "MainActivity ";
    private CustomAdaptor customAdaptor;
    private RecycleCallBack recycleCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        if (getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().heightPixels)
            Toast.makeText(this, "Screen switched to Landscape mode", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Screen switched to Portrait mode", Toast.LENGTH_SHORT).show();

        recyclerView = findViewById(R.id.recyclerView);

        callBacks();
    }

    private void callBacks() {
        recycleCallBack = new RecycleCallBack() {
            @Override
            public void callBack(Object... args) {
                String videoPath = (String) args[0];
                String videoPathmp = (String) args[1];
                Intent intent = new Intent(context, PlayHLSVideo.class);
                intent.putExtra("pathm3u8", videoPath);
                intent.putExtra("pathmp4", videoPathmp);
                startActivity(intent);
            }
        };

        initView();
    }

    private void initView() {
        Toast.makeText(context, "Hello", Toast.LENGTH_LONG).show();
        connected = checkInternetConnection();

        if (connected) {
            callAPI();
        } else {
            Toast.makeText(context, "Intenet not connected", Toast.LENGTH_SHORT).show();
        }
    }

    private void callAPI() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<VideoList> call = apiService.doCreateUserWithField("eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoiMTUyOTMxNDEwMzIwMSIsInVzZXJfZGV2aWNlX2NvZGUiOiJGQkM4OUQ3RTFBMjdERjZDMDY5MzdBNDFCOUMyQjc5OCIsImN1cnJlbnRfZGF0ZSI6IjIwMTgtMTItMjAgMTQ6MTI6MDAifQ.5Exsd_N0kqSq_k93nTFWa2bfW0-N0TxQWyG_grS8CZQAmhNc69np43WDt-8PvN1NfReAuP9H4bnO-YlMNs38jQ", "en");
        call.enqueue(new Callback<VideoList>() {
            @Override
            public void onResponse(Call<VideoList> call, Response<VideoList> response) {
                List<VideoDetail> videos = response.body().getDataFirst().getDataSecond().getNewslist();
                Log.e("get responce code", "==" + response.code());
                Log.e(TAG, "Number of videos: " + videos.size());

                customAdaptor = new CustomAdaptor(context, videos, R.layout.adapter_videos, recycleCallBack);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(customAdaptor);
            }

            @Override
            public void onFailure(Call<VideoList> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }

    private boolean checkInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
            connected = true;
        else
            connected = false;
        return connected;
    }

}
