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

public class GridRvAdapter extends RecyclerView.Adapter<GridRvAdapter.GridRvViewHolder> {
    private final Context context;
    private final List<GridRvItem> data;

    public GridRvAdapter(Context context, List<GridRvItem> data) {
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
