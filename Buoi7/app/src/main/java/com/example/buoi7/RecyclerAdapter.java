package com.example.buoi7;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    private MainActivity context;
    private List<Note> list;
    private DataSQLite dataSQLite;

    public RecyAdapter(MainActivity context, List<Note> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        position = holder.getAdapterPosition();
        final Note note = list.get(position);
        holder.content.setText(list.get(position).getContent());

        holder.delete.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            builder.setTitle("Xác nhận");
            builder.setMessage("Bạn có chắc chắn muốn xóa note có id = " + note.getId() + "?");
            builder.setIcon(android.R.drawable.ic_delete);
            builder.setCancelable(false);
            builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dataSQLite = new DataSQLite(context);
                    dataSQLite.deleteNote(note.getId());
                    context.getData();
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                }
            }).setNegativeButton("Hủy", null);
            builder.show();

        });

    }

    @Override
    public int getItemCount() {
        return list.isEmpty()?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView content;
        ImageView delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.content);
            delete = itemView.findViewById(R.id.delete);
        }
    }

}