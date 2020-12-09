package com.imtiaj.recyclerview_pro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.imtiaj.recyclerview_pro.model.ChildItem;

import java.util.ArrayList;
import java.util.List;

import static com.imtiaj.recyclerview_pro.Recyclerview_model.IMAGE_FILE;
import static com.imtiaj.recyclerview_pro.Recyclerview_model.RECYCLER;
import static com.imtiaj.recyclerview_pro.Recyclerview_model.SLIDER;
import static com.imtiaj.recyclerview_pro.Recyclerview_model.TEXT_FILE;
import static com.imtiaj.recyclerview_pro.Recyclerview_model.VIDEOVIEW;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Recycler_Main recycler_adapter;

    ArrayList<String> arraylist;

    String text = new String();
//    int[] allImagesArray = {
//            R.drawable.man,
//            R.drawable.sthatoscop
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            recyclerView = (RecyclerView)findViewById(R.id.Recyclerview);
            arraylist =  new ArrayList<>();
            /*text = "android.resource://"+ getPackageName() + "/" + R.raw.Introduction;*/
        text = "https://www.radiantmediaplayer.com/media/big-buck-bunny-360p.mp4";

            List<Recyclerview_model> modelcleList = new ArrayList<>();
            modelcleList.add(new Recyclerview_model("This is caption",TEXT_FILE));
            modelcleList.add(new Recyclerview_model(R.drawable.man,IMAGE_FILE));
            modelcleList.addAll(ParentItemList());
            modelcleList.add(new Recyclerview_model(VIDEOVIEW,text));
            modelcleList.add(new Recyclerview_model(SLIDER,"Demo Images"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recycler_adapter = new Recycler_Main(modelcleList,this);
        recyclerView.setAdapter(recycler_adapter);
        recyclerView.setHasFixedSize(true);

    }


    private List<Recyclerview_model> ParentItemList()
    {
        List<Recyclerview_model> itemList
                = new ArrayList<>();

        Recyclerview_model item = new Recyclerview_model("Title 1",ChildItemList(),RECYCLER);
        itemList.add(item);
        /*Recyclerview_model item1 = new Recyclerview_model("Title 2",ChildItemList(),RECYCLER);
        itemList.add(item1);
        Recyclerview_model item2 = new Recyclerview_model("Title 3", ChildItemList(),RECYCLER);
        itemList.add(item2);
        Recyclerview_model item3 = new Recyclerview_model("Title 4", ChildItemList(),RECYCLER);
        itemList.add(item3);*/
        return itemList;
    }

    // Method to pass the arguments
    // for the elements
    // of child RecyclerView
    private List<ChildItem> ChildItemList()
    {
        List<ChildItem> ChildItemList
                = new ArrayList<>();

        ChildItemList.add(new ChildItem("Card 1"));
        ChildItemList.add(new ChildItem("Card 2"));
        ChildItemList.add(new ChildItem("Card 3"));
        ChildItemList.add(new ChildItem("Card 4"));

        return ChildItemList;
    }


}