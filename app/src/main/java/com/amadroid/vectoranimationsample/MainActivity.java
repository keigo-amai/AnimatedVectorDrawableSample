package com.amadroid.vectoranimationsample;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        findViewById(R.id.heart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view instanceof Button) {

                    Button button = (Button) view;

                    Drawable drawable = button.getBackground();

                    if (drawable instanceof AnimatedVectorDrawable) {
                        if (((AnimatedVectorDrawable) drawable).isRunning()) return;

                        int drawableResId = button.isSelected() ? R.drawable.fill_in_heart : R.drawable.fill_in_heart_reverse;
                        button.setBackground(getDrawable(drawableResId));

                        drawable = button.getBackground();
                        ((AnimatedVectorDrawable) drawable).start();

                        button.setSelected(!button.isSelected());

                    }
                }
            }
        });

    }

}
