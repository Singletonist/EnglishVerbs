package com.aloner.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aloner.core.R;
import com.aloner.object.Verb;
import com.aloner.service.VerbService;

public class AdminActivity extends ActionBarActivity implements View.OnClickListener
{
  Button add_to_db;
  EditText presentSimpleValue;
  EditText pastSimpleValue;
  EditText presentPerfectValue;
  EditText translateValue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_admin);
    add_to_db = (Button) findViewById(R.id.add_to_db);
    add_to_db.setOnClickListener(this);
  }

  @Override
  public void onClick(View view)
  {
    switch (view.getId())
    {
      case R.id.add_to_db:
        Verb verb = new Verb();
        presentSimpleValue = (EditText) findViewById(R.id.admin_present_simple_value);
        pastSimpleValue = (EditText) findViewById(R.id.admin_past_simple_value);
        presentPerfectValue = (EditText) findViewById(R.id.admin_present_perfect_value);
        translateValue = (EditText) findViewById(R.id.admin_translation_value);
        verb.setPresentSimple(presentSimpleValue.getText().toString());
        verb.setPastSimple(pastSimpleValue.getText().toString());
        verb.setPresentPerfect(presentPerfectValue.getText().toString());
        verb.setTranslation(translateValue.getText().toString());
        VerbService verbService = new VerbService(this);
        verbService.createVerb(verb);
        presentSimpleValue.setText("");
        pastSimpleValue.setText("");
        presentPerfectValue.setText("");
        translateValue.setText("");
        break;
      default:
        break;
    }
  }
}
