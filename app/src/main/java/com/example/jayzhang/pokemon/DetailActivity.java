package com.example.jayzhang.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Scanner;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //In the second activity that was invoked, we can grab any extra data
        Intent intent = getIntent();
        String pokemonName = intent.getStringExtra("pokemon_name");

        // pokemon name to appear in big font
        TextView nameTextView = (TextView) findViewById(R.id.pokemon_name);
        nameTextView.setText(pokemonName);

        // display pokemon image in imageview
        // (R.drawable.pokemon)
        int imageID = getResources().getIdentifier(
                pokemonName.toLowerCase(), "drawable", getPackageName()
        );
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        Picasso.with(this)
                //.load("http://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"
                .load(imageID)
                .resize(500, 500)
                .into(imageView);


        // details about pokemon to appear in small font
        // (res/raw/pokemon.txt)

        int fileID = getResources().getIdentifier(
                pokemonName.toLowerCase(), "raw", getPackageName()
        );
        Scanner scan = new Scanner(getResources().openRawResource(fileID));
        TextView pokeDetails = (TextView) findViewById(R.id.pokemon_details);
        String detailPoke="";
        while(scan.hasNextLine()){
            detailPoke+=scan.nextLine();
        }
        pokeDetails.setText(detailPoke);
    }
}
