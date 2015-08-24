package com.wuxiang.timershaft.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.wuxiang.timershaft.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Lizixuan on 2015/8/23.
 * 时钟+闹钟界面
 */
public class TimeDownFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static TimeDownFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        TimeDownFragment fragment = new TimeDownFragment();
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
        View view = inflater.inflate(R.layout.item, container, false);

        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 30; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "This is Title....." + mPage);
            map.put("ItemText", "This is text....." + mPage);
            mylist.add(map);
        }
        ListView listView = (ListView) view.findViewById(R.id.alarm_list);
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), //没什么解释
                mylist,//数据来源
                R.layout.my_listitem,//ListItem的XML实现

                //动态数组与ListItem对应的子项
                new String[]{"ItemTitle", "ItemText"},

                //ListItem的XML文件里面的两个TextView ID
                new int[]{R.id.ItemTitle, R.id.ItemText});
        listView.setAdapter(adapter);
        return view;
    }
}
