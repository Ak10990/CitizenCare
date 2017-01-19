package com.walmart.citizencare.flows.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.walmart.citizencare.R;
import com.walmart.citizencare.data.IssueMediaData;

import java.util.ArrayList;
import java.util.List;

public class IssueDetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_detail);

        initViews();
    }

    private void initViews() {
        List<IssueMediaData> list = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_media);
        recyclerView.setAdapter(new MediaAdapter(this, list));
    }
}
