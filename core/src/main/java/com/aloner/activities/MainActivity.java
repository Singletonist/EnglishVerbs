package com.aloner.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.aloner.core.R;

public class MainActivity extends ActionBarActivity implements View.OnClickListener
{
  Button start_button;
  Button admin_button;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    start_button = (Button) findViewById(R.id.start_button);
    admin_button = (Button) findViewById(R.id.admin_button);
    start_button.setOnClickListener(this);
    admin_button.setOnClickListener(this);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onClick(View view)
  {
    switch (view.getId())
    {
      case  R.id.start_button:
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        break;
      case R.id.admin_button:
        Intent intent2 = new Intent(this, AdminActivity.class);
        startActivity(intent2);
        break;
      default:
        break;
    }
  }
}
