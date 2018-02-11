package wei.com.fragment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

// 負責執行 選單 Fragment 畫面的載入工作
// 繼承自 Support Library 的 Fragment 類別
public class MasterFragment extends Fragment {

    // 顯示項目資料用的 ListView 元件
    private ListView item_list;

    // 建立並回傳指定的 Fragment 畫面 (invoked by MainActivity)
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // 載入指定的 Fragment 畫面
        View result = inflater.inflate(R.layout.fragment_master, container,
                false);

        // 讀取並設定畫面的指定元件
        item_list = result.findViewById(R.id.item_list);

        // 回傳建立好的 Fragment 元件
        return result;
    }

    // Activity 建立完成時
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 建立 ListView 使用的資料來源 Adpapter 物件
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, DataSet.rpis
        );

        // 設定 ListView 的 Adapter 來源物件
        item_list.setAdapter(adapter);

        // 註冊 ListView 項目點擊事件
        item_list.setOnItemClickListener(new MyItemClickListener());
    }

    private class MyItemClickListener implements AdapterView.OnItemClickListener {

        // <param name="parent"> 呼叫這個方法的 ListView 物件 </param>
        // <param name="view"> 被點擊的 ItemView 項目 (ListView 中的其中一個) </param>
        // <param name="position"> 被點擊的 ItemView 位置 </param>
        // <param name="id"> 被點擊的 ItemView id </param>
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // 取得 MainActivity
            MainActivity mainActivity = (MainActivity) getActivity();

            // 通知 Activity 元件項目點擊的編號
            mainActivity.OnItemSelected(position);
        }
    }

    // 提供給 Activity 元件實作的介面
    interface OnItemSelectedListener {
        // <summary>  </summary>
        // <param name="position"> 使用者選擇的項目編號 </param>
        void OnItemSelected(int position);
    }
}
