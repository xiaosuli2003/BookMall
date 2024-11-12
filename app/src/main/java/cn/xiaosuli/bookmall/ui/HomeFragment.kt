package cn.xiaosuli.bookmall.ui

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import cn.xiaosuli.bookmall.R
import cn.xiaosuli.bookmall.adapter.BookRvAdapter
import cn.xiaosuli.bookmall.adapter.ToolbarAdapter
import cn.xiaosuli.bookmall.databinding.FragmentHomeBinding
import cn.xiaosuli.bookmall.model.BookItem
import cn.xiaosuli.bookmall.model.ToolbarItem

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.toolbar.apply {
            layoutManager = GridLayoutManager(activity, 2).apply {
                orientation = RecyclerView.HORIZONTAL
            }
            adapter = ToolbarAdapter(activity, toolBarData)
        }
        binding.bookRv.apply {
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    outRect.left = 18
                    outRect.right = 18
                    outRect.top = 18
                    outRect.bottom = 18
                }
            })
            adapter = BookRvAdapter(activity, bookRvData)
        }
        return binding.root
    }

    private val toolBarData: List<ToolbarItem> = listOf(
        ToolbarItem(R.drawable.icon_dili, "地理"),
        ToolbarItem(R.drawable.icon_junshi, "军事"),
        ToolbarItem(R.drawable.icon_lishi, "历史"),
        ToolbarItem(R.drawable.icon_qimeng, "启蒙"),
        ToolbarItem(R.drawable.icon_shehui, "神话"),
        ToolbarItem(R.drawable.icon_shenghuo, "生活"),
        ToolbarItem(R.drawable.icon_shengwu, "生物"),
        ToolbarItem(R.drawable.icon_shuxue, "数学"),
        ToolbarItem(R.drawable.icon_sixiang, "思想"),
        ToolbarItem(R.drawable.icon_tianwenxue, "天文学"),
        ToolbarItem(R.drawable.icon_wenhua, "文化"),
        ToolbarItem(R.drawable.icon_wenxue, "文物"),
        ToolbarItem(R.drawable.icon_yinle, "音乐"),
        ToolbarItem(R.drawable.icon_yishu, "艺术"),
        ToolbarItem(R.drawable.icon_yixue, "医学"),
        ToolbarItem(R.drawable.icon_zhengzhifalv, "政治法律"),
        ToolbarItem(R.drawable.icon_zhexuezongjiao, "哲学宗教"),
        ToolbarItem(R.drawable.icon_ziran, "自然")
    )

    private val bookRvData: List<BookItem> = listOf(
        BookItem(
            R.drawable.book1,
            "计算机组成原理(第3版)",
            "唐朔飞",
            "高等教育出版社",
            "35.00"
        ),
        BookItem(
            R.drawable.book2,
            "计算机网络教材",
            "谢希仁",
            "电子工业出版社",
            "45.00"
        ),
        BookItem(
            R.drawable.book3,
            "成事之道",
            "未知作者",
            "未知出版社",
            "00.00"
        ),
        BookItem(
            R.drawable.book4,
            "Python编程：从入门到实践",
            "未知作者",
            "人民邮电出版社",
            "109.80"
        ),
        BookItem(
            R.drawable.book5,
            "计算机科学导论",
            "贝赫鲁兹·佛罗赞(Behrouz A.Forouzan)",
            "机械工业出版社",
            "89.00"
        ),
        BookItem(
            R.drawable.book6,
            "计算机组成与设计硬件软件接口",
            "未知作者",
            "机械工业出版社",
            "169.00"
        ),
        BookItem(
            R.drawable.book7,
            "Java编程思想",
            "陈昊鹏",
            "人民邮电出版社",
            "100.00"
        ),
        BookItem(
            R.drawable.book8,
            "算法导论",
            "科曼",
            "机械工业出版社",
            "128.00"
        ),
        BookItem(
            R.drawable.book9,
            "人工智能",
            "Stuart J. Russell,Peter Norvig",
            "清华大学出版社",
            "00.00"
        ),
        BookItem(
            R.drawable.book10,
            "算法竞赛",
            "罗勇军，郭卫斌",
            "清华大学出版社",
            "168.00"
        ),
        BookItem(
            R.drawable.book11,
            "这就是ChatGPT",
            "斯蒂芬·沃尔弗拉姆",
            "人民邮电出版社",
            "59.00"
        ),
        BookItem(
            R.drawable.book12,
            "Python数据分析-从零基础入门到案例实战",
            "余本国",
            "北京理工大学出版社",
            "89.00"
        ),
        BookItem(
            R.drawable.book13,
            "深入理解高并发编程:JDK核心技术",
            "冰河",
            "电子工业出版社",
            "129.00"
        ),
        BookItem(
            R.drawable.book14,
            "算法图解+啊哈算法",
            "Aditya Bhargava 啊哈磊",
            "人民邮电出版社",
            "94.00"
        ),
        BookItem(
            R.drawable.book15,
            "Jetpack Compose 从入门到实战",
            "王鹏，关振智，曾思淇",
            "机械工业育出版社",
            "109.00"
        ),
        BookItem(
            R.drawable.book16,
            "Arduino 入门基础教程",
            "余静",
            "人民邮电出版社",
            "49.00"
        ),
        BookItem(
            R.drawable.book17,
            "Apache Pulsar实战",
            "戴维·克杰鲁姆加德",
            "人民邮电出版社",
            "109.80"
        ),
        BookItem(
            R.drawable.book18,
            "Python语言程序设计",
            "教育部考试中心",
            "高等教育出版社",
            "48.00"
        ),
        BookItem(
            R.drawable.book19,
            "C++ Primer Plus中文版第6版",
            "张海龙",
            "人民邮电出版社",
            "118.00"
        ),
        BookItem(
            R.drawable.book20,
            "Visual Studio Code 权威指南",
            "韩骏",
            "电子工业出版社",
            "99.00"
        )
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}