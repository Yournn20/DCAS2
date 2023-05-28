package com.example.dcas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.dcas.Login;
import com.example.dcas.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminOrder extends AppCompatActivity {
    private final String[] tabs = {"Accept Orders", "Update Orders", "Finished Orders"};
    private Toolbar supportActionBar;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_order);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_products);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_orders:
                    return true;
                case R.id.bottom_products:
                    startActivity(new Intent(getApplicationContext(), AdminPanel.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_logout:
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                    return true;
            }
            return false;
        });

        CardView cardView = findViewById(R.id.card1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity here
                Intent intent = new Intent(AdminOrder.this, AcceptOrders.class);
                startActivity(intent);
            }
        });

        CardView cardView2 = findViewById(R.id.card2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity here
                Intent intent = new Intent(AdminOrder.this, UpdateOrders.class);
                startActivity(intent);
            }
        });

        CardView cardView3 = findViewById(R.id.card3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity here
                Intent intent = new Intent(AdminOrder.this, FinishedOrder.class);
                startActivity(intent);
            }
        });
    }


}