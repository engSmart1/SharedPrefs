package com.example.hytham.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView showTextView;
    private Button mButton;
    private EditText mEditText;
    private static final String PREFS_NAME = "MyPrefsName";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTextView = (TextView) findViewById(R.id.showMeTextView);
        mButton = (Button)findViewById(R.id.saveButton);
        mEditText =(EditText)findViewById(R.id.nameEditText);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (mEditText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter The Name ..", Toast.LENGTH_LONG).show();

                } else {
                    editor.putString("name", mEditText.getText().toString());
                    editor.commit();
                }

            }
        });
        //get back data!
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME , 0);
        if (preferences.contains("name")){
            String userName = preferences.getString("name" , "not found");
            showTextView.setText("Your name :" + userName);
        }else {
            showTextView.setText("");
        }

    }
}
