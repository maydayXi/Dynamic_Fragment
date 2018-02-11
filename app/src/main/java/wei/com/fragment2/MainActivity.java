package wei.com.fragment2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
    implements MasterFragment.OnItemSelectedListener{

    // 紀錄目前選擇的項目編號
    // 旋轉畫面時會不見，所以要先保存變數
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 會依照畫面直立或橫式自動載入對應的畫面配置資源
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {

            if (savedInstanceState != null)
                this.position = savedInstanceState.getInt("position", 0);

            FragmentManager manager = getSupportFragmentManager();
            DetailFragment detail = (DetailFragment)
                    manager.findFragmentById(R.id.detail_fragment);
            detail.updateDetail(position);

            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null)
                actionBar.hide();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {

            outState.putInt("position", this.position);
            super.onSaveInstanceState(outState);
        }
    }

    @Override
    public void OnItemSelected(int position) {

        this.position = position;

        // 如果裝置是橫式的話
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {

            // 為了支援 Support Library 所以呼叫 getSupportFragmentManager 方法
            // 取得 FragmentManager 物件
            FragmentManager manager = getSupportFragmentManager();

            // 讀取 DetailFragment 元件
            DetailFragment detail = (DetailFragment)
                    manager.findFragmentById(R.id.detail_fragment);

            // 更新畫面資料
            detail.updateDetail(position);
        }
        // 如果畫面是直的
        else {
            // 準備啟動明細資料的 Activity 元件
            Intent intent = new Intent(this, DetailActivity.class);

            // 儲存項目編號資料
            intent.putExtra("position", position);

            // 啟動 Activity 元件
            startActivity(intent);
        }
    }
}
