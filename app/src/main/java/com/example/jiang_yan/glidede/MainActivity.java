package com.example.jiang_yan.glidede;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "app";
    @Bind(R.id.list_pic)
    ListView listPic;
    private ArrayList<String> urls;
    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        add();
        initView();
new Lockk().get();
        setButton();
    }
    private void setButton() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 60; i > 0; i--) {
                    SystemClock.sleep(1000);
                    Log.e(TAG, "run:  sleep " );
                }
            }
        }.start();
    }
    private void add() {
        urls = new ArrayList<>();
        urls.add("http://www.bz55.com/uploads/allimg/150604/140-150604112059.jpg");
        urls.add("http://image.tianjimedia.com/uploadImages/2015/083/30/VVJ04M7P71W2.jpg");
        urls.add("http://cdn.duitang.com/uploads/item/201403/01/20140301142145_kt5Gc.jpeg");
        urls.add("http://www.bz55.com/uploads/allimg/150710/139-150G0111125.jpg");
        urls.add("http://www.yh31.com/UploadFiles/Article2/PZSMK8/20144/201404132152143071.jpg");
        urls.add("http://dynamic-image.yesky.com/1080x-/uploadImages/2014/188/09/81DY924D4CYS.jpg");
        urls.add("http://img.pconline.com.cn/images/upload/upc/tx/itbbs/1608/08/c29/25289140_1470644376136_mthumb.jpg");
        urls.add("http://cdn.duitang.com/uploads/item/201403/01/20140301142145_kt5Gc.jpeg");
        urls.add("http://www.bz55.com/uploads/allimg/150710/139-150G0111125.jpg");

        for (int i = 0; i < 100000; i++) {
            urls.add("http://img.pconline.com.cn/images/upload/upc/tx/itbbs/1608/08/c29/25289140_1470644376136_mthumb.jpg");
            urls.add("http://dynamic-image.yesky.com/1080x-/uploadImages/2014/188/09/81DY924D4CYS.jpg");
            urls.add("http://cdn.duitang.com/uploads/item/201403/01/20140301142145_kt5Gc.jpeg");
            urls.add("http://www.yh31.com/UploadFiles/Article2/PZSMK8/20144/201404132152143071.jpg");
            urls.add("http://img2.moko.cc/users/18/5678/1703466/post/c0/img2_src_10579844.jpg");
            urls.add("http://www.yh31.com/UploadFiles/Article2/PZSMK8/20144/201404132152143071.jpg");
            urls.add("http://cdn.duitang.com/uploads/item/201403/01/20140301142145_kt5Gc.jpeg");
            urls.add("http://img.pconline.com.cn/images/upload/upc/tx/itbbs/1608/08/c29/25289140_1470644376136_mthumb.jpg");
        }
    }


    private void initView() {
        ListView listPic = (ListView) findViewById(R.id.list_pic);
        listPic.setAdapter(new PicAdapter());

        listPic.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.e(TAG, "onScrollStateChanged: " + scrollState);
//                scrollState  =0  停止
//                        1  开始
                if (scrollState == 1) {
                    //开始
//                    Glide.with(getApplicationContext()).pauseRequests();
                    Log.e(TAG, "onScrollStateChanged:       停止   加载图片");
                } else if (scrollState == 0) {
                    //停止
//                    Glide.with(getApplicationContext()).resumeRequests();
                    Log.e(TAG, "onScrollStateChanged:       开始   加载图片");

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
listPic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position<31){
            new Lockk().get();
            startActivity(new Intent(MainActivity.this,B.class));
        }
    }
});
    }

    class PicAdapter extends BaseAdapter {
        GvAdapter gvAdapter;

        public PicAdapter() {
        }

        @Override
        public int getCount() {
            return urls.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getViewTypeCount() {
            return 4;
        }

        @Override
        public int getItemViewType(int position) {
            if (position % 4 == 0) {
                return 0;
            } else if (position % 4 == 1) {
                return 1;
            } else if (position % 4 == 2) {
                return 2;
            }
            return 3;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.e(TAG, "getView: " + position);
            int itemViewType = getItemViewType(position);


            switch (itemViewType) {
                case 0:
                    Log.e(TAG, "itemViewType: 0");
                    if (convertView == null) {
                        convertView = View.inflate(getApplicationContext(), R.layout.item_pic_0, null);
                    }
                    ViewHolder viewHolder0 = ViewHolder.getViewHolder(convertView, 0);
//                    gvAdapter = new GvAdapter();
//                    viewHolder0.gvPic.setAdapter(gvAdapter);

//                    if (gvAdapter == null) {
//                        gvAdapter = new GvAdapter();
//
//                    } else {
//
//                        gvAdapter.notifyDataSetChanged();
//
//                    }
//                    int ii = viewHolder0.gvPic.getCount();
//                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ii * 201, RelativeLayout.LayoutParams.MATCH_PARENT);
//                    viewHolder0.gvPic.setLayoutParams(params);
//                    viewHolder0.gvPic.setColumnWidth(200);
//                    viewHolder0.gvPic.setHorizontalSpacing(1);
//                    viewHolder0.gvPic.setStretchMode(GridView.NO_STRETCH);
//                    viewHolder0.gvPic.setNumColumns(ii);
//                    Log.e(TAG, "  gvAdapter = new GvAdapter();: ");
//                    viewHolder0.gvPic.setAdapter(gvAdapter);

                    LinearLayout llf = (LinearLayout) convertView.findViewById(R.id.ll_father);
                    LinearLayout lls = (LinearLayout) convertView.findViewById(R.id.ll_sun);
                    ImageView iv1 = (ImageView) convertView.findViewById(R.id.iv_1);
                    ImageView iv2 = (ImageView) convertView.findViewById(R.id.iv_2);
                    ImageView iv3 = (ImageView) convertView.findViewById(R.id.iv_3);
                    ImageView iv4 = (ImageView) convertView.findViewById(R.id.iv_4);
                    ImageView iv5 = (ImageView) convertView.findViewById(R.id.iv_5);
                    llf.removeAllViews();
                    for (int u = 5; u > 0; u -= 5) {
                        Log.e(TAG, " 玄幻");
                        if (u >= 5) {
                            Glide.with(getApplicationContext()).load(urls.get(u)).into(iv1);
                            Glide.with(getApplicationContext()).load(urls.get(u)).into(iv2);
                            Glide.with(getApplicationContext()).load(urls.get(u)).into(iv3);
                            Glide.with(getApplicationContext()).load(urls.get(u)).into(iv4);
                            Glide.with(getApplicationContext()).load(urls.get(u)).into(iv5);
                        }
                        llf.addView(lls);
                    }
                    break;
                case 1:
                    Log.e(TAG, "itemV     iewType: 1");
                    if (convertView == null) {
                        convertView = View.inflate(getApplicationContext(), R.layout.item_pic_1, null);
                    }
                    ViewHolder viewHolder1 = ViewHolder.getViewHolder(convertView, 1);
                    Glide.with(getApplicationContext()).load(urls.get(position)).crossFade().into(viewHolder1.imageView);
                    break;
                case 2:
                    Log.e(TAG, "itemViewType: 2");
                    if (convertView == null) {
                        convertView = View.inflate(getApplicationContext(), R.layout.item_pic_2, null);
                    }
                    ViewHolder viewHolder2 = ViewHolder.getViewHolder(convertView, 2);
                    Glide.with(getApplicationContext()).load(urls.get(position)).crossFade().into(viewHolder2.imageView);
                    break;
                case 3:
                    Log.e(TAG, "itemViewType: 3");
                    if (convertView == null) {
                        convertView = View.inflate(getApplicationContext(), R.layout.item_pic_3, null);
                    }
                    ViewHolder viewHolder3 = ViewHolder.getViewHolder(convertView, 3);
                    Glide.with(getApplicationContext()).load(urls.get(position)).crossFade().into(viewHolder3.imageView);
                    break;
            }
            return convertView;
        }
    }

    static class ViewHolder {

        ImageView imageView;

        GridView gvPic;

        public ViewHolder(View convertView, int type) {
            Log.e(TAG, "ViewHolder:gou苟傲 ");
            if (type == 0) {
                gvPic = (GridView) convertView.findViewById(R.id.gv_pic);
            } else {
                imageView = (ImageView) convertView.findViewById(R.id.iv_pic);
            }
        }

        public static ViewHolder getViewHolder(View convertView, int type) {

            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            if (viewHolder == null) {
                viewHolder = new ViewHolder(convertView, type);
                convertView.setTag(viewHolder);
            }
            return viewHolder;
        }

    }

    /**
     * 嵌套的GridView
     */
    class GvAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(), R.layout.item_gv_pic, null);
            }
            GvViewHolder viewHolder = GvViewHolder.getViewHolder(convertView, 0);
            Glide.with(getApplicationContext()).load(urls.get(position)).crossFade().into(viewHolder.imageView);

            return convertView;
        }
    }

    static class GvViewHolder {
        @Bind(R.id.iv_pic)
        ImageView imageView;

        public GvViewHolder(View convertView, int type) {
            Log.e(TAG, "GvViewHolder: 这是GvViewHolder ");
            ButterKnife.bind(this, convertView);
        }

        public static GvViewHolder getViewHolder(View convertView, int type) {

            GvViewHolder viewHolder = (GvViewHolder) convertView.getTag();
            if (viewHolder == null) {
                viewHolder = new GvViewHolder(convertView, type);
                convertView.setTag(viewHolder);
            }
            return viewHolder;
        }

    }
}
