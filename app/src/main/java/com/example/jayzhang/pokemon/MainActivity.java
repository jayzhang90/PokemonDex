package com.example.jayzhang.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void pokemonClick(View view) {
        String tag = view.getTag().toString();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("pokemon_name", tag);
        startActivity(intent);
    }
}
