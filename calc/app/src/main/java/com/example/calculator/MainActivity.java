package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickAction(View view) {
        // ((Button) view).setText("test");

        TextView outText = (TextView) findViewById(R.id.outputText );
        switch (view.getId()) {
            case R.id.buttonNum1:
                outText.setText(outText.getText() + "1");
                break;
            case R.id.buttonNum2:
                outText.setText(outText.getText() + "2");
                break;
            case R.id.buttonActPlus:
                a = Integer.valueOf((String) outText.getText());
                outText.setText("");
                break;
            case R.id.buttonActEq:
                Integer b = Integer.valueOf((String) outText.getText());
                outText.setText(String.valueOf(a+b));
                break;
        }
        // outText.setText("test");
    }
}