package com.aloner.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aloner.R;
import com.aloner.object.Verb;
import com.aloner.service.VerbService;

public class AdminActivity extends ActionBarActivity implements View.OnClickListener
{
  Button save_verb_button;
  EditText infinitiveValue;
  EditText pastSimpleValue;
  EditText pastParticipleValue;
  EditText translateValue;

  VerbService verbService;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_admin);
    save_verb_button = (Button) findViewById(R.id.save_verb);
    save_verb_button.setOnClickListener(this);
  }

  @Override
  public void onClick(View view)
  {
    switch (view.getId())
    {
      case R.id.save_verb:
        saveVerbs();
        break;
      default:
        break;
    }
  }

  private void saveVerbs()
  {
    Verb verb = new Verb();
    infinitiveValue = (EditText) findViewById(R.id.admin_infinitive_value);
    pastSimpleValue = (EditText) findViewById(R.id.admin_past_simple_value);
    pastParticipleValue = (EditText) findViewById(R.id.admin_past_participle_value);
    translateValue = (EditText) findViewById(R.id.admin_translation_value);
    verb.setInfinitive(infinitiveValue.getText().toString());
    verb.setPastSimple(pastSimpleValue.getText().toString());
    verb.setPresentPerfect(pastParticipleValue.getText().toString());
    verb.setTranslation(translateValue.getText().toString());
    verbService = new VerbService(this);
    verbService.createVerb(verb);
    infinitiveValue.setText("");
    pastSimpleValue.setText("");
    pastParticipleValue.setText("");
    translateValue.setText("");

  }
}
