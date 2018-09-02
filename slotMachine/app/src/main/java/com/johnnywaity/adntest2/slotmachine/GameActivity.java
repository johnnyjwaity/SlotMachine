package com.johnnywaity.adntest2.slotmachine;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import gameplay.SlotIcons;

public class GameActivity extends AppCompatActivity implements OnGestureListener {

    GestureDetector gestureDetector;

//test comment

    private ArrayList<Integer> imgArray = new ArrayList<>();
    private int[][] dataArray = new int[3][3];
    private boolean killFirstCol = false;
    private boolean killSecondCol = false;
    private boolean killThirdCol = false;
    private boolean slowDownFC = false;
    private boolean slowDownSC = false;
    private boolean slowDownTC = false;
    private int imgTime = 100;

    private void killFC(){
        killFirstCol = true;
    }

    private void killSC(){
        killSecondCol = true;
    }

    private void killTC(){
        killThirdCol = true;
    }

    private void scrollImages(final SlotIcons res1, SlotIcons res2, SlotIcons res3) {
        System.out.println("yo");

        final ImageView lever = (ImageView) findViewById(R.id.imageView);
        final ImageView topslot1 = (ImageView) findViewById(R.id.topslot1);
        final ImageView topslot2 = (ImageView) findViewById(R.id.topslot2);
        final ImageView topslot3 = (ImageView) findViewById(R.id.topslot3);
        final ImageView midslot1 = (ImageView) findViewById(R.id.midslot1);
        final ImageView midslot2 = (ImageView) findViewById(R.id.midslot2);
        final ImageView midslot3 = (ImageView) findViewById(R.id.midslot3);
        final ImageView botslot1 = (ImageView) findViewById(R.id.botslot1);
        final ImageView botslot2 = (ImageView) findViewById(R.id.botslot2);
        final ImageView botslot3 = (ImageView) findViewById(R.id.botslot3);

        final float initX = topslot1.getX();
        final float initY = topslot1.getY();


        topslot1.post(new Runnable() {
            int i =2;
            @Override
            public void run() {
                topslot1.setImageResource(imgArray.get(i));
                i++;
                if (i>5){
                    i=0;
                }
                if (!killFirstCol){
                    topslot1.postDelayed(this,imgTime);
                }


            }
        });

        topslot2.post(new Runnable() {
            int i =2;
            @Override
            public void run() {
                topslot2.setImageResource(imgArray.get(i));
                i++;
                if (i>5){
                    i=0;
                }
                if (!killSecondCol){
                    topslot2.postDelayed(this,imgTime);
                }


            }
        });

        topslot3.post(new Runnable() {
            int i =2;
            @Override
            public void run() {
                topslot3.setImageResource(imgArray.get(i));
                i++;
                if (i>5){
                    i=0;
                }
                if (!killThirdCol){
                    topslot3.postDelayed(this,imgTime);
                }


            }
        });

        midslot1.post(new Runnable() {
            int i =1;
            @Override
            public void run() {
                midslot1.setImageResource(imgArray.get(i));
                i++;
                if (i>5){
                    i=0;
                }
                if(!killFirstCol){
                    midslot1.postDelayed(this,imgTime);
                }
                if (slowDownFC){
                    imgTime = 500;
                    if (i==5){
                        killFC();
                    }
                }

            }
        });

        midslot2.post(new Runnable() {
            int i =1;
            @Override
            public void run() {
                midslot2.setImageResource(imgArray.get(i));
                i++;
                if (i>5){
                    i=0;
                }
                if(!killSecondCol){
                    midslot2.postDelayed(this,imgTime);
                }
                if (slowDownSC){
                    imgTime = 500;
                    if (i==2){
                        killSC();
                    }
                }

            }
        });

        midslot3.post(new Runnable() {
            int i =1;
            @Override
            public void run() {
                midslot3.setImageResource(imgArray.get(i));
                i++;
                if (i>5){
                    i=0;
                }
                if(!killThirdCol){
                    midslot3.postDelayed(this,imgTime);
                }
                if (slowDownTC){
                    imgTime = 500;
                    if (i==3){
                        killTC();
                    }
                }

            }
        });

        botslot1.post(new Runnable() {
            int i =0;
            @Override
            public void run() {
                botslot1.setImageResource(imgArray.get(i));
                i++;
                if (i>5){
                    i=0;
                }
                if (!killFirstCol){
                    botslot1.postDelayed(this,imgTime);
                }

            }
        });

        botslot2.post(new Runnable() {
            int i =0;
            @Override
            public void run() {
                botslot2.setImageResource(imgArray.get(i));
                i++;
                if (i>5){
                    i=0;
                }
                if (!killSecondCol){
                    botslot2.postDelayed(this,imgTime);
                }

            }
        });

        botslot3.post(new Runnable() {
            int i =0;
            @Override
            public void run() {
                botslot3.setImageResource(imgArray.get(i));
                i++;
                if (i>5){
                    i=0;
                }
                if (!killThirdCol){
                    botslot3.postDelayed(this,imgTime);
                }

            }
        });

        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                slowDownFC = true;
            }
        }.start();

        new CountDownTimer(7000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                slowDownSC = true;
            }
        }.start();

        new CountDownTimer(9000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                slowDownTC = true;
            }
        }.start();



    }

    private void handleActivate(){
        Button activatebtn = (Button) findViewById(R.id.activate);

        activatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollImages(SlotIcons.Bar, SlotIcons.Bell,SlotIcons.Bell);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        imgArray.add(R.drawable.img1);
        imgArray.add(R.drawable.img2);
        imgArray.add(R.drawable.img3);
        imgArray.add(R.drawable.img4);
        imgArray.add(R.drawable.img5);
        imgArray.add(R.drawable.img6);

        final ImageView lever = (ImageView) findViewById(R.id.imageView);
        final ImageView topslot1 = (ImageView) findViewById(R.id.topslot1);
        final ImageView topslot2 = (ImageView) findViewById(R.id.topslot2);
        final ImageView topslot3 = (ImageView) findViewById(R.id.topslot3);
        final ImageView midslot1 = (ImageView) findViewById(R.id.midslot1);
        final ImageView midslot2 = (ImageView) findViewById(R.id.midslot2);
        final ImageView midslot3 = (ImageView) findViewById(R.id.midslot3);
        final ImageView botslot1 = (ImageView) findViewById(R.id.botslot1);
        final ImageView botslot2 = (ImageView) findViewById(R.id.botslot2);
        final ImageView botslot3 = (ImageView) findViewById(R.id.botslot3);





        dataArray[0][0] = 2;
        dataArray[0][1] = 2;
        dataArray[0][2] = 2;
        dataArray[1][0] = 1;
        dataArray[1][1] = 1;
        dataArray[1][2] = 1;
        dataArray[2][0] = 0;
        dataArray[2][1] = 0;
        dataArray[2][2] = 0;

//        for (int i=0;i<dataArray.length;i++){
//            for (int j=0;j<dataArray[i].length;i++){
//                System.out.println();
//            }
//        }

        handleActivate();

        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                System.out.print(dataArray[i][j]);
            }
            System.out.println();
        }


