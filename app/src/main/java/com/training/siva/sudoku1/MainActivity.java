package com.training.siva.sudoku1;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void newGame(View view) {
        Intent obj = new Intent(this, NewGame.class);
        startActivity(obj);
    }

    public void continueGame(View view) {
        Intent obj = new Intent(this, ContinueGame.class);
        startActivity(obj);
    }

    public void sudokuSolver(View view) {
        Intent obj = new Intent(this, SudokuSolver.class);
        startActivity(obj);
    }

    public void about(View view) {
        Intent obj = new Intent(this, AboutActivity.class);
        startActivity(obj);
    }

    public void help(View view) {
        Intent obj = new Intent(this, HelpActivity.class);
        startActivity(obj);
    }


}
