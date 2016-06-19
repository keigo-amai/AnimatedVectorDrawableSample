package com.amadroid.vectoranimationsample.view;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.amadroid.vectoranimationsample.R;

/**
 * Created by Keigo Amai on 2016/06/20.
 */
public class AnimationButton extends Button implements View.OnClickListener {

    public AnimationButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setOnClickListener(this);
    }

    public AnimationButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    @Override
    public void onClick(View view) {

        if (view instanceof Button) {

            Button button = (Button) view;

            Drawable drawable = button.getBackground();

            if (drawable instanceof AnimatedVectorDrawable) {
                if (((AnimatedVectorDrawable) drawable).isRunning()) return;

                int drawableResId = button.isSelected() ? R.drawable.fill_in_heart : R.drawable.fill_in_heart_reverse;
                button.setBackground(getContext().getDrawable(drawableResId));

                drawable = button.getBackground();
                ((AnimatedVectorDrawable) drawable).start();

                button.setSelected(!button.isSelected());

            }
        }
    }
}
