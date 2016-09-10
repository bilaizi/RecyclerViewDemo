package com.example.bilaizi.recyclerviewdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(
                view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
        );
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        loadListData(false, true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_list_normal) {
            loadListData(false, true);
            return true;
        } else if (id == R.id.action_list_virtical_reverse) {
            loadListData(true, true);
            return true;
        } else if (id == R.id.action_list_horizontal) {
            loadListData(false, false);
            return true;
        } else if (id == R.id.action_list_horizontal_reverse) {
            loadListData(true, false);
            return true;
        } else if (id == R.id.action_grid_normal) {
            loadGridData(false, true);
            return true;
        } else if (id == R.id.action_grid_virtical_reverse) {
            loadGridData(true, true);
            return true;
        } else if (id == R.id.action_grid_horizontal) {
            loadGridData(false, false);
            return true;
        } else if (id == R.id.action_grid_horizontal_reverse) {
            loadGridData(true, false);
            return true;
        }
        else if (id == R.id.action_staggered_normal) {
            loadStaggeredData(false, true);
            return true;
        } else if (id == R.id.action_staggered_virtical_reverse) {
            loadStaggeredData(true, true);
            return true;
        } else if (id == R.id.action_staggered_horizontal) {
            loadStaggeredData(false, false);
            return true;
        } else if (id == R.id.action_staggered_horizontal_reverse) {
            loadStaggeredData(true, false);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadListData(boolean reverse, boolean vertical) {
        List<DataBean> datas = new ArrayList<>();
        /*DataBean bean1 = new DataBean();
        bean1.icon = R.mipmap.icon_01;
        bean1.name = "图片-1"
        datas.add(bean1);
        DataBean bean2 = new DataBean();
        bean2.icon = R.mipmap.icon_02;
        bean2.name = "图片-2";
        datas.add(bean2);
        System.out.println("Hello World!");*/
        for (int i = 0; i < DATAS.ICONS.length; i++) {
            DataBean bean = new DataBean();
            bean.icon = DATAS.ICONS[i];
            bean.name = "图片-" + i;
            datas.add(bean);
        }
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setReverseLayout(reverse);
        mLinearLayoutManager.setOrientation(vertical
                ? LinearLayoutManager.VERTICAL
                : LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(new ListAdapter(this, datas));
    }

    private void loadGridData(boolean reverse, boolean vertical) {
        List<DataBean> datas = new ArrayList<>();
        for (int i = 0; i < DATAS.ICONS.length; i++) {
            DataBean bean = new DataBean();
            bean.icon = DATAS.ICONS[i];
            bean.name = "图片-" + i;
            datas.add(bean);
        }
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 2);
        mGridLayoutManager.setReverseLayout(reverse);
        mGridLayoutManager.setOrientation(vertical
                ? LinearLayoutManager.VERTICAL
                : LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setAdapter(new GridAdapter(this, datas));
    }

    private void loadStaggeredData(boolean reverse, boolean vertical) {
        List<DataBean> datas = new ArrayList<>();
        for (int i = 0; i < DATAS.PICS.length; i++) {
            DataBean bean = new DataBean();
            bean.icon = DATAS.PICS[i];
            bean.name = "图片-" + i;
            datas.add(bean);
        }
        StaggeredGridLayoutManager mStaggeredLayoutManager = new StaggeredGridLayoutManager(2,vertical
                ? StaggeredGridLayoutManager.VERTICAL
                : StaggeredGridLayoutManager.HORIZONTAL);
        mStaggeredLayoutManager.setReverseLayout(reverse);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        mRecyclerView.setAdapter(new StaggeredAdapter(this, datas));
    }
}

