package com.aloner.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aloner.R;
import com.aloner.object.Verb;
import com.aloner.service.VerbService;


public class GameActivity extends ActionBarActivity implements View.OnClickListener
{
  LinearLayout body;
  VerbService verbService;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    body = (LinearLayout) findViewById(R.id.body);
    TextView tense = (TextView) findViewById(R.id.head_tense);
    verbService = new VerbService(this);
    Verb verb = verbService.getAllVerbs().get(0);
    TextView word = (TextView) findViewById(R.id.head_word);
    tense.setText("pastSimple");
    word.setText(verb.getInfinitive());

    Button variant = new Button(this);
    variant.setText(verb.getTranslation());
    body.addView(variant);
    variant.setOnClickListener(this);
  }

  @Override
  public void onClick(View view)
  {

  }
}
