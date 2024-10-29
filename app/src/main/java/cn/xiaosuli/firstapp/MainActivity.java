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
        data.add(new BookRvItem(R.drawable.book1, "地理"));
        data.add(new BookRvItem(R.drawable.book2, "地理"));
        data.add(new BookRvItem(R.drawable.book3, "地理"));
        data.add(new BookRvItem(R.drawable.book4, "地理"));
        data.add(new BookRvItem(R.drawable.book5, "地理"));
        data.add(new BookRvItem(R.drawable.book6, "地理"));
        data.add(new BookRvItem(R.drawable.book7, "地理"));
        data.add(new BookRvItem(R.drawable.book8, "地理"));
        data.add(new BookRvItem(R.drawable.book9, "地理"));
        data.add(new BookRvItem(R.drawable.book10, "地理"));
        data.add(new BookRvItem(R.drawable.book11, "地理"));
        data.add(new BookRvItem(R.drawable.book12, "地理"));
        data.add(new BookRvItem(R.drawable.book13, "地理"));
        data.add(new BookRvItem(R.drawable.book14, "地理"));
        data.add(new BookRvItem(R.drawable.book15, "地理"));
        data.add(new BookRvItem(R.drawable.book16, "地理"));
        data.add(new BookRvItem(R.drawable.book17, "地理"));
        data.add(new BookRvItem(R.drawable.book18, "地理"));
        data.add(new BookRvItem(R.drawable.book19, "地理"));
        data.add(new BookRvItem(R.drawable.book20, "地理"));
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