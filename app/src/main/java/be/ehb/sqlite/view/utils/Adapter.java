package be.ehb.sqlite.view.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import be.ehb.sqlite.R;
import be.ehb.sqlite.model.DatabaseTable;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvColor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_row_name);
            tvColor = itemView.findViewById(R.id.tv_row_color);
        }
    }

    private ArrayList<DatabaseTable> items;

    public Adapter() {
        this.items = new ArrayList<DatabaseTable>();
    }

    public void addItems(List<DatabaseTable> newItems){
        this.items = new ArrayList<DatabaseTable>();
        this.items.addAll(newItems);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DatabaseTable currentItem = items.get(position);
        holder.tvName.setText(currentItem.getNaam());
        holder.tvColor.setText(currentItem.getKleur());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
