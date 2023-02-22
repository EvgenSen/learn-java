package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private enum ActionList {
        NOPE,
        PLUS,
        MINUS,
        MULTI,
        DIV
    }
    ActionList curAction = ActionList.NOPE;
    Integer buffer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView outText = (TextView) findViewById(R.id.outputText );

        Button b1 = (Button) findViewById(R.id.buttonNum1);
        b1.setOnClickListener(view -> {
            outText.setText(outText.getText() + "1");
        });

        Button b2 = (Button) findViewById(R.id.buttonNum2);
        b2.setOnClickListener(view -> {
            outText.setText(outText.getText() + "2");
        });

        Button b3 = (Button) findViewById(R.id.buttonNum3);
        b3.setOnClickListener(view -> {
            outText.setText(outText.getText() + "3");
        });

        Button b4 = (Button) findViewById(R.id.buttonNum4);
        b4.setOnClickListener(view -> {
            outText.setText(outText.getText() + "4");
        });

        Button b5 = (Button) findViewById(R.id.buttonNum5);
        b5.setOnClickListener(view -> {
            outText.setText(outText.getText() + "5");
        });

        Button b6 = (Button) findViewById(R.id.buttonNum6);
        b6.setOnClickListener(view -> {
            outText.setText(outText.getText() + "6");
        });

        Button b7 = (Button) findViewById(R.id.buttonNum7);
        b7.setOnClickListener(view -> {
            outText.setText(outText.getText() + "7");
        });

        Button b8 = (Button) findViewById(R.id.buttonNum8);
        b8.setOnClickListener(view -> {
            outText.setText(outText.getText() + "8");
        });

        Button b9 = (Button) findViewById(R.id.buttonNum9);
        b9.setOnClickListener(view -> {
            outText.setText(outText.getText() + "9");
        });

        Button b0 = (Button) findViewById(R.id.buttonNum0);
        b0.setOnClickListener(view -> {
            outText.setText(outText.getText() + "0");
        });

        Button actRM = (Button) findViewById(R.id.buttonActRM);
        actRM.setOnClickListener(view -> {
            String str = String.valueOf((String) outText.getText());
            if (str != null && str.length() > 0) {
                outText.setText(str.substring(0, str.length() - 1));
            }
        });

        Button actPlus = (Button) findViewById(R.id.buttonActPlus);
        actPlus.setOnClickListener(view -> {
            String str = String.valueOf((String) outText.getText());
            if (str != null && str.length() > 0) {
                curAction = ActionList.PLUS;
                buffer = Integer.valueOf(str);
                outText.setText("");
            }
        });

        Button actMinus = (Button) findViewById(R.id.buttonActMinus);
        actMinus.setOnClickListener(view -> {
            String str = String.valueOf((String) outText.getText());
            if (str != null && str.length() > 0) {
                curAction = ActionList.MINUS;
                buffer = Integer.valueOf(str);
                outText.setText("");
            }
        });

        Button actMulti = (Button) findViewById(R.id.buttonActMulti);
        actMulti.setOnClickListener(view -> {
            String str = String.valueOf((String) outText.getText());
            if (str != null && str.length() > 0) {
                curAction = ActionList.MULTI;
                buffer = Integer.valueOf(str);
                outText.setText("");
            }
        });

        Button actDiv = (Button) findViewById(R.id.buttonActDiv);
        actDiv.setOnClickListener(view -> {
            String str = String.valueOf((String) outText.getText());
            if (str != null && str.length() > 0) {
                curAction = ActionList.DIV;
                buffer = Integer.valueOf(str);
                outText.setText("");
            }
        });

        Button actEq = (Button) findViewById(R.id.buttonActEq);
        actEq.setOnClickListener(view -> {
            Integer buffer2 = Integer.valueOf((String) outText.getText());

            switch (curAction) {
                case PLUS:
                    buffer = buffer + buffer2;
                    outText.setText(String.valueOf(buffer));
                    break;
                case MINUS:
                    buffer = buffer - buffer2;
                    outText.setText(String.valueOf(buffer));
                    break;
                case MULTI:
                    buffer = buffer * buffer2;
                    outText.setText(String.valueOf(buffer));
                    break;
                case DIV:
                    buffer = buffer / buffer2;
                    outText.setText(String.valueOf(buffer));
                    break;
                default:
                    break;
            }

            curAction = ActionList.NOPE;
        });

    }

}