package com.wuxiang.timershaft.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.wuxiang.timershaft.R;
import com.wuxiang.timershaft.adapter.AlarmRecyclerAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Lizixuan on 2015/8/23.
 * 时钟+闹钟界面
 */
public class AlarmFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static AlarmFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        AlarmFragment fragment = new AlarmFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alarm_fragment_layout, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.alarm_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new AlarmRecyclerAdapter());

        return view;
    }
}
