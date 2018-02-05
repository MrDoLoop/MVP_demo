package www.doloop.com.mvp_demo.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import www.doloop.com.mvp_demo.R;
import www.doloop.com.mvp_demo.bean.Book;
import zlc.season.practicalrecyclerview.AbstractViewHolder;

/**
 * Created by ZHAO_NAN on 2018/1/3.
 */

public class NormalViewHolder extends AbstractViewHolder<Book.BooksBean> {


    private TextView mTextView;
    private Context mContext;

    NormalViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_layout);
        mContext = parent.getContext();
        mTextView = (TextView) itemView.findViewById(R.id.text);
    }

    @Override
    public void setData(Book.BooksBean data) {
        mTextView.setText(getAdapterPosition() +"-->" +data.getTitle()+"--->"+data.getId());
    }
}
