package com.example.ahnaf.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText enterAmountInput = (EditText)findViewById(R.id.enterAmountInput);
        final EditText enterTipInput = (EditText)findViewById(R.id.enterTipInput);
        final TextView tipAmountOutput = (TextView)findViewById(R.id.tipAmountOutput);
        final TextView amountDueOutput = (TextView)findViewById(R.id.amountDueOutput);
        final TextView warningText = (TextView)findViewById(R.id.warningText);
        Button button = (Button)findViewById(R.id.button);
        Button refresh = (Button)findViewById(R.id.refreshButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    warningText.setText("");
                    double amount = Double.parseDouble(enterAmountInput.getText().toString());
                    double tip = Double.parseDouble(enterTipInput.getText().toString()) * 0.01;
                    double tipAmount = tip * amount;
                    String tipAmountString = "$" + String.format("%.2f",tipAmount);
                    tipAmountOutput.setText(tipAmountString);
                    double amountDue = amount + tipAmount;
                    String amountDueString = "$" + String.format("%.2f",amountDue);
                    amountDueOutput.setText(amountDueString);
                }
                catch(Exception e){
                    ArrayList<String> msgs = new ArrayList<String>();
                    String msg = "Error: Enter items properly";
                    warningText.setText(msg);
                }
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                warningText.setText("");
                enterAmountInput.setText("");
                tipAmountOutput.setText("---");
                amountDueOutput.setText("---");
                enterTipInput.setText("15");
            }
        });
    }
}
