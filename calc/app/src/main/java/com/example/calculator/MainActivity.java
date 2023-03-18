package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.content.res.ColorStateList;

public class MainActivity extends AppCompatActivity {

    private enum ActionList {
        NOPE,
        PLUS,
        MINUS,
        MULTI,
        DIV
    }
    ActionList curAction = ActionList.NOPE;
    Double firstNumber = 0.0;

    private void addCharToScreen(String Ch) {
        TextView outText = (TextView) findViewById(R.id.outputText );
        String str = String.valueOf((String) outText.getText());

        switch (Ch) {
            case ".":
                if(str.indexOf(".") > 0) {
                    return;
                }
                if(str.length() == 0) {
                    outText.setText("0");
                }
                break;
            case "0":
                if(str.length() == 1 && str.charAt(0) == '0') {
                    return;
                }
                break;
            default:
                break;
        }

        outText.setText(outText.getText() + Ch);
        // outText.append(Ch); // TODO
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView outText = (TextView) findViewById(R.id.outputText);
        TextView topText = (TextView) findViewById(R.id.topText);
        ColorStateList defColors = topText.getTextColors();

        Button b1 = (Button) findViewById(R.id.buttonNum1);
        b1.setOnClickListener(view -> {
            this.addCharToScreen("1");
        });

        Button b2 = (Button) findViewById(R.id.buttonNum2);
        b2.setOnClickListener(view -> {
            this.addCharToScreen("2");
        });

        Button b3 = (Button) findViewById(R.id.buttonNum3);
        b3.setOnClickListener(view -> {
            this.addCharToScreen("3");
        });

        Button b4 = (Button) findViewById(R.id.buttonNum4);
        b4.setOnClickListener(view -> {
            this.addCharToScreen("4");
        });

        Button b5 = (Button) findViewById(R.id.buttonNum5);
        b5.setOnClickListener(view -> {
            this.addCharToScreen("5");
        });

        Button b6 = (Button) findViewById(R.id.buttonNum6);
        b6.setOnClickListener(view -> {
            this.addCharToScreen("6");
        });

        Button b7 = (Button) findViewById(R.id.buttonNum7);
        b7.setOnClickListener(view -> {
            this.addCharToScreen("7");
        });

        Button b8 = (Button) findViewById(R.id.buttonNum8);
        b8.setOnClickListener(view -> {
            this.addCharToScreen("8");
        });

        Button b9 = (Button) findViewById(R.id.buttonNum9);
        b9.setOnClickListener(view -> {
            this.addCharToScreen("9");
        });

        Button b0 = (Button) findViewById(R.id.buttonNum0);
        b0.setOnClickListener(view -> {
            this.addCharToScreen("0");
        });

        Button actDot = (Button) findViewById(R.id.buttonActDot);
        actDot.setOnClickListener(view -> {
            this.addCharToScreen(".");
        });

        Button actClean = (Button) findViewById(R.id.buttonActClean);
        actClean.setOnClickListener(view -> {
            String str = String.valueOf((String) outText.getText());
            if (str != null && str.length() > 0) {
                outText.setText(str.substring(0, str.length() - 1));
            }
        });

        Button actCleanAll = (Button) findViewById(R.id.buttonActCleanAll);
        actCleanAll.setOnClickListener(view -> {
            outText.setText("");
            topText.setText("");
            topText.setTextColor(defColors);
            firstNumber = 0.0;
            curAction = ActionList.NOPE;
        });

        Button actPercent = (Button) findViewById(R.id.buttonActPercent);
        actPercent.setOnClickListener(view -> {
            String str = String.valueOf((String) outText.getText());
            if (str != null && str.length() > 0) {
                curAction = ActionList.NOPE;
                firstNumber = Double.valueOf(str) / 100.0;
                topText.setText(str + "% = ");
                topText.setTextColor(defColors);
                outText.setText(String.valueOf(firstNumber));
            }
        });

        Button actPlus = (Button) findViewById(R.id.buttonActPlus);
        actPlus.setOnClickListener(view -> {
            String str = String.valueOf((String) outText.getText());
            if (str != null && str.length() > 0) {
                curAction = ActionList.PLUS;
                firstNumber = Double.valueOf(str);
                topText.setText(str + " + ");
                topText.setTextColor(defColors);
                outText.setText("");
            }
        });

        Button actMinus = (Button) findViewById(R.id.buttonActMinus);
        actMinus.setOnClickListener(view -> {
            String str = String.valueOf((String) outText.getText());
            if (str != null && str.length() > 0) {
                curAction = ActionList.MINUS;
                firstNumber = Double.valueOf(str);
                topText.setText(str + " - ");
                topText.setTextColor(defColors);
                outText.setText("");
            }
        });

        Button actMulti = (Button) findViewById(R.id.buttonActMulti);
        actMulti.setOnClickListener(view -> {
            String str = String.valueOf((String) outText.getText());
            if (str != null && str.length() > 0) {
                curAction = ActionList.MULTI;
                firstNumber = Double.valueOf(str);
                topText.setText(str + " * ");
                topText.setTextColor(defColors);
                outText.setText("");
            }
        });

        Button actDiv = (Button) findViewById(R.id.buttonActDiv);
        actDiv.setOnClickListener(view -> {
            String str = String.valueOf((String) outText.getText());
            if (str != null && str.length() > 0) {
                curAction = ActionList.DIV;
                firstNumber = Double.valueOf(str);
                topText.setText(str + " / ");
                topText.setTextColor(defColors);
                outText.setText("");
            }
        });

        Button actEq = (Button) findViewById(R.id.buttonActEq);
        actEq.setOnClickListener(view -> {
            Double secondValue;
            String str = String.valueOf((String) outText.getText());
            if (str != null && str.length() > 0) {
                secondValue = Double.valueOf(str);
            }
            else {
                return;
            }

            switch (curAction) {
                case PLUS:
                    firstNumber = firstNumber + secondValue;
                    topText.setText((String)topText.getText() + String.valueOf(secondValue) + " =");
                    topText.setTextColor(defColors);
                    outText.setText(String.valueOf(firstNumber));
                    break;
                case MINUS:
                    firstNumber = firstNumber - secondValue;
                    topText.setText((String)topText.getText() + String.valueOf(secondValue) + " =");
                    topText.setTextColor(defColors);
                    outText.setText(String.valueOf(firstNumber));
                    break;
                case MULTI:
                    firstNumber = firstNumber * secondValue;
                    topText.setText((String)topText.getText() + String.valueOf(secondValue) + " =");
                    topText.setTextColor(defColors);
                    outText.setText(String.valueOf(firstNumber));
                    break;
                case DIV:
                    if(secondValue == 0.0) {
                        topText.setTextColor(Color.RED);
                        topText.setText("Error: division by 0");
                        firstNumber = 0.0;
                    }
                    else {
                        topText.setText((String)topText.getText() + String.valueOf(secondValue) + " =");
                        topText.setTextColor(defColors);
                        firstNumber = firstNumber / secondValue;
                    }

                    outText.setText(String.valueOf(firstNumber));
                    break;
                default:
                    break;
            }

            curAction = ActionList.NOPE;
        });

    }

}