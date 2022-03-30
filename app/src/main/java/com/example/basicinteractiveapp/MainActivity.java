package com.example.basicinteractiveapp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int i = 0;
    public void onIncrement(View view){
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + ++i);
        displayPrice();
        TextView lastMessage = findViewById(R.id.lastMessage);
        lastMessage.setText("");
        TextView firstMessage = findViewById(R.id.firstMessage);
        firstMessage.setText("");
    }
    public void onDecrement(View view){
        if(!(i == 0)) {
            TextView quantityTextView = findViewById(R.id.quantity_text_view);
            quantityTextView.setText("" + --i);
            displayPrice();
        }
    }
    private void displayPrice(){
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(i * 20));
    }

    public void submitOrder(View view){
//        String finalMessage = i + " coffee ordered for " + NumberFormat.getCurrencyInstance().format(i * 20);
        StringBuilder finalMessage = new StringBuilder();
        finalMessage.append(i + " coffee ordered for " + NumberFormat.getCurrencyInstance().format(i * 20));
        i = 0;

        TextView quantityTextview = findViewById(R.id.quantity_text_view);
        quantityTextview.setText(""+ i);

        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(i));

        String message = "YOUR ORDER IS BEING PACKED !";
        TextView lastMessage = findViewById(R.id.lastMessage);
        lastMessage.setText("" + message);

        // newly added
        CheckBox check1 = (CheckBox) findViewById(R.id.check1);
        CheckBox check2 = (CheckBox) findViewById(R.id.check2);
        if(check1.isChecked() || check2.isChecked()) {
            finalMessage.append(" with topping");
            if (check1.isChecked()) {
                finalMessage.append(" of whipped cream");
            }
            if (check2.isChecked()) {
                if(check1.isChecked()){
                 finalMessage.append(" and choco chips");
                    check2.toggle();
                }else{
                    finalMessage.append("of choco chips");
                }
            }
        if(check1.isChecked()){
            check1.toggle();
        }
        }
        TextView firstMessage = (TextView) findViewById(R.id.firstMessage);
        firstMessage.setText("" + finalMessage);

    }
}