package com.teacher.androidbase.androidbaseexecrcise;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.teacher.androidbase.androidbaseexecrcise.adapter.MainAdapter;
import com.teacher.androidbase.androidbaseexecrcise.adapter.MainViewHolder;
import com.teacher.androidbase.androidbaseexecrcise.day01.CallDarling;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/6/11.
 */
public class DemoListActivity extends AppCompatActivity implements MainViewHolder.MainOnClickListener, MainViewHolder.MainOnLongClickListener {

    @BindView(R.id.main_recycler_view)
    RecyclerView mRecyclerView;

    public MainAdapter mMainAdapter;
    public List<String> mDemoArray;
    public String mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);


        mDay = getIntent().getStringExtra(MainActivity.DEMO_DAY);
        mDemoArray = myDemoArray(mDay);
        mMainAdapter = new MainAdapter(mDemoArray);

        mRecyclerView.setAdapter(mMainAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mMainAdapter.setMainOnClickListener(this);
        mMainAdapter.setMainOnLongClickListener(this);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<String> myDemoArray(String day){
        ArrayList<String> array = new ArrayList<>();
        switch(day) {
            case "FirstDay":
                array = firstDayDemoName();
                break;
            case "SecondsDay":
                break;
            case "ThirdDay":
                break;
            case "FourthDay":
                break;
            case "FifthDay":
                break;
            case "SixthDay":
                break;
            case "SeventhDay":
                break;
            case "EighthDay":
                break;
        }
//        array.add("FirstDay");
//        array.add("SecondsDay");
//        array.add("ThirdDay");
//        array.add("FourthDay");
//        array.add("FifthDay");
//        array.add("SixthDay");
//        array.add("SeventhDay");
//        array.add("EighthDay");
//        array.add("NinthDay");
//        array.add("TenthDay");
//        array.add("EleventhDay");
//        array.add("TwelfthDay");
//        array.add("ThirteenthDay");
        return array;
    }

    private ArrayList<String> firstDayDemoName() {
        ArrayList<String> array = new ArrayList<>();
        array.add("CallDarling");
        return array;
    }

    @Override
    public void onItemClick(View view, int position) {
        //// TODO: 2016/6/12 start demo activity
        switch(mDay) {
            case "FirstDay":
                firstDayDemo(view, position);
                break;
            case "SecondsDay":
                break;
            case "ThirdDay":
                break;
            case "FourthDay":
                break;
            case "FifthDay":
                break;
            case "SixthDay":
                break;
            case "SeventhDay":
                break;
            case "EighthDay":
                break;
        }
    }

    private void firstDayDemo(View view, int position) {
        List<String> demoArray = firstDayDemoName();
        switch (position) {
            case 0:
            startActivity(new Intent(this, CallDarling.class));
                break;
        }
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
