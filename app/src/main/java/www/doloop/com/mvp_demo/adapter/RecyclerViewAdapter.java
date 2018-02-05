package www.doloop.com.mvp_demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import www.doloop.com.mvp_demo.R;
import www.doloop.com.mvp_demo.bean.Book;

/**
 * Created by zhaonan on 18/2/5.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Book.BooksBean> mData = new ArrayList<>();
    private Context mContext;

    public void setList(List<Book.BooksBean> images) {
        mData.clear();
        append(images);
    }

    public void append(List<Book.BooksBean>  images) {
        int positionStart = mData.size();
        int itemCount = images.size();
        mData.addAll(images);
        if (positionStart > 0 && itemCount > 0) {
            notifyItemRangeInserted(positionStart, itemCount);
        } else {
            notifyDataSetChanged();
        }
    }


    public void remove(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

    public void clear(){
        mData.clear();
        notifyDataSetChanged();
    }

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Book.BooksBean booksBean = mData.get(position);
        holder.title.setText(mData.get(position).getTitle());
        Glide.with(holder.itemView.getContext()).load(booksBean.getImage()).dontAnimate().into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.text);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }

}
