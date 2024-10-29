package cn.xiaosuli.firstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookRvAdapter extends RecyclerView.Adapter<BookRvAdapter.GridRvViewHolder> {
    private final Context context;
    private final List<BookRvItem> data;

    public BookRvAdapter(Context context, List<BookRvItem> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public GridRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_rv_item, parent, false);
        return new GridRvViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull GridRvViewHolder holder, int position) {
        holder.bookCover.setImageResource(data.get(position).getCover());
        holder.bookName.setText(data.get(position).getBookName());
        holder.bookAuthor.setText(data.get(position).getAuthor());
        holder.publishingHouse.setText(data.get(position).getPublishingHouse());
        holder.bookPrice.setText(data.get(position).getPrice());
    }
    
    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class GridRvViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView bookCover;
        AppCompatTextView bookName;
        AppCompatTextView bookAuthor;
        AppCompatTextView publishingHouse;
        AppCompatTextView bookPrice;

        public GridRvViewHolder(@NonNull View itemView) {
            super(itemView);
            bookCover = itemView.findViewById(R.id.book_rv_item_book_cover);
            bookName = itemView.findViewById(R.id.book_rv_item_book_name);
            bookAuthor = itemView.findViewById(R.id.book_rv_item_book_author);
            publishingHouse = itemView.findViewById(R.id.book_rv_item_publishing_house);
            bookPrice = itemView.findViewById(R.id.book_rv_item_book_price);
        }
    }
}
