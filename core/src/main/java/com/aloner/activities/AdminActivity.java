package com.aloner.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aloner.core.R;
import com.aloner.object.Item;
import com.aloner.service.ItemService;

public class AdminActivity extends ActionBarActivity implements View.OnClickListener
{
  Button add_to_db;
  EditText presentSimpleValue;
  EditText pastSimpleValue;
  EditText presentPerfectValue;
  EditText translateValue;
  ItemService itemService = new ItemService(this);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_admin);
    add_to_db = (Button) findViewById(R.id.add_to_db);
    add_to_db.setOnClickListener(this);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.admin, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
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
      case R.id.add_to_db:
        Item item = new Item();
        presentSimpleValue = (EditText) findViewById(R.id.admin_present_simple_value);
        pastSimpleValue = (EditText) findViewById(R.id.admin_past_simple_value);
        presentPerfectValue = (EditText) findViewById(R.id.admin_present_perfect_value);
        translateValue = (EditText) findViewById(R.id.admin_translation_value);
        item.setPresentSimple(presentSimpleValue.getText().toString());
        item.setPastSimple(pastSimpleValue.getText().toString());
        item.setPresentPerfect(presentPerfectValue.getText().toString());
        item.setTranslation(translateValue.getText().toString());
        itemService.createItem(item);
        presentSimpleValue.setText("");
        pastSimpleValue.setText("");
        presentPerfectValue.setText("");
        translateValue.setText("");
        break;
    }
  }
}
