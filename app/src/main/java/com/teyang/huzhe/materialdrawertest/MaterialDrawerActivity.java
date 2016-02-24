package com.teyang.huzhe.materialdrawertest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MaterialDrawerActivity extends AppCompatActivity {

  private TabFragmentPagerAdapter mTabFragmentPagerAdapter;

  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.tab_layout) TabLayout mTabLayout;
  @Bind(R.id.view_pager) ViewPager mViewPager;
  private Drawer mDrawer;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_material_drawer);
    ButterKnife.bind(this);
    setSupportActionBar(mToolbar);
    initDrawer(savedInstanceState);
    initViewPager();
  }

  private void initDrawer(Bundle savedInstanceState) {
    View headerView = LayoutInflater.from(this).inflate(R.layout.nav_header_navigation_view, null);
    mDrawer = new DrawerBuilder().withActivity(this)
        .withToolbar(mToolbar)
        .withFullscreen(true)
        .withHasStableIds(true)
        .withHeader(headerView)
        .addDrawerItems(new PrimaryDrawerItem().withName("something")
                .withIcon(R.drawable.ic_menu_camera)
                .withIdentifier(1), new PrimaryDrawerItem().withName("something")
                .withIcon(R.drawable.ic_menu_gallery)
                .withIdentifier(2), new PrimaryDrawerItem().withName("something")
                .withIcon(R.drawable.ic_menu_camera)
                .withIdentifier(3), new SectionDrawerItem().withName("something"),
            new ExpandableDrawerItem().withName("UI")
                .withIcon(R.drawable.ic_menu_camera)
                .withIdentifier(19)
                .withSubItems(new SecondaryDrawerItem().withName("something")
                    .withLevel(2)
                    .withIcon(R.drawable.ic_menu_send)
                    .withIdentifier(2000), new SecondaryDrawerItem().withName("something")
                    .withLevel(2)
                    .withIcon(R.drawable.ic_menu_send)
                    .withIdentifier(2001)), new ExpandableDrawerItem().withName("something")
                .withIcon(R.drawable.ic_menu_send)
                .withIdentifier(20)
                .withSubItems(new SecondaryDrawerItem().withName("something")
                    .withLevel(2)
                    .withIcon(R.drawable.ic_menu_send)
                    .withIdentifier(2003), new SecondaryDrawerItem().withName("something")
                    .withLevel(2)
                    .withIcon(R.drawable.ic_menu_send)
                    .withIdentifier(2004)
                    .withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE)
                        .withColorRes(R.color.md_red_700))
                    .withBadge("10")))
        .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
          @Override public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
            if (drawerItem != null) {
              Intent intent = null;
              if (((IExpandable) drawerItem).getSubItems() != null) {
                mDrawer.getAdapter().toggleExpandable(position);
                //we consume the event and want no further handling
                return true;
              }
              if (intent != null) {

              }
            }
            return false;
          }
        })

        .withSavedInstance(savedInstanceState)
        .withShowDrawerOnFirstLaunch(true)
        .build();
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
