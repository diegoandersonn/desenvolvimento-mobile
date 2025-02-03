package com.example.ddm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context mContext;
    int mResource;
    List<Planeta> mListPlaneta;
    public RecyclerViewAdapter(Context context, int resource, List<Planeta> objs){
        mContext=context;
        mResource=resource;
        mListPlaneta=objs;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imageView;
        public ViewHolder(View view) {
            super(view);
            tvTitle = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.image);
        }
    }
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(mContext, mResource, null);
        return new ViewHolder(v);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Planeta p = (Planeta) mListPlaneta.get(position);
        holder.imageView.setImageResource(p.foto);
        holder.tvTitle.setText(p.nome);
    }

    public int getItemCount() {
        return mListPlaneta.size();
    }
}
