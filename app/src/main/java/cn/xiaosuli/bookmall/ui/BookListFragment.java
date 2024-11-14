package cn.xiaosuli.bookmall.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import cn.xiaosuli.bookmall.R;
import cn.xiaosuli.bookmall.adapter.BookLvAdapter;
import cn.xiaosuli.bookmall.databinding.FragmentBookListBinding;
import cn.xiaosuli.bookmall.model.BookItem;

public class BookListFragment extends Fragment {

    private FragmentBookListBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentBookListBinding.inflate(inflater, container, false);

        BookLvAdapter adapter = new BookLvAdapter(BookItem.getBookList(), getActivity());
        binding.bookList.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}