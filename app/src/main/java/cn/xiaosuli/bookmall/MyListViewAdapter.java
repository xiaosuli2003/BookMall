//package cn.xiaosuli.bookmall;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.widget.AppCompatImageView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class MyListViewAdapter extends BaseAdapter {
//    private final List<Book> data;
//    private final Context context;
//
//    public MyListViewAdapter(List<Book> data, Context context) {
//        this.data = data;
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return data.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return data.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        MyListViewHolder viewHolder;
//        View view;
//
//        if (convertView == null) {
//            // 如果没有可复用的视图，则创建新的视图和ViewHolder
//            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
//            viewHolder = new MyListViewHolder(view);
//            view.setTag(viewHolder);
//        } else {
//            // 否则，复用已有的视图和ViewHolder
//            view = convertView;
//            viewHolder = (MyListViewHolder) view.getTag();
//        }
//
//        // 绑定数据到视图
//        viewHolder.cover.setImageResource(data.get(position).getCover());
//        viewHolder.bookName.setText(data.get(position).getBookName());
//        viewHolder.author.setText(data.get(position).getAuthor());
//        viewHolder.publishingHouse.setText(data.get(position).getPublishingHouse());
//        viewHolder.price.setText(data.get(position).getPrice());
//
//        return view;
//    }
//
//    private static class MyListViewHolder extends RecyclerView.ViewHolder{
//        AppCompatImageView cover;
//        TextView bookName;
//        TextView author;
//        TextView publishingHouse;
//        TextView price;
//
//        public MyListViewHolder(@NonNull View itemView) {
//            super(itemView);
//            cover = itemView.findViewById(R.id.book_cover);
//            bookName = itemView.findViewById(R.id.book_name);
//            author = itemView.findViewById(R.id.book_author);
//            publishingHouse = itemView.findViewById(R.id.publishing_house);
//            price = itemView.findViewById(R.id.book_price);
//        }
//    }
//}
