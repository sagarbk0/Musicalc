package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {
    private TextView history;
    private TextView result;
    private TextView sign;
    private Double operand1 = null;
    private String pendingOperation = "";
    private static final String STATE_PENDING_OPERATION = "PendingOperation";
    private static final String STATE_OPERAND1 = "Operand1";
    private static final String historyText = "history";
    private static final String resultText = "result";


        /* Attempt to assign values using arrays failed, possibly retry later?
    private EditText[] tArray = new EditText[]{findViewById(R.id.history),(EditText)findViewById(R.id.sign),(EditText)findViewById(R.id.result)};
    private Button[] bArray = new Button[]{findViewById(R.id.b0), findViewById(R.id.b1), findViewById(R.id.b2), findViewById(R.id.b3), findViewById(R.id.b4), findViewById(R.id.b5), findViewById(R.id.b6), findViewById(R.id.b7), findViewById(R.id.b8), findViewById(R.id.b9), findViewById(R.id.dot), findViewById(R.id.equals), findViewById(R.id.plus), findViewById(R.id.minus), findViewById(R.id.times), findViewById(R.id.divide), findViewById(R.id.sqrroot), findViewById(R.id.ln), findViewById(R.id.powof), findViewById(R.id.to2)};
    private ArrayList<EditText> texts = new ArrayList<>();
    private ArrayList<Button> buttons = new ArrayList<>();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* for(int i=0;i<=tArray.length;i++){
            texts.add(tArray[i]);
        }
        for(int i=0;i<=bArray.length;i++){
            buttons.add(bArray[i]);
        } */
        history = findViewById(R.id.history);
        sign = findViewById(R.id.sign);
        result = findViewById(R.id.result);
        Button b0 = findViewById(R.id.b0);
        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);
        Button b3 = findViewById(R.id.b3);
        Button b4 = findViewById(R.id.b4);
        Button b5 = findViewById(R.id.b5);
        Button b6 = findViewById(R.id.b6);
        Button b7 = findViewById(R.id.b7);
        Button b8 = findViewById(R.id.b8);
        Button b9 = findViewById(R.id.b9);
        Button dot = findViewById(R.id.dot);
        Button neg = findViewById(R.id.neg);

        Button equals = findViewById(R.id.equals);
        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        Button times = findViewById(R.id.times);
        Button divide = findViewById(R.id.divide);
        Button sqrroot = findViewById(R.id.sqrroot);
        Button clr = findViewById(R.id.clr);
        /*previously in landscape: Button powof = findViewById(R.id.powof);
        Button to2 = findViewById(R.id.to2);*/

        View.OnClickListener clear = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history.setText("");
                sign.setText("");
                result.setText("");
                operand1 = null;
                pendingOperation = "";
            }
        };
        clr.setOnClickListener(clear);

        final MediaPlayer C = MediaPlayer.create(this, R.raw.c);
        final MediaPlayer D = MediaPlayer.create(this, R.raw.d);
        final MediaPlayer E = MediaPlayer.create(this, R.raw.e);
        final MediaPlayer F = MediaPlayer.create(this, R.raw.f);
        final MediaPlayer G = MediaPlayer.create(this, R.raw.g);
        final MediaPlayer A = MediaPlayer.create(this, R.raw.a);
        final MediaPlayer B = MediaPlayer.create(this, R.raw.b);
        final MediaPlayer C2 = MediaPlayer.create(this, R.raw.c2);

        View.OnClickListener c = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                C.start();
                result.append(b.getText().toString());
            }
        };

        View.OnClickListener d = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                D.start();
                result.append(b.getText().toString());
            }
        };

        View.OnClickListener e = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                E.start();
                result.append(b.getText().toString());
            }
        };

        View.OnClickListener f = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                F.start();
                result.append(b.getText().toString());
            }
        };

        View.OnClickListener g = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                G.start();
                result.append(b.getText().toString());
            }
        };

        View.OnClickListener a = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                A.start();
                result.append(b.getText().toString());
            }
        };

        View.OnClickListener b = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                B.start();
                result.append(b.getText().toString());
            }
        };

        View.OnClickListener c2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                C2.start();
                result.append(b.getText().toString());
            }
        };

        b1.setOnClickListener(b);
        b2.setOnClickListener(c2);
        b4.setOnClickListener(f);
        b5.setOnClickListener(g);
        b6.setOnClickListener(a);
        b7.setOnClickListener(c);
        b8.setOnClickListener(d);
        b9.setOnClickListener(e);

        View.OnClickListener negv = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("-");
            }
        };
        neg.setOnClickListener(negv);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                result.append(b.getText().toString());
            }
        };
        /*for(int i=0;i<=10;i++){
            buttons.get(i).setOnClickListener(listener);
        }*/
        b0.setOnClickListener(listener);
        b3.setOnClickListener(listener);
        dot.setOnClickListener(listener);

        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String op = b.getText().toString();
                String value = result.getText().toString();
                try {
                    Double doubleValue = Double.valueOf(value);
                    performOperation(doubleValue, op);
                } catch (NumberFormatException e) {
                    result.setText("");
                }
                /*if (value.length() != 0) {
                    performOperation(value, op);
                }*/
                pendingOperation = op;
                sign.setText(pendingOperation);
            }
        };
        equals.setOnClickListener(opListener);
        plus.setOnClickListener(opListener);
        minus.setOnClickListener(opListener);
        times.setOnClickListener(opListener);
        divide.setOnClickListener(opListener);
        sqrroot.setOnClickListener(opListener);

        /* powof.setOnClickListener(opListener);
        to2.setOnClickListener(opListener); */

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(STATE_PENDING_OPERATION, pendingOperation);
        outState.putString(resultText, result.getText().toString());
        outState.putString(historyText, history.getText().toString());
        if (operand1 != null) {
            outState.putDouble(STATE_OPERAND1, operand1);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pendingOperation = savedInstanceState.getString(STATE_PENDING_OPERATION);
        operand1 = savedInstanceState.getDouble(STATE_OPERAND1);
        sign.setText(pendingOperation);
        history.setText(savedInstanceState.getString(historyText));
        result.setText(savedInstanceState.getString(resultText));
    }

    private void performOperation(Double value, String operation) {
        if (null == operand1) {
            operand1 = value;
        } else {
            if (pendingOperation.equals("=")) {
                pendingOperation = operation;
            }
            switch (pendingOperation) {
                case "=":
                    operand1 = value;
                    break;
                case "÷":
                    if (value == 0) {
                        operand1 = 0.0;
                    } else {
                        operand1 /= value;
                    }
                    break;
                case "×":
                    operand1 *= value;
                    break;
                case "-":
                    operand1 -= value;
                    break;
                case "+":
                    operand1 += value;
                    break;
                case "ln":
                    operand1 = Math.log(value);
                case "√":
                    operand1 = sqrt(value);
            }
        }

        history.setText(operand1.toString());
        result.setText("");

    }

}