//        topslot1.setImageDrawable(imgArray.get(0));



        gestureDetector = new GestureDetector(GameActivity.this, GameActivity.this);



//        final TextView text = (TextView)findViewById(R.id.text);
//

//        lever.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                if (!leverPulled){
////                    TranslateAnimation t = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f ,Animation.RELATIVE_TO_PARENT, 600f);
////                    t.setRepeatCount(0);
////                    t.setDuration(2500);
////                    t.getFillBefore();
////                    t.setFillAfter(true);
////                    t.setInterpolator(new AccelerateDecelerateInterpolator());
////                    lever.startAnimation(t);
////                Animation rotate = new RotateAnimation(0.0f, 90.0f,
////                        Animation.RELATIVE_TO_SELF, .0f, Animation.RELATIVE_TO_PARENT,
////                        .5f);
////                rotate.setRepeatCount(0);
////                rotate.setDuration(500);
////                rotate.getFillBefore();
////                rotate.setFillAfter(true);
////                rotate.setInterpolator(new AccelerateDecelerateInterpolator());
////                lever.startAnimation(rotate);
////
////                new CountDownTimer(500, 1000) {
////
////                    public void onTick(long millisUntilFinished) {
////                        text.setText("seconds remaining: " + millisUntilFinished / 1000);
////                    }
////
////                    public void onFinish() {
////                        text.setText("done!");
////
////                        Animation rotate = new RotateAnimation(90.0f, 0.0f,
////                                Animation.RELATIVE_TO_SELF, .0f, Animation.RELATIVE_TO_PARENT,
////                                .5f);
////                        rotate.setRepeatCount(0);
////                        rotate.setDuration(500);
////
////                        rotate.setFillAfter(true);
////                        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
////                        lever.startAnimation(rotate);
////
////                    }
////                }.start();
//
//                leverPulled = true;
//
//
//                Toast.makeText(getApplicationContext(), "You pressed the image", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {
        if (motionEvent1.getY() - motionEvent2.getY() > 50) {
            Toast.makeText(GameActivity.this, "You Swiped up!", Toast.LENGTH_LONG).show();
            return true;
        }
        final ImageView lever = (ImageView) findViewById(R.id.imageView);

        final TextView text = (TextView)findViewById(R.id.text);
        if (motionEvent2.getY() - motionEvent1.getY() > 50) {
        if (motionEvent1.getY() >= lever.getY()
            && motionEvent1.getY() <= lever.getHeight()
            && motionEvent1.getX() >= lever.getX()
            && motionEvent2.getX() <= lever.getWidth()){
            //if (motionEvent2.getY() <= lever.getHeight()){
                //if (motionEvent1.getY() >= lever.getY()){
                    //&& motionEvent2.getY() <= lever.getHeight()){
                    //&& motionEvent1.getX() >= lever.getX()
                    //&& motionEvent2.getX() <= lever.getWidth()){
                //

                Toast.makeText(GameActivity.this, "" + lever.getHeight(), Toast.LENGTH_LONG).show();
                //Toast.makeText(GameActivity.this, "" + motionEvent1.getY(), Toast.LENGTH_LONG).show();

                Animation rotate = new RotateAnimation(0.0f, 105.0f,
                        Animation.RELATIVE_TO_SELF, .0f, Animation.RELATIVE_TO_PARENT,
                        .3f);
                rotate.setRepeatCount(0);
                rotate.setDuration(500);
                rotate.getFillBefore();
                rotate.setFillAfter(true);
                rotate.setInterpolator(new AccelerateDecelerateInterpolator());
                lever.startAnimation(rotate);

                new CountDownTimer(500, 1000) {

                    public void onTick(long millisUntilFinished) {
                        text.setText("seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        text.setText("done!");

                        Animation rotate = new RotateAnimation(105.0f, 0.0f,
                                Animation.RELATIVE_TO_SELF, .0f, Animation.RELATIVE_TO_PARENT,
                                .3f);
                        rotate.setRepeatCount(0);
                        rotate.setDuration(500);

                        rotate.setFillAfter(true);
                        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
                        lever.startAnimation(rotate);

                    }
                }.start();
                //
            }

            //Toast.makeText(GameActivity.this, "You Swiped Down!", Toast.LENGTH_LONG).show();
            return true;
        }

        if (motionEvent1.getX() - motionEvent2.getX() > 50) {
            Toast.makeText(GameActivity.this, "You Swiped Left!", Toast.LENGTH_LONG).show();
            return true;
        }
        if (motionEvent2.getX() - motionEvent1.getX() > 50) {
            Toast.makeText(GameActivity.this, "You Swiped Right!", Toast.LENGTH_LONG).show();
            return true;
        } else {
            return true;
        }
    }

    @Override
    public void onLongPress(MotionEvent arg0) {

    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {

        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        return gestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        //Toast.makeText(GameActivity.this, "You Swiped TEST!", Toast.LENGTH_LONG).show();
        //
//        final ImageView lever = (ImageView) findViewById(R.id.imageView);
//
//        final TextView text = (TextView)findViewById(R.id.text);
//
//
//        Animation rotate = new RotateAnimation(0.0f, 90.0f,
//                Animation.RELATIVE_TO_SELF, .0f, Animation.RELATIVE_TO_PARENT,
//                .5f);
//        rotate.setRepeatCount(0);
//        rotate.setDuration(500);
//        rotate.getFillBefore();
//        rotate.setFillAfter(true);
//        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
//        lever.startAnimation(rotate);
//
//        new CountDownTimer(500, 1000) {
//
//            public void onTick(long millisUntilFinished) {
//                text.setText("seconds remaining: " + millisUntilFinished / 1000);
//            }
//
//            public void onFinish() {
//                text.setText("done!");
//
//                Animation rotate = new RotateAnimation(90.0f, 0.0f,
//                        Animation.RELATIVE_TO_SELF, .0f, Animation.RELATIVE_TO_PARENT,
//                        .5f);
//                rotate.setRepeatCount(0);
//                rotate.setDuration(500);
//
//                rotate.setFillAfter(true);
//                rotate.setInterpolator(new AccelerateDecelerateInterpolator());
//                lever.startAnimation(rotate);
//
//            }
//        }.start();
        //
        return false;
    }

}
