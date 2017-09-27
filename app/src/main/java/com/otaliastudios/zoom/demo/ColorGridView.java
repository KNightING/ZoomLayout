package com.otaliastudios.zoom.demo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.Random;


public class ColorGridView extends GridLayout {

    private final static int ROWS = 20;
    private final static int COLS = 20;
    private final static Random R = new Random();

    public ColorGridView(@NonNull Context context) {
        this(context, null);
    }

    public ColorGridView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorGridView(@NonNull final Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setRowCount(ROWS);
        setColumnCount(COLS);
        for (int row = 0; row < ROWS; row++) {
            Spec rowSpec = spec(row);
            for (int col = 0; col < COLS; col++) {
                Spec colSpec = spec(col);
                LayoutParams params = new GridLayout.LayoutParams(rowSpec, colSpec);
                params.width = 150;
                params.height = 150;
                View view = createView(context);
                addView(view, params);
            }
        }
    }

    private static View createView(final Context context) {
        View view = new View(context);
        final int r = 200 + R.nextInt(55);
        final int g = 100 + R.nextInt(100);
        final int b = 50 + R.nextInt(100);
        int color = Color.rgb(r, g, b);
        view.setBackground(new ColorDrawable(color));
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(context,
                //     "Blackening R: " + r + " G:" + g + " B:" + b,
                //     Toast.LENGTH_SHORT).show();
                view.setBackgroundColor(Color.BLACK);
            }
        });
        return view;
    }

}