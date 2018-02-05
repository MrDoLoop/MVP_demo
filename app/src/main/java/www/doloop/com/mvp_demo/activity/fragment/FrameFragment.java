package www.doloop.com.mvp_demo.activity.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.doloop.com.mvp_demo.R;
import www.doloop.com.mvp_demo.adapter.SingleItemAdapter;
import www.doloop.com.mvp_demo.bean.Book;
import www.doloop.com.mvp_demo_frame.BaseFragment;
import zlc.season.practicalrecyclerview.ConfigureAdapter;
import zlc.season.practicalrecyclerview.PracticalRecyclerView;

/**
 * Created by ZHAO_NAN on 2018/2/3.
 */

public class FrameFragment extends BaseFragment<FragmentPresenter, FragmentView> implements FragmentView {

    public static FrameFragment newInstance() {
        FrameFragment fragment = new FrameFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ProgressDialog mProgressDialog;
    SingleItemAdapter mAdapter;
    PracticalRecyclerView mPracticalRecyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setTitle("正在加载数据");
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container,false);
        mPracticalRecyclerView = (PracticalRecyclerView) rootView.findViewById(R.id.recycler);
        mAdapter = new SingleItemAdapter();
        mPracticalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mPracticalRecyclerView.setAdapterWithLoading(mAdapter);
        mPracticalRecyclerView.setRefreshListener(new PracticalRecyclerView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.refreshData();
            }
        });
        mPracticalRecyclerView.setLoadMoreListener(new PracticalRecyclerView.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mPresenter.refreshData();
            }
        });

        mPracticalRecyclerView.configureView(new ConfigureAdapter() {
            @Override
            public void configureLoadMoreFailedView(View loadMoreFailedView) {
                super.configureLoadMoreFailedView(loadMoreFailedView);
                loadMoreFailedView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(SingleItemActivity.this, "点击LoadMoreFailedView时应该进行的操作", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void configureErrorView(View errorView) {
                super.configureErrorView(errorView);
                //errorView.dosomething();
            }
        });

        mPresenter.refreshData();
        return rootView;
    }
    
    @Override
    protected FragmentPresenter getPresenter() {
        return new FragmentPresenter();
    }


    @Override
    public void showLoading(boolean show) {
        if(show) {
            mProgressDialog.show();
        } else {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showData(Book data) {
        mAdapter.addAll(data.getBooks());
        //mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
    }
}
