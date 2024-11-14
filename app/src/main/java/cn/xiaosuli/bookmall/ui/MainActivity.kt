package cn.xiaosuli.bookmall.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import cn.xiaosuli.bookmall.R
import cn.xiaosuli.bookmall.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val fragments: List<Fragment> by lazy {
        listOf(HomeFragment(), BookListFragment(), MineFragment())
    }

    private val titles: List<String> by lazy {
        listOf("图书商城", "探索", "我的")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.topAppBar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, systemBars.top, 0, 0)
            insets
        }

        binding.viewPager.apply {
            adapter = FragmentAdapter(this@MainActivity)
            isUserInputEnabled = false
            registerOnPageChangeCallback(object : OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.topAppBar.title = titles[position]
                    when (position) {
                        0 -> binding.bottomNavigation.selectedItemId = R.id.main_bottom_nav_home
                        1 -> binding.bottomNavigation.selectedItemId =
                            R.id.main_bottom_nav_book_list

                        2 -> binding.bottomNavigation.selectedItemId = R.id.main_bottom_nav_mine
                    }
                }
            })
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            var position = 0
            when (item.itemId) {
                R.id.main_bottom_nav_home -> position = 0
                R.id.main_bottom_nav_book_list -> position = 1
                R.id.main_bottom_nav_mine -> position = 2
            }
            binding.topAppBar.title = titles[position]
            binding.viewPager.currentItem = position
            return@setOnItemSelectedListener true
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.main_top_app_bar_share -> {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.setType("text/plain") // 设置分享内容类型为文本
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "安卓期末大作业--图书商城") // 设置分享的内容
                    // 通过Chooser选择分享方式
                    val chooser = Intent.createChooser(shareIntent, "选择一个分享方式")
                    startActivity(chooser)

                    true
                }

                R.id.main_top_app_bar_kefu -> {
                    Toast.makeText(this, "在线客服", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.main_top_app_bar_help -> {
                    Toast.makeText(this, "帮助", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
    }

    inner class FragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = fragments.size
        override fun createFragment(position: Int): Fragment = fragments[position]
    }
}