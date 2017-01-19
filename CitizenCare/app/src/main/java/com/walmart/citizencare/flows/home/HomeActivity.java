package com.walmart.citizencare.flows.home;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.walmart.citizencare.R;
import com.walmart.citizencare.data.IssuesView;
import com.walmart.citizencare.data.Types;
import com.walmart.citizencare.flows.createnew.CreateIssueActivity;
import com.walmart.citizencare.flows.createnew.RegisterActivity;
import com.walmart.citizencare.flows.createnew.SettingsActivity;

import java.util.ArrayList;
import java.util.Date;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int WALL = 0;
    private static final int TASK = 1;
    private static final int WATCH = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
    }

    private void initViews() {
        ViewPager mainViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(mainViewPager);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mainViewPager);

        TextView btnCreateTask = (TextView) findViewById(R.id.btn_create_issue);
        btnCreateTask.setOnClickListener(this);
        TextView btnRegister = (TextView) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);
    }

    private void setupViewPager(final ViewPager viewPager) {
        ViewPagerAdapter profileTabAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        ArrayList<IssuesView> issuesList = getIssues();
        profileTabAdapter.addFragment(MyWallFragment.getInstance(issuesList), getString(R.string.my_wall));
        profileTabAdapter.addFragment(MyIssuesFragment.getInstance(issuesList), getString(R.string.my_tasks));
        profileTabAdapter.addFragment(MyWatchFragment.getInstance(issuesList), getString(R.string.my_watch));
        viewPager.setAdapter(profileTabAdapter);
        viewPager.setOffscreenPageLimit(1);
    }

    private ArrayList<IssuesView> getIssues() {
        ArrayList<IssuesView> issuesViewArrayList = new ArrayList<>();
        issuesViewArrayList.add(new IssuesView("Title", new Date().toString(),
                "Indranagar 1st main", "Description", Types.GARBAGE, 8, 3, 4));
        issuesViewArrayList.add(new IssuesView("Title", new Date().toString(),
                "Indranagar 2nd main", "Description", Types.FOOD_WASTE, 2, 5, 4));
        issuesViewArrayList.add(new IssuesView("Title", new Date().toString(),
                "Indranagar 3rd main", "Description", Types.UNCLOSED_TANKS, 2, 3, 7));
        issuesViewArrayList.add(new IssuesView("Title", new Date().toString(),
                "Indranagar 4th main", "Description", Types.ELECTRICITY, 1, 3, 4));
        issuesViewArrayList.add(new IssuesView("Title", new Date().toString(),
                "Marathalli", "Description", Types.DIRTY_WATER, 2, 3, 0));
        issuesViewArrayList.add(new IssuesView("Title", new Date().toString(),
                "Murugeshpalya", "Description", Types.VEHICLE, 2, 7, 4));
        issuesViewArrayList.add(new IssuesView("Title", new Date().toString(),
                "Jaynagar", "Description", Types.ANIMALS, 9, 3, 4));
        issuesViewArrayList.add(new IssuesView("Title", new Date().toString(),
                "Yeshwantpura", "Description", Types.UNCLOSED_TANKS, 2, 3, 90));
        return issuesViewArrayList;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        //Issues/area/remove
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.action_settings:
                Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_create_issue: {
                Intent intent = new Intent(HomeActivity.this, CreateIssueActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btn_register: {
                Intent intent = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}
