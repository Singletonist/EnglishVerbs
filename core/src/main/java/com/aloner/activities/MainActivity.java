package com.aloner.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.aloner.R;

public class MainActivity extends ActionBarActivity implements View.OnClickListener
{
  Button start_button;
  Button admin_button;
  Button setting_button;
  Button info_button;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    start_button = (Button) findViewById(R.id.start_button);
    admin_button = (Button) findViewById(R.id.admin_button);
    setting_button = (Button) findViewById(R.id.setting_button);
    info_button = (Button) findViewById(R.id.info_button);
    start_button.setOnClickListener(this);
    admin_button.setOnClickListener(this);
    setting_button.setOnClickListener(this);
    info_button.setOnClickListener(this);
  }

  @Override
  public void onClick(View view)
  {
    Intent intent;
    switch (view.getId())
    {
      case  R.id.start_button:
        intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        break;
      case R.id.admin_button:
        intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
        break;
      case  R.id.setting_button:
        intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
        break;
      case R.id.info_button:
        intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
        break;
      default:
        break;
    }
  }
}
