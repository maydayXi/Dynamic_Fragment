package wei.com.fragment2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    // 負責顯示詳細資料的 Fragment
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 如果裝置是橫式
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            // 結束回到主畫面
            finish();
            return;
        }

        setContentView(R.layout.activity_detail);
        processViews();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 取得點擊的項目編號
        int position = getIntent().getIntExtra("position", -1);

        if (position != -1) {
            // 設定元件標題
            setTitle(DataSet.rpis[position]);
            // 更新 DetailFragment 畫面元件內容
            detailFragment.updateDetail(position);
        }
    }

    private void processViews() {

        // 為了支援 Support Library
        // 呼叫 getSupportFragmentManager 方法
        // 取得 FragmentManager 物件
        FragmentManager manager = getSupportFragmentManager();

        // 取得 Support Library 的 FragmentTransaction 物件
        FragmentTransaction transaction = manager.beginTransaction();

        // 建立 DetailFragment 物件
        detailFragment = new DetailFragment();

        // 加入 DetailFragment 到指定的畫面元件
        transaction.add(R.id.detail_container, detailFragment);

        transaction.commit();
    }
}
