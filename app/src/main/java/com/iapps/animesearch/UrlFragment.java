package com.iapps.animesearch;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.iapps.animesearch.model.trace.TraceResult;
import com.iapps.animesearch.model.trace.example;
import com.iapps.animesearch.network.ApiClient;
import com.iapps.animesearch.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UrlFragment extends Fragment {



    public UrlFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private EditText editText;
    private Retrofit retrofit;
    private TraceResult traceResult;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_url, container, false);

        button = (Button) view.findViewById(R.id.btnSearch);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("result", traceResult.getAnilist());
                startActivity(intent);
            }
        });


        editText = (EditText) view.findViewById(R.id.search_edit);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                webView.loadUrl("https://api.trace.moe/search?url="+ searchView.getQuery());
//                ApiService service = ApiClient.getTraceInstance().getAPIService();
//                Call<example> result = service.getexample(query);
//
//                result.enqueue(new Callback<example>() {
//                    @Override
//                    public void onResponse(Call<example> call, Response<example> response) {
//                        try {
//                            traceResult = response.body().getResult().get(0);
//                            button.setVisibility(View.VISIBLE);
//                            Log.d("cekcek", response.body().toString());
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<example> call, Throwable t) {
//
//                    }
//                });
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });

        editText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    ApiService service = ApiClient.getTraceInstance().getAPIService();
                    Call<example> result = service.getexample(editText.getText().toString());

                    result.enqueue(new Callback<example>() {
                        @Override
                        public void onResponse(Call<example> call, Response<example> response) {
                            try {
                                traceResult = response.body().getResult().get(0);
                                button.setVisibility(View.VISIBLE);
                                Log.d("cekcek", response.body().toString());
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<example> call, Throwable t) {

                        }
                    });
                    return true;
                }
                return false;
            }
        });

        return view;
    }
}