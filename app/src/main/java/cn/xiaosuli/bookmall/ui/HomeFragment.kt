package cn.xiaosuli.bookmall.ui

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
                    outRect.left = 10
                    outRect.right = 10
                    outRect.bottom = 20
                }
            })
            adapter = BookRvAdapter(activity, BookItem.getBookList())
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}