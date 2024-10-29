package cn.xiaosuli.firstapp;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Grid RecyclerView
        RecyclerView gridRv1 = findViewById(R.id.grid_rv1);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        gridRv1.setLayoutManager(gridLayoutManager);
        GridRvAdapter gridRvAdapter = new GridRvAdapter(this, getGridRvData());
        gridRv1.setAdapter(gridRvAdapter);
        // StaggeredGrid RecyclerView
        RecyclerView gridRv2 = findViewById(R.id.grid_rv2);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL);
        gridRv2.setLayoutManager(staggeredGridLayoutManager);
        gridRv2.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.left = 18;
                outRect.right = 18;
                outRect.top = 18;
                outRect.bottom = 18;
            }
        });
        BookRvAdapter bookRvAdapter = new BookRvAdapter(this, getBookRvData());
        gridRv2.setAdapter(bookRvAdapter);
    }

    private List<BookRvItem> getBookRvData() {
        List<BookRvItem> data = new ArrayList<>();
        data.add(new BookRvItem(R.drawable.book1, "计算机组成原理(第3版)", "唐朔飞", "高等教育出版社", "35.00"));
        data.add(new BookRvItem(R.drawable.book2, "计算机网络教材+习题解答", "谢希仁", "电子工业出版社", "45.00"));
        data.add(new BookRvItem(R.drawable.book3, "成事之道", "未知作者", "未知出版社", "00.00"));
        data.add(new BookRvItem(R.drawable.book4, "Python编程：从入门到实践", "未知作者", "人民邮电出版社", "109.80"));
        data.add(new BookRvItem(R.drawable.book5, "计算机科学导论", "贝赫鲁兹·佛罗赞(Behrouz A.Forouzan)", "机械工业出版社", "89.00"));
        data.add(new BookRvItem(R.drawable.book6, "计算机组成与设计硬件软件接口", "未知作者", "机械工业出版社", "169.00"));
        data.add(new BookRvItem(R.drawable.book7, "Java编程思想", "陈昊鹏", "人民邮电出版社", "100.00"));
        data.add(new BookRvItem(R.drawable.book8, "算法导论", "科曼", "机械工业出版社", "128.00"));
        data.add(new BookRvItem(R.drawable.book9, "人工智能", "Stuart J. Russell,Peter Norvig", "清华大学出版社", "00.00"));
        data.add(new BookRvItem(R.drawable.book10, "算法竞赛", "罗勇军，郭卫斌", "清华大学出版社", "168.00"));
        data.add(new BookRvItem(R.drawable.book11, "这就是ChatGPT", "斯蒂芬·沃尔弗拉姆", "人民邮电出版社", "59.00"));
        data.add(new BookRvItem(R.drawable.book12, "Python数据分析-从零基础入门到案例实战", "余本国", "北京理工大学出版社", "89.00"));
        data.add(new BookRvItem(R.drawable.book13, "深入理解高并发编程:JDK核心技术", "冰河", "电子工业出版社", "129.00"));
        data.add(new BookRvItem(R.drawable.book14, "算法图解+啊哈算法", "Aditya Bhargava 啊哈磊", "人民邮电出版社", "94.00"));
        data.add(new BookRvItem(R.drawable.book15, "Jetpack Compose 从入门到实战", "王鹏，关振智，曾思淇", "机械工业育出版社", "109.00"));
        data.add(new BookRvItem(R.drawable.book16, "Arduino 入门基础教程", "余静", "人民邮电出版社", "49.00"));
        data.add(new BookRvItem(R.drawable.book17, "Apache Pulsar实战", "戴维·克杰鲁姆加德", "人民邮电出版社", "109.80"));
        data.add(new BookRvItem(R.drawable.book18, "Python语言程序设计", "教育部考试中心", "高等教育出版社", "48.00"));
        data.add(new BookRvItem(R.drawable.book19, "C++ Primer Plus中文版第6版", "张海龙", "人民邮电出版社", "118.00"));
        data.add(new BookRvItem(R.drawable.book20, "Visual Studio Code 权威指南", "韩骏", "电子工业出版社", "99.00"));

        return data;
    }

    private List<GridRvItem> getGridRvData() {
        List<GridRvItem> data = new ArrayList<>();
        data.add(new GridRvItem(R.drawable.icon_dili, "地理"));
        data.add(new GridRvItem(R.drawable.icon_junshi, "军事"));
        data.add(new GridRvItem(R.drawable.icon_lishi, "历史"));
        data.add(new GridRvItem(R.drawable.icon_qimeng, "启蒙"));
        data.add(new GridRvItem(R.drawable.icon_shehui, "神话"));
        data.add(new GridRvItem(R.drawable.icon_shenghuo, "生活"));
        data.add(new GridRvItem(R.drawable.icon_shengwu, "生物"));
        data.add(new GridRvItem(R.drawable.icon_shuxue, "数学"));
        data.add(new GridRvItem(R.drawable.icon_sixiang, "思想"));
        data.add(new GridRvItem(R.drawable.icon_tianwenxue, "天文学"));
        data.add(new GridRvItem(R.drawable.icon_wenhua, "文化"));
        data.add(new GridRvItem(R.drawable.icon_wenxue, "文物"));
        data.add(new GridRvItem(R.drawable.icon_yinle, "音乐"));
        data.add(new GridRvItem(R.drawable.icon_yishu, "艺术"));
        data.add(new GridRvItem(R.drawable.icon_yixue, "医学"));
        data.add(new GridRvItem(R.drawable.icon_zhengzhifalv, "政治法律"));
        data.add(new GridRvItem(R.drawable.icon_zhexuezongjiao, "哲学宗教"));
        data.add(new GridRvItem(R.drawable.icon_ziran, "自然"));
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.option_menu_my) {
            Toast.makeText(this, "我的", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.option_menu_share) {
            Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.option_menu_kefu) {
            Toast.makeText(this, "在线客服", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.option_menu_help) {
            Toast.makeText(this, "帮助", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}