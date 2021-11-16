package com.training.siva.sudoku1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinningActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);
        TextView t= findViewById(R.id.ttime);
        t.setText(NewGame.current_time);

    }

    public void new_game_button(View view)
    {
        Intent obj = new Intent(WinningActivity.this, NewGame.class);
        finish();
        startActivity(obj);
    }
    public void home(View view)
    {
        finish();
    }
}
