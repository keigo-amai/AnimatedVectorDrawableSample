package com.amadroid.vectoranimationsample.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.amadroid.vectoranimationsample.R;

/**
 * 押したらベクターアニメーションがスタートするView
 * app:ResourceNameでdrawableリソース名を指定したら勝手にリバースも指定してくれる.
 *
 * Created by Keigo Amai on 2016/06/20.
 */
public class AnimationButton extends Button implements View.OnClickListener {

    private static final String REVERSE_SUFFIX = "_reverse";
    private String mResName;

    public AnimationButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setOnClickListener(this);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.AnimationButton,
                0, 0);

        try {
            mResName = a.getString(R.styleable.AnimationButton_ResourceName);
        } finally {
            a.recycle();
        }
    }

    public AnimationButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    @Override
    public void onClick(View view) {

        Drawable drawable = view.getBackground();

        if (drawable instanceof AnimatedVectorDrawable) {
            if (((AnimatedVectorDrawable) drawable).isRunning()) return;

            String stateResName = view.isSelected() ? mResName + REVERSE_SUFFIX : mResName;
            int drawableResId = getResources().getIdentifier(stateResName, "drawable", getContext().getPackageName());
            view.setBackground(getContext().getDrawable(drawableResId));

            drawable = view.getBackground();
            ((AnimatedVectorDrawable) drawable).start();

            view.setSelected(!view.isSelected());

        }
    }
}
