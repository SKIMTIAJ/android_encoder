package com.imtiaj.recyclerview_pro.adaptor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.imtiaj.recyclerview_pro.R;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class imageAdapter extends PagerAdapter {

    private Context ctx;
        int[] array = {
            R.drawable.man,
            R.drawable.sthatoscop
    };

    public imageAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return array.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(ctx);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(array[position]);
        container.addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
