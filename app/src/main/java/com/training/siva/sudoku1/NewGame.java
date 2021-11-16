package com.training.siva.sudoku1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
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

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

public class NewGame extends Activity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        setNewTheme(ThemesActivity.x);
        getInitialValues();
        saveGame_code();
        c= (Chronometer)findViewById(R.id.chronometer);
        start=(ImageButton) findViewById(R.id.start);
        pause=(ImageButton) findViewById(R.id.pause);

        long l= SystemClock.elapsedRealtime();
        c.setBase(l);
        c.start();
        pause.setVisibility(pause.VISIBLE);
        start.setVisibility(start.GONE);

        start.setOnClickListener(this);
        pause.setOnClickListener(this);


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
            b5.getBackground().setAlpha(80);
            b6.getBackground().setAlpha(80);
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
            RelativeLayout r= findViewById(R.id.rel_layout);
            r.setBackgroundResource(R.drawable.black_bg);
            TextView t=findViewById(R.id.text_time);
            t.setTextColor(Color.WHITE);
            Chronometer c=findViewById(R.id.chronometer);
            c.setTextColor(Color.WHITE);
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
        else if(x.equals("t11"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.multi_color1);
            RelativeLayout r= findViewById(R.id.rel_layout);
            r.setBackgroundResource(R.drawable.m1_update);
            b5.getBackground().setAlpha(80);
            b6.getBackground().setAlpha(80);

        }
        else if(x.equals("t12"))
        {
            ThemesActivity obj= new ThemesActivity();
            ImageView i=findViewById(R.id.imageView);
            i.setBackgroundResource(R.drawable.multi_color);
            RelativeLayout r= findViewById(R.id.rel_layout);
            r.setBackgroundResource(R.drawable.m2_update);
            b5.getBackground().setAlpha(80);
            b6.getBackground().setAlpha(80);

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

    public static String current_time="00:00";
    public int solution[][] = new int[9][9];
    public int game[][] = new int[9][9];
    public int progress[][] = new int[9][9];
    Chronometer c;
    ImageButton start,pause;

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.start)
        {
            String s1=c.getText().toString();

            String s2[]=s1.split(":");
            int min = Integer.parseInt(s2[0]);
            int sec = Integer.parseInt(s2[1]);
            long k=min*60000+sec*1000;
            long j=SystemClock.elapsedRealtime()-k;
            c.setBase(j);
            c.start();
            pause.setVisibility(pause.VISIBLE);
            start.setVisibility(start.GONE);

        }

        else if(v.getId()==R.id.pause)
        {
            c.stop();
            start.setVisibility(start.VISIBLE);
            pause.setVisibility(pause.GONE);

        }
    }


    public void getInitialValues() {
        solution = generateSolution(new int[9][9], 0);
        game = generateGame(copy(solution));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (game[i][j] != 0) {
                    setInitialValue(game[i][j], i + 1, j + 1);
                }
            }
        }
    }

    private int[][] generateSolution(int[][] game, int index)
    {
        if (index > 80)
            return game;

        int x = index % 9;
        int y = index / 9;

        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) numbers.add(i);
        Collections.shuffle(numbers);

        while (numbers.size() > 0)
        {
            int number = getNextPossibleNumber(game, x, y, numbers);
            if (number == -1)
                return null;

            game[y][x] = number;
            int[][] tmpGame = generateSolution(game, index + 1);
            if (tmpGame != null)
                return tmpGame;
            game[y][x] = 0;
        }

        return null;
    }

    private int getNextPossibleNumber(int[][] game, int x, int y, List<Integer> numbers) {
        while (numbers.size() > 0) {
            int number = numbers.remove(0);
            if (isPossibleX(game, y, number) && isPossibleY(game, x, number) && isPossibleBlock(game, x, y, number))
                return number;
        }
        return -1;
    }

    private boolean isPossibleX(int[][] game, int y, int number) {
        for (int x = 0; x < 9; x++) {
            if (game[y][x] == number)
                return false;
        }
        return true;
    }

    private boolean isPossibleY(int[][] game, int x, int number) {
        for (int y = 0; y < 9; y++) {
            if (game[y][x] == number)
                return false;
        }
        return true;
    }

    private boolean isPossibleBlock(int[][] game, int x, int y, int number) {
        int x1 = x < 3 ? 0 : x < 6 ? 3 : 6;
        int y1 = y < 3 ? 0 : y < 6 ? 3 : 6;
        for (int yy = y1; yy < y1 + 3; yy++) {
            for (int xx = x1; xx < x1 + 3; xx++) {
                if (game[yy][xx] == number)
                    return false;
            }
        }
        return true;
    }

    private int[][] generateGame(int[][] game) {
        List<Integer> positions = new ArrayList<Integer>();
        for (int i = 0; i < 81; i++)
            positions.add(i);
        Collections.shuffle(positions);
        return generateGame(game, positions);
    }

    private int[][] generateGame(int[][] game, List<Integer> positions) {
        while (positions.size() > 0) {
            int position = positions.remove(0);
            int x = position % 9;
            int y = position / 9;
            int temp = game[y][x];
            game[y][x] = 0;

            if (!isValid(game))
                game[y][x] = temp;
        }

        return game;
    }

    private boolean isValid(int[][] game) {
        return isValid(game, 0, new int[]{0});
    }

    private boolean isValid(int[][] game, int index, int[] numberOfSolutions) {
        if (index > 80)
            return ++numberOfSolutions[0] == 1;

        int x = index % 9;
        int y = index / 9;

        if (game[y][x] == 0) {
            List<Integer> numbers = new ArrayList<Integer>();
            for (int i = 1; i <= 9; i++)
                numbers.add(i);

            while (numbers.size() > 0) {
                int number = getNextPossibleNumber(game, x, y, numbers);
                if (number == -1)
                    break;
                game[y][x] = number;

                if (!isValid(game, index + 1, numberOfSolutions)) {
                    game[y][x] = 0;
                    return false;
                }
                game[y][x] = 0;
            }
        } else if (!isValid(game, index + 1, numberOfSolutions))
            return false;

        return true;
    }

    private int[][] copy(int[][] game) {
        int[][] copy = new int[9][9];
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++)
                copy[y][x] = game[y][x];
        }
        return copy;
    }

    public void setInitialValue(int num, int i, int j) {
        TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout);
        EditText obj1 = obj2.findViewWithTag(Integer.toString(10 * i + j));
        obj1.setText(String.valueOf(num));
        obj1.setTypeface(null, Typeface.BOLD);
        obj1.setFocusable(false);
    }

    public void checkAnswer(View view) {
        TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < 9; y++) {
            for (int z = 0; z < 9; z++) {
                EditText obj1 = obj2.findViewWithTag(Integer.toString(10 * y + z + 11));
                String str = obj1.getText().toString();
                if (str.matches(""))
                    progress[y][z] = 0;
                else
                    progress[y][z] = Integer.parseInt(str);
            }
        }

        int q = 0, p = 0;
        for (int y = 0; y < 9; y++) {
            for (int z = 0; z < 9; z++) {
                if (solution[y][z] == progress[y][z])
                    continue;
                else if (progress[y][z] == 0) {
                    p++;
                    break;
                } else {
                    q++;
                    break;
                }
            }
        }
        if (p == 0 & q == 0) {
            c.stop();
            start.setVisibility(start.VISIBLE);
            pause.setVisibility(pause.GONE);
            current_time=c.getText().toString();
            Intent obj = new Intent(this, WinningActivity.class);
            finish();
            startActivity(obj);
            //Toast.makeText(this, "Congratulations! Sudoku Solved Successfully.", Toast.LENGTH_SHORT).show();
        }
        else if (p == 0) {
            c.stop();
            start.setVisibility(start.VISIBLE);
            pause.setVisibility(pause.GONE);
            Intent obj = new Intent(this, LosingActivity.class);
            finish();
            startActivity(obj);
            //Toast.makeText(this, "Oops! The solution is incorrect.", Toast.LENGTH_SHORT).show();
        }
        else{ Toast.makeText(this, "Oops! The Sudoku is Incomplete.", Toast.LENGTH_SHORT).show();}
        //saveGame_code();
        //Button b = (Button) findViewById(R.id.button6);
        //b.performClick();
    }

    public void saveGame_code()
    {
        TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < 9; y++) {
            for (int z = 0; z < 9; z++) {
                EditText obj1 = obj2.findViewWithTag(Integer.toString(10 * y + z + 11));
                String str = obj1.getText().toString();
                if (str.matches(""))
                    progress[y][z] = 0;
                else
                    progress[y][z] = Integer.parseInt(str);
            }
        }

        try {
            FileOutputStream fOut = openFileOutput("GameData.txt", Context.MODE_PRIVATE);
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    fOut.write(solution[i][j]);
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    fOut.write(game[i][j]);
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    fOut.write(progress[i][j]);
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveGame(View view) {
        c.stop();
        start.setVisibility(start.VISIBLE);
        pause.setVisibility(pause.GONE);
        current_time=c.getText().toString();
        saveGame_code();
        Toast.makeText(this, "Game Progress Saved Successfully!", Toast.LENGTH_LONG).show();
        finish();
        
    }

    public void solutionDisplay(View view) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (game[i][j] != 0) {
                    setInitialValue(game[i][j], i + 1, j + 1);
                } else if (solution[i][j] != 0)
                    setSolutionValue(solution[i][j], i + 1, j + 1);
            }
        }
    }

    public void setSolutionValue(int num,int i,int j) {
        TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout);
        EditText obj1 = obj2.findViewWithTag(Integer.toString(10 * i + j));
        obj1.setText(String.valueOf(num));
        obj1.setTypeface(null, Typeface.NORMAL);


    }


    public void themes(View view) {
        c.stop();
        start.setVisibility(start.VISIBLE);
        pause.setVisibility(pause.GONE);
        current_time=c.getText().toString();
        saveGame_code();
        Intent obj = new Intent(this, ThemesActivity.class);
        finish();
        startActivity(obj);
    }
}