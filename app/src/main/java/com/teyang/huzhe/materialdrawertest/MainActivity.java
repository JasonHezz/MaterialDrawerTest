package com.teyang.huzhe.materialdrawertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.material_drawer_btn) Button materialDrawerBtn;
  @Bind(R.id.navigation_view_btn) Button navigationViewBtn;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.navigation_view_btn)
  public void test1(){
    startActivity(new Intent(MainActivity.this, NavigationViewActivity.class));
  }

  @OnClick(R.id.material_drawer_btn)
  public void test2(){
    startActivity(new Intent(MainActivity.this, MaterialDrawerActivity.class));
  }
}
