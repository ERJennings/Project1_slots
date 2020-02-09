package com.example.project1_slots;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import 	java.util.Random;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    private int count;

    //private Animation animRotate1;
    //private ImageView myView;

    private ImageView resetView;
    private ImageView goView;
    private int flowermatch1;
    private int flowermatch2;
    private int flowermatch3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 5;
        resetView = findViewById(R.id.imageView2);
        resetView.setVisibility(View.INVISIBLE);

        //myView = findViewById(R.id.imageView4);

        //animRotate1 = AnimationUtils.loadAnimation(getApplicationContext(),
                //R.anim.rotate);
        //animRotate1.setAnimationListener(this);
    }

    public void onReset(View view) {
        count = constants.STARTUP_CASH;
        TextView newtext = findViewById(R.id.textView4);
        newtext.setText("$" + count);
        goView = findViewById(R.id.imageView);
        goView.setVisibility(View.VISIBLE);
        resetView = findViewById(R.id.imageView2);
        resetView.setVisibility(View.INVISIBLE);

    }

    public void onGo(View view) {
        count = count - constants.COST_PER_ROLL;


        ImageView image1 = findViewById(R.id.imageView4);
        image1.setImageResource(R.drawable.tmp);

        ImageView image2 = findViewById(R.id.imageView5);
        image2.setImageResource(R.drawable.tmp);

        ImageView image3 = findViewById(R.id.imageView6);
        image3.setImageResource(R.drawable.tmp);

        //myView.startAnimation(animRotate1);

        flowermatch1 = randomFlower(image1);
        flowermatch2 = randomFlower(image2);
        flowermatch3 = randomFlower(image3);

        count = count + numMatches(flowermatch1, flowermatch2, flowermatch3);
        TextView newtext = findViewById(R.id.textView4);
        newtext.setText("$" + count);

        if (count == constants.YOUR_BROKE) {
            goView = findViewById(R.id.imageView);
            goView.setVisibility(View.INVISIBLE);
        }

        resetView = findViewById(R.id.imageView2);
        resetView.setVisibility(View.VISIBLE);


    }

    public int randomFlower(ImageView view) {
        int[] flowers = {R.drawable.f1, R.drawable.f2 ,R.drawable.f3};
        Random im = new Random();
        int i = im.nextInt(constants.NUMB_FLOWERS);
        view.setImageResource(flowers[i]);

        return i;

    }

    private int numMatches(int a, int b, int c) {
        if  ((a == b) && (a == c)){
            return constants.MATCH_3;
        }
        else if ((a == b) || (b == c) || (a == c)) {
            return constants.MATCH_2;
        }
        else {
            return 0;
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

}