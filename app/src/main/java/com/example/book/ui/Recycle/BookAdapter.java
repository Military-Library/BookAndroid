package com.example.book.ui.Recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.R;
import com.example.book.ui.Network.ImageLoadTask;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    Context context;

    ArrayList<BookItem> items = new ArrayList<BookItem>();
 OnItemClickListener listener;
 public static interface OnItemClickListener{
     public void onItemClick(ViewHolder holder, View view, int position);
 }
    public BookAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    @NonNull
    @NotNull
    @Override// view홀더가 만들어지는 시점, parent 최상위 레이아웃
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View itemView = inflater.inflate(R.layout.bookitem,parent,false);
       return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        BookItem item = items.get(position);
        holder.setItem(item);

        holder.setOnItemClickListener(listener);
    }
    public void addItem(BookItem item){
        items.add(item);
    }
    public void addItems(ArrayList<BookItem> items){
        this.items = items;
    }
    public BookItem getItem(int position){
        return items.get(position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView bookName;
        OnItemClickListener listener;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.bookImage);
            bookName = (TextView) itemView.findViewById(R.id.bookName);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }
        public void setItem(BookItem item){
            bookName.setText(item.getBookName());
            sendImageRequest(item.getImageViewUrl());
        }
        public void sendImageRequest(String Url){
            String url = Url;
            ImageLoadTask task = new ImageLoadTask(url, imageView);
            task.execute();
        }
        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }

    }

}
