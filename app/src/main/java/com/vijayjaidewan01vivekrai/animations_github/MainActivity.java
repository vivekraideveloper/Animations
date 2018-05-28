package com.vijayjaidewan01vivekrai.animations_github;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.animation.SpringAnimation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button translate, rotate, fade, spring, object, scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);
        translate = findViewById(R.id.translate);
        rotate = findViewById(R.id.rotate);
        scale = findViewById(R.id.scale);
        fade = findViewById(R.id.fade);
        spring = findViewById(R.id.spring);
        object = findViewById(R.id.object);

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TranslateAnimation animation = new TranslateAnimation(0f, 1000f, 0f, 0f);
                animation.setDuration(1000);
                animation.setFillEnabled(true);
                imageView.startAnimation(animation);
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RotateAnimation animation = new RotateAnimation(0f, 180f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setFillEnabled(false);
                animation.setDuration(1000);
                imageView.startAnimation(animation);
            }
        });

        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScaleAnimation animation = new ScaleAnimation(0f, 500f, 0f, 500f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f);
                animation.setFillAfter(true);
                animation.setDuration(8000);
                imageView.startAnimation(animation);
            }
        });

        spring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpringAnimation animation = new SpringAnimation(imageView, SpringAnimation.TRANSLATION_Y, 100);
                animation.getSpring().setStiffness(1f);
                animation.getSpring().setDampingRatio(0.4f);
                animation.setStartVelocity(1000f);
                animation.start();
            }
        });

        fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0.2f);
                animator.start();
            }
        });

        object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animatorX = ObjectAnimator.ofFloat(imageView, "x", 400);
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageView, "x", 700);
                ObjectAnimator animatorZ = ObjectAnimator.ofFloat(imageView, "z", 820f);
                ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(imageView, View.ALPHA, 0.0f, 1f);
                ObjectAnimator animatorRotate = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
                animatorX.setDuration(1000);
                animatorY.setDuration(3000);
                animatorZ.setDuration(1000);
                animatorAlpha.setDuration(3000);
                animatorRotate.setDuration(1000);

//                Animating alone
//                animatorX.start();
//                animatorY.start();
//                animatorZ.start();
//                animatorAlpha.start();
//                animatorRotate.start();

//                Animating in set
                AnimatorSet set = new AnimatorSet();
                set.playTogether(animatorX, animatorY, animatorZ, animatorAlpha, animatorRotate);
                set.start();
            }
        });
    }
}
