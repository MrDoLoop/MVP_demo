package www.doloop.com.mvp_demo.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import www.doloop.com.mvp_demo.R;

/**
 * Created by zhaonan on 18/2/5.
 */

public class FragmentListAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<String> dataList = new ArrayList<>();


    public void addAllData(List<String> dataList) {
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public void clearData() {
        this.dataList.clear();
    }

    public FragmentListAdapter(Context context) {
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
//        return new ViewHolder(v);
//    }
//
//
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.title.setText(dataList.get(position));
//    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


//    private List<Book.BooksBean> mData;
//    private Context mContext;
//
//    //private OnItemClickListener<Image> mOnItemClickListener;
//
//    public FragmentListAdapter() {
//        mData = new ArrayList<>();
//    }
//
////    public void setOnItemClickListener(OnItemClickListener<Image> listener) {
////        this.mOnItemClickListener = listener;
////    }
//
//    public void setList(List<Book.BooksBean> images) {
//        mData.clear();
//        append(images);
//    }
//
//    public void append(List<Book.BooksBean>  images) {
//        int positionStart = mData.size();
//        int itemCount = images.size();
//        mData.addAll(images);
//        if (positionStart > 0 && itemCount > 0) {
//            notifyItemRangeInserted(positionStart, itemCount);
//        } else {
//            notifyDataSetChanged();
//        }
//    }
//
//    public void remove(int position) {
//        mData.remove(position);
//        notifyItemRemoved(position);
//    }
//
//    public void clear(){
//        mData.clear();
//        notifyDataSetChanged();
//    }
//
////    @Override
////    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
////        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
////
////        final ViewHolder holder = new ViewHolder(view);
//////        imageView.setOnClickListener(new View.OnClickListener() {
//////            @Override
//////            public void onClick(View v) {
//////                /**
//////                 * Note:
//////                 * in order to get the right position, you must use the method with i- prefix in
//////                 * {@link IViewHolder} eg:
//////                 * {@code IViewHolder.getIPosition()}
//////                 * {@code IViewHolder.getILayoutPosition()}
//////                 * {@code IViewHolder.getIAdapterPosition()}
//////                 */
//////                final int position = holder.getIAdapterPosition();
//////                final Image image = mImages.get(position);
//////                if (mOnItemClickListener != null) {
//////                    mOnItemClickListener.onItemClick(position, image, v);
//////                }
//////            }
//////        });
////        return holder;
////    }
//
//    @Override
//    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
//
//    }
//
//
////    @Override
////    public void onBindViewHolder(IViewHolder holder, int position) {
////        ViewHolder viewHolder = (ViewHolder) holder;
////        Book.BooksBean booksBean = mData.get(position);
////        Glide.with(holder.itemView.getContext()).load(booksBean.getImage()).dontAnimate().into(viewHolder.imageView);
////        viewHolder.textView.setText(booksBean.getTitle());
////    }
//
//
//
////    static class ViewHolder extends IViewHolder {
////        public TextView textView;
////        public ImageView imageView;
////        public ViewHolder(View itemView) {
////            super(itemView);
////            textView = (TextView) itemView.findViewById(R.id.text);
////            imageView = (ImageView) itemView.findViewById(R.id.img);
////        }
////    }
//
////    private Context mContext;
////    private List<String> dataList = new ArrayList<>();
//
//
////    public void addAllData(List<String> dataList) {
////        this.dataList.addAll(dataList);
////        notifyDataSetChanged();
////    }
//
////    public void clearData() {
////        this.dataList.clear();
////    }
//
//    public FragmentListAdapter(Context context) {
//        mContext = context;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView title;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            title = (TextView) itemView.findViewById(R.id.title);
//        }
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
//        return new ViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.title.setText(mData.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mData.size();
//    }
//
//
//


}
