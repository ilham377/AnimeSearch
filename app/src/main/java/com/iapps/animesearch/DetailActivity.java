package com.iapps.animesearch;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.iapps.animesearch.databinding.DetailBinding;
import com.iapps.animesearch.model.jikan.JikanResult;
import com.iapps.animesearch.model.trace.example;
import com.iapps.animesearch.network.ApiClient;
import com.iapps.animesearch.network.ApiService;
import com.iapps.animesearch.viewmodel.AnimeViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private Toolbar toolbars;
    private JikanResult jikanResult;
    private AnimeViewModel animeViewModel;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int data = (Integer) getIntent().getIntExtra("result", 0);
        animeViewModel = ViewModelProviders.of(this).get(AnimeViewModel.class);
        animeViewModel.getMutableLiveData(data).observe(this, new Observer<AnimeViewModel>() {
            @Override
            public void onChanged(AnimeViewModel animeViewModel) {
                DetailBinding activityMainBinding = DataBindingUtil.setContentView(DetailActivity.this, R.layout.activity_detail);
                activityMainBinding.setViewModel(animeViewModel);
            }
        });

        toolbars = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbars);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24);
//
//        toolbars.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            }
//        });
    }
}