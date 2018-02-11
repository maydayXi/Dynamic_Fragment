package wei.com.fragment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

// 執行詳細資料的 Fragment 載入工作
// 繼承自 Support Library 的 Fragment 類別
public class DetailFragment extends Fragment {

    // 畫面元件變數
    // 標題、內容
    // 圖片
    private TextView txt_title, txt_content;
    private ImageView image;

    // 建立與回傳指定的 Fragment 畫面
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // 載入指定的畫面配置資源
        View result = inflater.inflate(R.layout.fragment_detail, container,
                false);

        // 設定畫面元件
        txt_title = result.findViewById(R.id.txtTitle);
        txt_content = result.findViewById(R.id.txtContent);
        image = result.findViewById(R.id.image);

        // 回傳載入的畫面
        return result;
    }

    // <summary> 更新詳細資料 </summary>
    // <param name="position"> 主選單 (master_fragment) 點選的資料位置 </param>
    void updateDetail(int position) {

        txt_title.setText(DataSet.rpis[position]);
        txt_content.setText(DataSet.contents[position]);
        image.setImageResource(DataSet.images[position]);
    }
}
