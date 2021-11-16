package com.training.siva.sudoku1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LosingActivity extends Activity {

    NewGame n=new NewGame();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losing);
        getInitialValues();
        Button b=findViewById(R.id.view_button);
        b.performClick();
        //TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout1);
       // solutionDisplay(obj2);
    }

    public int solution[][] = new int[9][9];
    public int game[][] = new int[9][9];
    public int progress[][] = new int[9][9];

    public void home(View view)
    {
        finish();
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
        TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout1);
        TextView obj1 = obj2.findViewWithTag(Integer.toString(10 * i + j));
        obj1.setText(String.valueOf(num));
        obj1.setTypeface(null, Typeface.BOLD);
        obj1.setFocusable(false);
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
        TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout1);
        TextView obj1 = obj2.findViewWithTag(Integer.toString(10 * i + j));
        obj1.setText(String.valueOf(num));
        obj1.setTypeface(null, Typeface.NORMAL);
        //obj1.setEnabled(false);

    }


}
   /* public void solutionDisplay(View view) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (n.game[i][j] != 0) {
                    n.setInitialValue(n.game[i][j], i + 1, j + 1);
                } else if (n.solution[i][j] != 0)
                    setSolutionValue(n.solution[i][j], i + 1, j + 1);
            }
        }
    }

    public void setSolutionValue(int num,int i,int j) {
        TableLayout obj2 = (TableLayout) findViewById(R.id.tableLayout1);
        TextView obj1 = obj2.findViewWithTag(Integer.toString(10 * i + j));
        obj1.setText(String.valueOf(num));
        obj1.setTypeface(null, Typeface.NORMAL);
    }*/

