package com.example.michaelcs.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Create by MichaelCS on 2018/8/9 12:31
 * Email: junhong@turingpic.com
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private Context mContext;
    private List<Book> mBookList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView bookImage;
        TextView bookname;
        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            bookImage = (ImageView)view.findViewById(R.id.book_image);
            bookname = (TextView)view.findViewById(R.id.book_name);
        }
    }

    public BookAdapter(List<Book> bookList){
        mBookList = bookList;
    }

    /**
     * 获取“上下文”，获取RecycleView子布局的最外层布局这里是指CardView
     * 将book_item布局加载到父布局（CardView）中
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.book_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Book book = mBookList.get(position);
                Intent intent = new Intent(mContext,BookDetailActivity.class);
                intent.putExtra(BookDetailActivity.BOOK_NAME,book.getName());
                intent.putExtra(BookDetailActivity.BOOK_IMAGE_ID,book.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    /**
     * 对RecycleView的子项的数据进行赋值
     * 在每个子项滑到屏幕内时执行
     * 通过position参数得到当前项的Book类实例
     * 调用Glide.with()方法传入一个Context,Activity或者Fragment参数
     * 然后调用load()方法将图片设置到一个具体的ImageView中
     * @param holder
     * @param position
     */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = mBookList.get(position);
        holder.bookname.setText(book.getName());
        Glide.with(mContext).load(book.getImageId()).into(holder.bookImage);
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }
}
