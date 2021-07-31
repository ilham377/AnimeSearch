package com.iapps.animesearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.jetbrains.annotations.NotNull;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {

        this.context = context;
    }

    //arrays
    public int[] slide_images = {
            R.drawable.ic_baseline_android_24
//            R.drawable.daily,
//            R.drawable.gallery,
//            R.drawable.playbutton,
//            R.drawable.user
    };

    public String[] slide_heading = {

            "Home",
            "Daily",
            "Gallery",
            "Music",
            "Profile"
    };

    public String[] slide_desc = {

            "Menu Home berisikan dengan biodata saya",
            "Menu Daily berisikan dengan kegiatan sehari-hari dan friend list",
            "Menu Gallery berisikan dengan foto/gambar",
            "Menu Music berisikan dengan Music-music favorite saya",
            "Menu Profile berisikan dengan aboutme, findme, contact, dan about aplikasi"
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slideimg);
        TextView slideHeading = (TextView) view.findViewById(R.id.txthead);
        TextView slideDesc = (TextView) view.findViewById(R.id.txtdesc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_heading[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {

        container.removeView((LinearLayout) object);

    }
}
