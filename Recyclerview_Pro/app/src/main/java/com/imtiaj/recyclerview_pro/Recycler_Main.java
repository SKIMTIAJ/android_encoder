package com.imtiaj.recyclerview_pro;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.imtiaj.recyclerview_pro.adaptor.ChildItemAdapter;
import com.imtiaj.recyclerview_pro.adaptor.imageAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import static com.imtiaj.recyclerview_pro.Recyclerview_model.IMAGE_FILE;
import static com.imtiaj.recyclerview_pro.Recyclerview_model.RECYCLER;
import static com.imtiaj.recyclerview_pro.Recyclerview_model.SLIDER;
import static com.imtiaj.recyclerview_pro.Recyclerview_model.TEXT_FILE;
import static com.imtiaj.recyclerview_pro.Recyclerview_model.VIDEOVIEW;


public class Recycler_Main  extends RecyclerView.Adapter {

    private List<Recyclerview_model> modelClassList;
     private Context ctx;
     private com.imtiaj.recyclerview_pro.adaptor.imageAdapter imageadapter;
    int[] allImagesArray = {
            R.drawable.man,
            R.drawable.sthatoscop
    };

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    public Recycler_Main(List<Recyclerview_model> modelClassList,Context ctx) {
        this.modelClassList = modelClassList;
        this.ctx = ctx;
    }
    /*private List<ParentItem> itemList;*/

    @Override
    public int getItemViewType(int position) {
        switch(modelClassList.get(position).getViewType()){
            case 0:
                return TEXT_FILE;
            case 1:
                return IMAGE_FILE;
            case 2:
                return RECYCLER;
            case 3:
                return VIDEOVIEW;
            case 4:
                return SLIDER;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case TEXT_FILE:
                View textLay = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_item,parent,false);
                return new TextClass(textLay);
            case IMAGE_FILE:
                View ImageLay = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout,parent,false);
                return new ImageClass(ImageLay);
            case RECYCLER:
                View Recyclerview = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_vertical_recycler, parent, false);
                return new ParentViewHolder(Recyclerview);
            case VIDEOVIEW:
                View Videoview = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
                return new VideoViewHolder(Videoview);
            case SLIDER:
                View Image_slider = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider, parent, false);
                return new ViewPagerHolder(Image_slider);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch(modelClassList.get(position).getViewType()){
            case TEXT_FILE:
                String textCap = modelClassList.get(position).getCaption();
                ((TextClass)holder).setData(textCap);
                break;
            case IMAGE_FILE:
                int image = modelClassList.get(position).getImage();
                ((ImageClass)holder).setData(image);
                break;
            case RECYCLER:
                Recyclerview_model parentItem = modelClassList.get(position);
                LinearLayoutManager layoutManager = new LinearLayoutManager(((ParentViewHolder)holder).ChildRecyclerView.getContext(),
                        LinearLayoutManager.HORIZONTAL, false);
                layoutManager.setInitialPrefetchItemCount(parentItem.getChildItemList().size());
                ChildItemAdapter childItemAdapter = new ChildItemAdapter(parentItem.getChildItemList());
                ((ParentViewHolder)holder).ChildRecyclerView.setLayoutManager(layoutManager);
                ((ParentViewHolder)holder).ChildRecyclerView.setAdapter(childItemAdapter);
                ((ParentViewHolder)holder).ChildRecyclerView.setRecycledViewPool(viewPool);
                break;
            case VIDEOVIEW:
                String video = modelClassList.get(position).getVideoURL();
                Uri uri = Uri.parse(video);
                ((VideoViewHolder)holder).setVideo(uri);
                break;
            case SLIDER:
//                int [] image_for_slider = modelClassList.get(position).getImage_slider();
                imageadapter = new imageAdapter(ctx);

                break;
            default:
                return;
        }
    }


    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class ImageClass extends RecyclerView.ViewHolder {
        private ConstraintLayout imageParent;
        private ImageView imageView;
        public ImageClass(@NonNull View itemView) {
            super(itemView);
            imageParent = (ConstraintLayout)itemView.findViewById(R.id.imageLayParent);
            imageView = (ImageView)itemView.findViewById(R.id.MainImage);
        }
        private void setData(int image){
            imageView.setImageResource(image);
        }
    }

    public class TextClass extends RecyclerView.ViewHolder {
        private ConstraintLayout textParent;
        private TextView textView;
        public TextClass(@NonNull View itemView) {
            super(itemView);
            textParent = (ConstraintLayout)itemView.findViewById(R.id.ParentText);
             textView = (TextView) itemView.findViewById(R.id.caption);
        }
        private void setData(String text){
            textView.setText(text);
        }
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder {

        private TextView ParentItemTitle;
        private RecyclerView ChildRecyclerView;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);
            /*ParentItemTitle
                    = itemView
                    .findViewById(
                            R.id.parent_item_title);*/
            ChildRecyclerView = itemView.findViewById(R.id.child_recyclerview);

        }
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        private VideoView Vview;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            /*ParentItemTitle
                    = itemView
                    .findViewById(
                            R.id.parent_item_title);*/
            Vview = itemView.findViewById(R.id.videoview);

        }
        private void setVideo(Uri uri){
            Vview.setVideoURI(uri);
            MediaController mediaController = new MediaController(ctx);
            Vview.setMediaController(mediaController);
            mediaController.setAnchorView(Vview);
        }
    }

    public class ViewPagerHolder extends RecyclerView.ViewHolder {

        private ViewPager Vpager;

        public ViewPagerHolder(@NonNull View itemView) {
            super(itemView);
            /*ParentItemTitle
                    = itemView
                    .findViewById(
                            R.id.parent_item_title);*/
            Vpager = itemView.findViewById(R.id.viewpager);
            Vpager.setAdapter(imageadapter);

        }
        private void setVideo(Uri uri){
           /* Vview.setVideoURI(uri);
            MediaController mediaController = new MediaController(ctx);
            Vview.setMediaController(mediaController);
            mediaController.setAnchorView(Vview);*/
        }
    }



}