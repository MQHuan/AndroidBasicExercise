package com.teacher.androidbase.androidbaseexecrcise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.teacher.androidbase.androidbaseexecrcise.adapter.MainAdapter;
import com.teacher.androidbase.androidbaseexecrcise.utils.DemoUtils;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/6/10.
 */
public class ShowDemoCodeBaseActivity extends Activity {
    static public final String CONTENT_TAG = "content";
    public static final String METHOD_TAG = "method";
    public static final String TAG_DEMO = "Demo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo_base, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.show_code) {
            showSourceCode();
        }
        return super.onOptionsItemSelected(item);
    }


    private void showSourceCode() {
        startSourceCodeActivity(getFileSourceCode());
    }

    private String getFileSourceCode() {
        try {
            String name = this.getClass().getSimpleName() + ".file";
            InputStream open = getAssets().open(name);
            String content = DemoUtils.readTextFile(open);
            return content;
        } catch (IOException e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void startSourceCodeActivity(String content) {
        Intent intent = new Intent(this, SourceCodeActivity.class);
        intent.putExtra(CONTENT_TAG, content);
        startActivity(intent);
    }
}
