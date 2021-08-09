package com.iapps.animesearch.viewmodel;

import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iapps.animesearch.DetailActivity;
import com.iapps.animesearch.R;
import com.iapps.animesearch.databinding.DetailBinding;
import com.iapps.animesearch.model.jikan.JikanResult;
import com.iapps.animesearch.network.ApiClient;
import com.iapps.animesearch.network.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeViewModel extends ViewModel {

    public MutableLiveData<AnimeViewModel> mutableLiveData = new MutableLiveData<>();

    private JikanResult jikanResult;


    public String title, title_japanese, status, synopsis, rating, image_url, genre = "";


    public int episodes = 0;


    public float score = 0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public AnimeViewModel(JikanResult item) {
        this.title = "anime 2";
        this.title_japanese = item.getTitleJapanese();
        this.synopsis = item.getSynopsis();
        this.status = item.getStatus();
        this.episodes = item.getEpisodes();
        this.score = item.getScore().floatValue();
        this.rating = item.getRating();
        this.genre = item.getGenres().get(0).getName();
        this.image_url = item.getImageUrl();
    }

    public AnimeViewModel() {
    }

    public String imgUrl() {
        return image_url;
    }

    @BindingAdapter({"imgUrl"})
    public static void loadimage(ImageView imageView, String images_url) {
        Glide.with(imageView.getContext())
                .load(images_url)
                .apply(RequestOptions.overrideOf(300))
                .into(imageView);
    }

    public MutableLiveData<AnimeViewModel> getMutableLiveData(Integer data) {

        ApiService service = ApiClient.getInstance().getAPIService();
        Call<JikanResult> result = service.getJikanResult(data);

        result.enqueue(new Callback<JikanResult>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<JikanResult> call, Response<JikanResult> response) {
                try {
                    jikanResult = response.body();
                    Log.d("cekcek", response.body().getTitle());
                    AnimeViewModel animeViewModel = new AnimeViewModel(jikanResult);
                    Log.d("tes", String.valueOf(animeViewModel.episodes));
                    mutableLiveData.setValue(animeViewModel);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<JikanResult> call, Throwable t) {

            }
        });
        if (mutableLiveData != null) Log.d("cekcek", "tdk error");
        return mutableLiveData;
    }


    public String getTitle() {
        return title;
    }

    public String getTitle_japanese() {
        return title_japanese;
    }

    public String getStatus() {
        return status;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getRating() {
        return rating;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getGenre() {
        return genre;
    }

    public int getEpisodes() {
        return episodes;
    }

    public float getScore() {
        return score;
    }
}
