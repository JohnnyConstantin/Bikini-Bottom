package ru.samsung.itschool.book.cells;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Arrays;

import task.Task;


public class CellsActivity extends Activity implements OnClickListener,
        OnLongClickListener {

     int WIDTH = 9;
     int HEIGHT = 14;

     Button[][] cells;
     int[][] Bomb = new int[HEIGHT][WIDTH];
     int[][] flag = new int[HEIGHT][WIDTH];
     int[][] Drawn = new int [HEIGHT][WIDTH];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();
        generate();

    }

    void generate() {
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                Bomb[i][j] = 0;
                Drawn[i][j] = 0;
                flag[i][j] = 0;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    cells[i][j].setBackgroundColor(Color.argb(0.0f, 58.82f, 29.41f, 0.0f));
                } else {
                    cells[i][j].setBackgroundColor(Color.BLACK);
                }

                if (Math.random() <= 0.15) {
                    Bomb[i][j] = 1;
                }

            }
    }

    @Override
    public boolean onLongClick(View v) {
        Button tappedCell = (Button) v;

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);

        cells[tappedY][tappedX].setBackgroundResource(R.drawable.set_flag);
        flag[tappedY][tappedX] = 1;

        Object[][] arr1 = {flag};
        Object[][] arr2 = {Bomb};
        if (Arrays.deepEquals(arr1, arr2)){
            Task.showMessage(this, "U won");
            generate();
        }
        return true;
    }

    private void check(int i, int j){
        if(i < 0 || i >= HEIGHT || j < 0 || j >= WIDTH || Drawn[i][j] == 1 || Bomb[i][j] ==1) {
            return;
        }
        cells[i][j].setBackgroundColor(Color.WHITE);
        Drawn[i][j] = 1;
        flag[i][j] = 0;
        int Bomb_Count = 0;
        for (int a = i - 1; a <= i + 1; a ++){
            for (int b = j - 1; b <= j + 1; b ++){
                if (a >= 0 && a < HEIGHT && b >= 0 && b < WIDTH) {
                    Bomb_Count += Bomb[a][b];
                }
            }
        }
        if (Bomb_Count == 0){
            check(i - 1, j - 1);
            check(i - 1, j );
            check(i - 1, j + 1);
            check(i, j - 1);
            check(i , j + 1);
            check(i + 1, j -1 );
            check(i + 1, j);
            check(i + 1, j + 1);
        } else {
            cells[i][j].setText(Bomb_Count + "");
        }
    }

    @Override
    public void onClick(View v) {


        Button tappedCell = (Button) v;

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        flag[tappedY][tappedX] = 0;
        if(Bomb[tappedY][tappedX] == 1){
            Task.showMessage(this, "U blowed up");
            makeCells();
            generate();
        } else {
            cells[tappedY][tappedX].setBackgroundColor(Color.WHITE);
            Drawn[tappedY][tappedX] = 1;
            int Bomb_Count = 0;
            for(int i = tappedY - 1; i <= tappedY; i ++){
                for(int j = tappedX - 1; j <= tappedX; j++){
                    if(i >= 0 && i < HEIGHT && j >= 0 && j < WIDTH){
                        Bomb_Count += Bomb[i][j];
                    }
                }
            }
            if(Bomb_Count == 0){
                check(tappedY - 1, tappedX - 1);
                check(tappedY - 1, tappedX );
                check(tappedY - 1, tappedX + 1);
                check(tappedY, tappedX - 1);
                check(tappedY , tappedX + 1);
                check(tappedY + 1, tappedX -1 );
                check(tappedY + 1, tappedX);
                check(tappedY + 1, tappedX + 1);
            } else {
                cells[tappedY][tappedX].setText(Bomb_Count + "");
            }
        }
    }


    int getX(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }

    int getY(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }

    void makeCells() {
        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(WIDTH);
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
    }

}