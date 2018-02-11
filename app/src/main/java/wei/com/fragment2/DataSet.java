package wei.com.fragment2;

// 顯示資料類別
class DataSet {
    // 項目的標題
    static final String[] rpis = {
            "RPi Model A", "RPi Model A+", "RPi Model B", "RPi Model B+",
            "RPi Generation 2 Model B", "RPi Zero"
    };

    // 項目的內容
    static final String[] contents = {
            "Price: US$25\nCPU: 700 MHz single-core ARM1176JZF-S\nSDRAM: 256 MB\n" +
            "Power ratings: 300 mA(1.5 W)\nWeight: 45g",
            "Price: US$20\nCPU: 700 MHz single-core ARM1176JZF-S\nSDRAM: 256 MB\n" +
            "Power ratings: 200 mA(1 W)\nWeight: 23g",
            "Price: US$35\nCPU: 700 MHz single-core ARM1176JZF-S\nSDRAM: 512 MB\n" +
            "Power ratings: 700 mA(3.5 W)\nWeight: 45g",
            "Price: US$35\nCPU: 700 MHz single-core ARM1176JZF-S\nSDRAM: 512 MB\n" +
            "Power ratings: 600 mA(3 W)\nWeight: 45g",
            "Price: US$35\nCPU: 900 MHz quad-core ARM Cortex-A7\nSDRAM: 1 GB\n" +
            "Power ratings: 800 mA(4 W)\nWeight: 45g",
            "Price: US$5\nCPU: 700 MHz single-core ARM ARM1176JZF-S\nSDRAM: 512 MB\n" +
            "Power ratings: 160 mA\nWeight: ..g"
    };

    // 項目的圖片
    static final int[] images = {
            R.drawable.rpi_model_a, R.drawable.rpi_model_a_plus,
            R.drawable.rpi_model_b, R.drawable.rpi_model_b_plus,
            R.drawable.rpi_2_model_b, R.drawable.rpi_zero
    };
}
