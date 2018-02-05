package www.doloop.com.mvp_demo.adapter;

import android.view.ViewGroup;

import www.doloop.com.mvp_demo.bean.Book;
import zlc.season.practicalrecyclerview.AbstractAdapter;

/**
 * Created by ZHAO_NAN on 2018/1/3.
 */

public class SingleItemAdapter extends AbstractAdapter<Book.BooksBean, NormalViewHolder> {

    @Override
    protected NormalViewHolder onNewCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalViewHolder(parent);
    }

    @Override
    protected void onNewBindViewHolder(NormalViewHolder holder, int position) {
        holder.setData(get(position));
    }
}
