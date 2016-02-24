package com.teyang.huzhe.materialdrawertest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;

public class NavigationViewActivity extends AppCompatActivity {
  private TabFragmentPagerAdapter mTabFragmentPagerAdapter;
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.tab_layout) TabLayout mTabLayout;
  @Bind(R.id.view_pager) ViewPager mViewPager;
  @Bind(R.id.drawer_layout) DrawerLayout mDrawerLayout;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_navigation_view);
    ButterKnife.bind(this);
    setSupportActionBar(mToolbar);
    initDrawer();
    initViewPager();
  }

  private void initDrawer() {
    ActionBarDrawerToggle toggle =
        new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
    mDrawerLayout.setDrawerListener(toggle);
    toggle.syncState();
  }

  @Override public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  private void initViewPager() {
    mTabFragmentPagerAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager());
    mTabFragmentPagerAdapter.addTab(BlankFragment.newInstance(), getString(R.string.home_todo));
    mTabFragmentPagerAdapter.addTab(BlankFragment.newInstance(), getString(R.string.home_doing));
    mTabFragmentPagerAdapter.addTab(BlankFragment.newInstance(), getString(R.string.home_complete));
    mTabFragmentPagerAdapter.addTab(BlankFragment.newInstance(), getString(R.string.home_delay));
    mViewPager.setAdapter(mTabFragmentPagerAdapter);
    mViewPager.setOffscreenPageLimit(3);
    mTabLayout.setupWithViewPager(mViewPager);
  }
}
