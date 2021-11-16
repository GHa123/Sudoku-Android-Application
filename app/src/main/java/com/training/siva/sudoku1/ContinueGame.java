package com.training.siva.sudoku1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ContinueGame extends Activity implements View.OnClickListener{

    Chronometer ch;
    ImageButton start,pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        setNewTheme(ThemesActivity.x);
        getInitialValues();
        ch= (Chronometer)findViewById(R.id.chronometer);
        ch.setText(NewGame.current_time);
        start=(ImageButton) findViewById(R.id.start);
        pause=(ImageButton) findViewById(R.id.pause);
        resume();
        start.setOnClickListener(this);
        pause.setOnClickListener(this);
    }

    public int a[][] = new int[9][9];
    public int b[][] = new int[9][9];
    public int c[][] = new int[9][9];



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.start)
        {
            resume();
        }
        else if(v.getId()==R.id.pause)
        {
            ch.stop();
            start.setVisibility(start.VISIBLE);
            pause.setVisibility(pause.GONE);


        }
    }

    public void setNewTheme(String x)
    {
        Button b5=findViewById(R.id.button5);
        Button b6=findViewById(R.id.button6);

        if(x.equals("t1"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.reference_grid);
            RelativeLayout r= findViewById(R.id.rel_layout);
            r.setBackgroundResource(R.drawable.background_newgame);
        }
        else if(x.equals("t2"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.grey);
        }
        else if(x.equals("t3"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.blue_white);
            b5.setBackgroundColor(Color.rgb(227, 255, 250));
            b6.setBackgroundColor(Color.rgb(227, 255, 250));
        }
        else if(x.equals("t4"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.yellow_white);
            b5.setBackgroundColor(Color.rgb(255, 255, 211));
            b6.setBackgroundColor(Color.rgb(255, 255, 211));
        }
        else if(x.equals("t5"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.pink);
            b5.setBackgroundResource(R.drawable.pink_bg);
            b6.setBackgroundResource(R.drawable.pink_bg);
        }
        else if(x.equals("t6"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.pink_blue);
            b5.setBackgroundColor(Color.rgb(255, 219, 221  ));
            b6.setBackgroundColor(Color.rgb(255, 219, 221  ));
        }
        else if(x.equals("t7"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.blue_theme);
            b5.setBackgroundColor(Color.rgb(210, 241, 255 ));
            b6.setBackgroundColor(Color.rgb(210, 241, 255 ));
        }
        else if(x.equals("t8"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.water);
            b5.setBackgroundColor(Color.rgb(215, 223, 255 ));
            b6.setBackgroundColor(Color.rgb(215, 223, 255 ));

        }
        else if(x.equals("t9"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.light);
            b5.setBackgroundColor(Color.rgb(255, 249, 249 ));
            b6.setBackgroundColor(Color.rgb(255, 249, 249 ));
        }
        else if(x.equals("t10"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.dark);
            b5.setBackgroundColor(Color.rgb(46, 39, 39   ));
            b6.setBackgroundColor(Color.rgb(46, 39, 39  ));
            b5.setTextColor(Color.WHITE);
            b6.setTextColor(Color.WHITE);
            TextView t=findViewById(R.id.text_time);
            t.setTextColor(Color.WHITE);
            Chronometer c=findViewById(R.id.chronometer);
            c.setTextColor(Color.WHITE);
            RelativeLayout r= findViewById(R.id.rel_layout);
            r.setBackgroundResource(R.drawable.black_bg);
            TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout);
            for (int y = 0; y < 9; y++) {
                for (int z = 0; z < 9; z++) {
                    EditText obj1 = obj2.findViewWithTag(Integer.toString(10 * y + z + 11));
                    obj1.setTextColor(Color.WHITE);
                }
            }
        }
        else if(x.equals("t11"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.multi_color1);
            b5.getBackground().setAlpha(80);
            b6.getBackground().setAlpha(80);
            RelativeLayout r= findViewById(R.id.rel_layout);
            r.setBackgroundResource(R.drawable.m1_update);

        }
        else if(x.equals("t12"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.multi_color);
            b5.getBackground().setAlpha(80);
            b6.getBackground().setAlpha(80);
            RelativeLayout r= findViewById(R.id.rel_layout);
            r.setBackgroundResource(R.drawable.m2_update);
        }
        else if(x.equals("t13"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.boxed);
            b5.setBackgroundResource(R.drawable.box_bg );
            b6.setBackgroundResource(R.drawable.box_bg );
            b5.setTextColor(Color.WHITE);
            b6.setTextColor(Color.WHITE);
            TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout);
            for (int y = 0; y < 9; y++) {
                for (int z = 0; z < 9; z++) {
                    EditText obj1 = obj2.findViewWithTag(Integer.toString(10 * y + z + 11));
                    obj1.setTextColor(Color.WHITE);
                }
            }
        }
        else if(x.equals("t14"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.wooden);
            b5.setBackgroundResource(R.drawable.wooden_bg);
            b6.setBackgroundResource(R.drawable.wooden_bg);
            b5.setTextColor(Color.BLACK);
            b6.setTextColor(Color.BLACK);

        }
        else if(x.equals("t15"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.galaxy);
            b5.setBackgroundColor(Color.rgb(246, 216, 255   ));
            b6.setBackgroundColor(Color.rgb(246, 216, 255     ));
        }
        else if(x.equals("t16"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.metallic);
            b5.setBackgroundResource(R.drawable.metal_bg );
            b6.setBackgroundResource(R.drawable.metal_bg );
        }

        else if(x.equals("t17"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.box_shelves1);
            b5.setBackgroundResource(R.drawable.shelve_background);
            b6.setBackgroundResource(R.drawable.shelve_background);
        }

        else if(x.equals("t18"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.chalkboard);
            b5.setBackgroundResource(R.drawable.board_background);
            b6.setBackgroundResource(R.drawable.board_background);
            b5.setTextColor(Color.WHITE);
            b6.setTextColor(Color.WHITE);
            TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout);
            for (int y = 0; y < 9; y++) {
                for (int z = 0; z < 9; z++) {
                    EditText obj1 = obj2.findViewWithTag(Integer.toString(10 * y + z + 11));
                    obj1.setTextColor(Color.WHITE);
                }
            }
        }

    }

    public void themes(View view) {
        ch.stop();
        start.setVisibility(start.VISIBLE);
        pause.setVisibility(pause.GONE);
        NewGame.current_time=ch.getText().toString();
        save_game_code();
        Intent obj = new Intent(this, ThemesActivity.class);
        finish();
        startActivity(obj);
    }
    public void resume()
    {
        String s1=ch.getText().toString();
        String s2[]=s1.split(":");
        int min = Integer.parseInt(s2[0]);
        int sec = Integer.parseInt(s2[1]);
        long k=min*60000+sec*1000;
        long j=SystemClock.elapsedRealtime()-k;
        ch.setBase(j);
        ch.start();
        pause.setVisibility(pause.VISIBLE);
        start.setVisibility(start.GONE);

    }

    public void getInitialValues() {
        try {
            FileInputStream fin = openFileInput("GameData.txt");
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    a[i][j] = fin.read();
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    b[i][j] = fin.read();
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    c[i][j] = fin.read();
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (b[i][j] != 0) {
                    setInitialValue(b[i][j], i + 1, j + 1);
                } else if (c[i][j] != 0)
                    setSavedValue(c[i][j], i + 1, j + 1);
            }
        }
    }

    public void setInitialValue(int num, int i, int j) {
        TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout);
        EditText obj1 = obj2.findViewWithTag(Integer.toString(10 * i + j));
        obj1.setText(String.valueOf(num));
        obj1.setTypeface(null, Typeface.BOLD);
        obj1.setFocusable(false);
    }

    public void setSavedValue(int num, int i, int j) {
        TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout);
        EditText obj1 = obj2.findViewWithTag(Integer.toString(10 * i + j));
        obj1.setText(String.valueOf(num));
    }

    public void checkAnswer(View view) {
        TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < 9; y++) {
            for (int z = 0; z < 9; z++) {
                EditText obj1 = obj2.findViewWithTag(Integer.toString(10 * y + z + 11));
                String str = obj1.getText().toString();
                if (str.matches(""))
                    c[y][z] = 0;
                else
                    c[y][z] = Integer.parseInt(str);
            }
        }

        int q = 0, p = 0;
        for (int y = 0; y < 9; y++) {
            for (int z = 0; z < 9; z++) {
                if (a[y][z] == c[y][z])
                    continue;
                else if (c[y][z] == 0) {
                    p++;
                    break;
                } else {
                    q++;
                    break;
                }
            }
        }
        if (p == 0 & q == 0){
            ch.stop();
            start.setVisibility(start.VISIBLE);
            pause.setVisibility(pause.GONE);

            NewGame.current_time=ch.getText().toString();
            Intent obj = new Intent(this, WinningActivity.class);
            finish();
            startActivity(obj);
            //Toast.makeText(this, "Congratulations! Sudoku Solved Successfully.", Toast.LENGTH_SHORT).show();
        }
        else if (p == 0) {
            ch.stop();
            start.setVisibility(start.VISIBLE);
            pause.setVisibility(pause.GONE);

            Intent obj = new Intent(this, LosingActivity.class);
            finish();
            startActivity(obj);
            //Toast.makeText(this, "Oops! The solution is incorrect.", Toast.LENGTH_SHORT).show();
        }
        else{ Toast.makeText(this, "Oops! The Sudoku is Incomplete.", Toast.LENGTH_SHORT).show();}
    }

    public void save_game_code()
    {
        ch.stop();
        start.setVisibility(start.VISIBLE);
        pause.setVisibility(pause.GONE);
        NewGame.current_time=ch.getText().toString();
        TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < 9; y++) {
            for (int z = 0; z < 9; z++) {
                EditText obj1 = obj2.findViewWithTag(Integer.toString(10 * y + z + 11));
                String str = obj1.getText().toString();
                if (str.matches(""))
                    c[y][z] = 0;
                else
                    c[y][z] = Integer.parseInt(str);
            }
        }

        try {
            FileOutputStream fOut = openFileOutput("GameData.txt", Context.MODE_PRIVATE);
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    fOut.write(a[i][j]);
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    fOut.write(b[i][j]);
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    fOut.write(c[i][j]);
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveGame(View view) {
        save_game_code();
        Toast.makeText(this, "Game Progress Saved Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void solutionDisplay(View view) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (b[i][j] != 0) {
                    setInitialValue(b[i][j], i + 1, j + 1);
                } else if (a[i][j] != 0)
                    setSolutionValue(a[i][j], i + 1, j + 1);
            }
        }
    }

    public void setSolutionValue(int num, int i, int j) {
        TableLayout obj2 = findViewById(R.id.tableLayout);
        EditText obj1 = obj2.findViewWithTag(Integer.toString(10 * i + j));
        obj1.setText(String.valueOf(num));
        obj1.setTypeface(null, Typeface.NORMAL);
    }
}