package com.iapps.animesearch;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.iapps.animesearch.model.trace.TraceResult;
import com.iapps.animesearch.model.trace.example;
import com.iapps.animesearch.network.ApiClient;
import com.iapps.animesearch.network.ApiService;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UploadFragment extends Fragment {

    ImageView imageView;
    Button button, button1;
    private TraceResult traceResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upload, container, false);

        imageView = (ImageView) view.findViewById(R.id.image_uploaded);
        button = (Button) view.findViewById(R.id.btnUpload);
        button1 = (Button) view.findViewById(R.id.btnSearchupload);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            2000);
                }
                else {
                    startGallery();
                    button1.setVisibility(View.VISIBLE);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("result", traceResult.getAnilist().getIdMal());
                startActivity(intent);
            }
        });

        return view;
    }

    private void startGallery() {
        Intent cameraIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        cameraIntent.setType("image/*");
        if (cameraIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(cameraIntent, 1000);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri returnUri;
        returnUri = data.getData();

        uploadFile(returnUri);

        Glide.with(this)
                .load(returnUri)
                .override(1280, 1280)
                .centerCrop()
                .into(imageView);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void uploadFile(Uri fileUri) {
        // create upload service client
        ApiService service = ApiClient.getTraceInstance().getAPIService();

        // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
        // use the FileUtils to get the actual file by uri
        File file = FileUtils.getFile(getContext(), fileUri);

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse(getContext().getContentResolver().getType(fileUri)),
                        file
                );

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("image", file.getName(), requestFile);

        // add another part within the multipart request
        String descriptionString = "hello, this is description speaking";
        RequestBody description =
                RequestBody.create(
                        okhttp3.MultipartBody.FORM, descriptionString);

        // finally, execute the request
        Call<example> call = service.upload("anilistInfo", body);
        call.enqueue(new Callback<example>() {
            @Override
            public void onResponse(Call<example> call,
                                   Response<example> response) {
                Log.v("Upload", response.body().toString());
                traceResult = response.body().getResult().get(0);
            }

            @Override
            public void onFailure(Call<example> call, Throwable t) {
                Log.e("Upload error:", t.getMessage());
            }
        });
    }

}