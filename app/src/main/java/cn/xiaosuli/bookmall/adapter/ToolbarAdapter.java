package cn.xiaosuli.bookmall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.xiaosuli.bookmall.R;
import cn.xiaosuli.bookmall.model.ToolbarItem;

public class ToolbarAdapter extends RecyclerView.Adapter<ToolbarAdapter.GridRvViewHolder> {
    private final Context context;
    private final List<ToolbarItem> data;

    public ToolbarAdapter(Context context, List<ToolbarItem> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public GridRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_rv_item, parent, false);
        return new GridRvViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull GridRvViewHolder holder, int position) {
        holder.image.setImageResource(data.get(position).getImage());
        holder.text.setText(data.get(position).getText());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class GridRvViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView image;
        AppCompatTextView text;

        public GridRvViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.grid_rv_item_image);
            text = itemView.findViewById(R.id.grid_rv_item_text);
        }
    }
}
