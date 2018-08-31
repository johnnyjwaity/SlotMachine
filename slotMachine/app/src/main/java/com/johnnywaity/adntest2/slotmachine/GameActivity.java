package com.johnnywaity.adntest2.slotmachine;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements OnGestureListener {

    GestureDetector gestureDetector;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);



        gestureDetector = new GestureDetector(GameActivity.this, GameActivity.this);

        final ImageView lever = (ImageView) findViewById(R.id.imageView);

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
