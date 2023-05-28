package com.example.dcas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class CartActivity extends AppCompatActivity {

    DrawerLayout drawerlayout;
    ImageView menu,order;
    LinearLayout home, profile, cart, about, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        profile = findViewById(R.id.profile);
        cart = findViewById(R.id.cart);
        about = findViewById(R.id.about);
        logout = findViewById(R.id.logout);
        order = findViewById(R.id.order);
        drawerlayout = findViewById(R.id.drawerLayout);

        menu.setOnClickListener(v -> openDrawer(drawerlayout));

        cart.setOnClickListener(v -> recreate());

        profile.setOnClickListener(v -> redirectActivity(CartActivity.this, ProfileActivity.class));

        home.setOnClickListener(v -> redirectActivity(CartActivity.this, MainActivity.class));


        about.setOnClickListener(v -> redirectActivity(CartActivity.this, AboutActivity.class));
        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut(); // Sign out the user from Firebase Authentication
            Intent intent = new Intent(CartActivity.this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear the task stack
            startActivity(intent); // Start the LoginActivity
            Toast.makeText(CartActivity.this, "Logout successful", Toast.LENGTH_SHORT).show();
        });

        order.setOnClickListener(v -> redirectActivity(CartActivity.this, Orders.class));



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void redirectActivity(Activity activity, Class secondActivity){
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }
    @Override
    protected void onPause(){
        super.onPause();
        closeDrawer(drawerlayout);
    }
}