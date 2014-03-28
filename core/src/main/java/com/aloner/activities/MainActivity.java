package com.aloner.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aloner.core.R;
import com.aloner.object.Item;
import com.aloner.service.ItemService;


public class MainActivity extends ActionBarActivity
{
  LinearLayout body;
  ItemService itemService = new ItemService(this);

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    body = (LinearLayout) findViewById(R.id.body);
    TextView tense = (TextView) findViewById(R.id.head_tense);
    Item item = new Item();
    item.setPresentSimple("go");
    item.setPastSimple("went");
    item.setPresentPerfect("gone");
    item.setTranslation("іти");
    itemService.createItem(item);
//    String presentSimple = itemService.createItem(item).getPresentSimple();
    item = itemService.getAllItems().get(0);
    TextView word = (TextView) findViewById(R.id.head_word);
    tense.setText("pastSimple");
    word.setText(item.getPresentSimple());

    TextView textView = new TextView(this);
    textView.setText(item.getTranslation());
    body.addView(textView);
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
    if (id == R.id.action_settings)
    {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
