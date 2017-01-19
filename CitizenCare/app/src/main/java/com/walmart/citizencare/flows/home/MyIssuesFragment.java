package com.walmart.citizencare.flows.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.walmart.citizencare.Constants;

import com.walmart.citizencare.R;
import com.walmart.citizencare.data.IssuesView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akanksha on 13/11/16.
 */
public class MyIssuesFragment extends Fragment {

    private List<IssuesView> list = new ArrayList<>();
    private boolean isData;

    static MyIssuesFragment getInstance(ArrayList<IssuesView> list) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Constants.ISSUES_VIEW_LIST, list);
        MyIssuesFragment fragment = new MyIssuesFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initValues();
    }

    private void initValues() {
        if (getArguments() != null && getArguments().getParcelableArrayList(Constants.ISSUES_VIEW_LIST) != null) {
            list = getArguments().getParcelableArrayList(Constants.ISSUES_VIEW_LIST);
        }
        isData = list != null && list.size() > 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout;
        if (isData) {
            layout = R.layout.fragment_list;
        } else {
            layout = R.layout.fragment_nolayout;
        }
        View view = inflater.inflate(layout, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        if (isData) {
            RecyclerView listview = (RecyclerView) view.findViewById(R.id.home_list);

            listview.setAdapter(new MyWallAdapter(getActivity(), list));
        } else {
        }

    }
}
