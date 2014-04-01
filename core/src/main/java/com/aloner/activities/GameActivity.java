package com.aloner.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aloner.core.R;
import com.aloner.object.Verb;
import com.aloner.service.VerbService;


public class GameActivity extends ActionBarActivity
{
  LinearLayout body;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    body = (LinearLayout) findViewById(R.id.body);
    TextView tense = (TextView) findViewById(R.id.head_tense);
    VerbService verbService = new VerbService(this);
    Verb verb = verbService.getAllVerbs().get(0);
    TextView word = (TextView) findViewById(R.id.head_word);
    tense.setText("pastSimple");
    word.setText(verb.getPresentSimple());

    TextView textView = new TextView(this);
    textView.setText(verb.getTranslation());
    body.addView(textView);
    View.OnClickListener listener = new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        setContentView(R.layout.activity_admin);
      }
    };
    textView.setOnClickListener(listener);
  }
}
