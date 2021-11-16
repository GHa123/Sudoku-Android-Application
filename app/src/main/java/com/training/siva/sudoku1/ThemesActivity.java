package com.training.siva.sudoku1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ThemesActivity extends AppCompatActivity implements View.OnClickListener {

    public static String x="t1";
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);
        setTitle("Themes");


        img1=findViewById(R.id.t1);
        img2=findViewById(R.id.t2);
        img3=findViewById(R.id.t3);
        img4=findViewById(R.id.t4);
        img5=findViewById(R.id.t5);
        img6=findViewById(R.id.t6);
        img7=findViewById(R.id.t7);
        img8=findViewById(R.id.t8);
        img9=findViewById(R.id.t9);
        img10=findViewById(R.id.t10);
        img11=findViewById(R.id.t11);
        img12=findViewById(R.id.t12);
        img13=findViewById(R.id.t13);
        img14=findViewById(R.id.t14);
        img15=findViewById(R.id.t15);
        img16=findViewById(R.id.t16);
        img17=findViewById(R.id.t17);
        img18=findViewById(R.id.t18);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);
        img9.setOnClickListener(this);
        img10.setOnClickListener(this);
        img11.setOnClickListener(this);
        img12.setOnClickListener(this);
        img13.setOnClickListener(this);
        img14.setOnClickListener(this);
        img15.setOnClickListener(this);
        img16.setOnClickListener(this);
        img17.setOnClickListener(this);
        img18.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.t1)
        {
            x="t1";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t2)
        {
            x="t2";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t3)
        {
            x="t3";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t4)
        {
            x="t4";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t5)
        {
            x="t5";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t6)
        {
            x="t6";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t7)
        {
            x="t7";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t8)
        {
            x="t8";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t9)
        {
            x="t9";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t10)
        {
            x="t10";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t11)
        {
            x="t11";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t12)
        {
            x="t12";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t13)
        {
            x="t13";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t14)
        {
            x="t14";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t15)
        {
            x="t15";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t16)
        {
            x="t16";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t17)
        {
            x="t17";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

        else if(view.getId()==R.id.t18)
        {
            x="t18";
            Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
            finish();
            startActivity(in);
        }

    }
    public void onBackPressed()
    {
        Intent in=new Intent(ThemesActivity.this,ContinueGame.class);
        finish();
        startActivity(in);
    }
}
