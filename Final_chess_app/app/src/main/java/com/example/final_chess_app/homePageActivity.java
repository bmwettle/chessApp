package com.example.final_chess_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homePageActivity extends AppCompatActivity {
    Button new_game_button;
    Button friends_button;
    Button my_games_button;
    Button log_out_button;
    Button disscusion_board_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        makeDiscussion();
        makeFriends();
        makeMyGames();

    }
    private void makeMyGames(){
        my_games_button= (Button)findViewById(R.id.my_games_button);
        my_games_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(homePageActivity.this, my_games_page.class);
                startActivity(intent);
            }
        });
    }
    private void makeNewGame(){
        new_game_button= (Button)findViewById(R.id.new_game_button);
        new_game_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(homePageActivity.this, new_game_page.class);
                startActivity(intent);
            }
        });
    }
    private void makeFriends(){
        friends_button= (Button)findViewById(R.id.friends_button);
        friends_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(homePageActivity.this, friends_page.class);
                startActivity(intent);
            }
        });
    }
    private void makeDiscussion(){
        disscusion_board_button= (Button)findViewById(R.id.discussion_board_button);

        disscusion_board_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(homePageActivity.this, discussion_board.class);
                startActivity(intent);
            }
        });

        friends_button= (Button)findViewById(R.id.login_button);
    }
}
