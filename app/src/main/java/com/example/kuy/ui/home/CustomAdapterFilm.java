package com.example.kuy.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kuy.R;

import java.util.List;

public class CustomAdapterFilm extends RecyclerView.Adapter<CustomAdapterFilm.MyViewHolder> {
    List<Model> my_list;
    Context context;

    public CustomAdapterFilm(List<Model> my_list, Context context){
        this.my_list = my_list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Model model=my_list.get(i);
        myViewHolder.desc.setText(model.getDesc());
        myViewHolder.name.setText(model.getName());
        myViewHolder.image.setImageDrawable(context.getResources().getDrawable(model.getImage()));
        myViewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("image",model.getImage());
                intent.putExtra("name",model.getName());
                intent.putExtra("title",model.getTitle());
                intent.putExtra("desc",model.getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return my_list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name,desc;
        RelativeLayout parent_layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.name);
            desc=itemView.findViewById(R.id.desc);
            parent_layout=itemView.findViewById(R.id.parent_layout);

        }
    }
}
