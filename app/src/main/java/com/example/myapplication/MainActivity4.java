package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.model.Game;
import com.example.myapplication.model.GameManager;
import com.example.myapplication.model.Mine;
import com.example.myapplication.model.SelectGame;

import java.util.ArrayList;
// This class shows radio buttons for mines and rows and columns combination.
// it also has a button that can delete all games played previously
// It also has a button that can show previous played games as well
public class MainActivity4 extends AppCompatActivity {
    GameManager gamer;
    SelectGame sg;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.pink)));
        gamer = GameManager.getInstance();
        sg = SelectGame.getInstance();
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        setTitle("Options");
        createNumMines();
        createBoardSizes();

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(MainActivity4.this, R.raw.click_sound);
                mp.start();
                Intent intent = new Intent(MainActivity4.this, ShowGames.class);
                startActivity(intent);
            }
        });

        Button rem = findViewById(R.id.removeAll);
        rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(MainActivity4.this, R.raw.click_sound);
                mp.start();
                gamer.removeAllGames();
                gamer.setDel(1);
                Intent inte = new Intent(MainActivity4.this, ShowGames.class);
                startActivity(inte);
            }
        });

    }

    private void createBoardSizes() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radio_board_size);
        int[] board_games = getResources().getIntArray(R.array.board_size_game);
        for(int i = 0; i < board_games.length; i=i+2){
            int board_game_row = board_games[i];
            int board_game_col = board_games[i+1];

            RadioButton rbtn = new RadioButton(this);
            rbtn.setText(board_game_row + " rows * " + board_game_col + " columns");
            rbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mp = MediaPlayer.create(MainActivity4.this, R.raw.click_sound);
                    mp.start();
                    sg.setC(board_game_col);
                    sg.setR(board_game_row);
                }
            });
            group.addView(rbtn);
        }
    }

    private void createNumMines() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group_mines);
        int[] number_mines = getResources().getIntArray(R.array.num_mines);
        for(int i = 0; i < number_mines.length; i++){
            int number_mine = number_mines[i];
            RadioButton rbtn = new RadioButton(this);
            rbtn.setText(number_mine + " mines");

            rbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mp = MediaPlayer.create(MainActivity4.this, R.raw.click_sound);
                    mp.start();
                    sg.setM(number_mine);
                }
            });
            group.addView(rbtn);
        }

    }
}