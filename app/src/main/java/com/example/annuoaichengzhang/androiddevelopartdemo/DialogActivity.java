package com.example.annuoaichengzhang.androiddevelopartdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        findViewById(R.id.dialog1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1();
            }
        });

        findViewById(R.id.dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2();
            }
        });

        findViewById(R.id.dialog3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog3();
            }
        });

        findViewById(R.id.dialog4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog4();
            }
        });

        findViewById(R.id.dialog5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog5();
            }
        });

    }


    /**
     * 多按钮对话框
     */
    private void dialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("确定对话框");
        builder.setMessage("测试对话框");
        builder.setPositiveButton("好评",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.setNegativeButton("差评", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNeutralButton("点赞", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setIcon(R.mipmap.ic_launcher);
        builder.show();
    }

    /**
     * 单选对话框
     */
    private void dialog2() {
        String items[] = {"item1", "item2", "item3", "item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        int position = 0;
        builder.setTitle("单选对话框").setSingleChoiceItems(items, position, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    /**
     * 列表对话框
     */
    private void dialog3() {
        String items[] = {"item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("列表对话框").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //TODO 实现自己的需求
            }
        }).show();
    }

    /**
     * 添加自定义布局
     */
    private void dialog4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.items, null);
        final AlertDialog dialog = builder.create();
        dialog.setView(view);
        dialog.show();
        dialog.getWindow().findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    /**
     * 完全自定义对话框
     */
    private void dialog5() {
        final Dialog dialog = new Dialog(this);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.TOP);
        //得到对话框属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置对话框起点X轴
        lp.x = 100;
        //设置对话框起点Y轴
        lp.y = getStatusBarHeight() + getActionBarHeight();
        //设置对话框大小
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        //设置自定义对话框的布局
        dialog.setContentView(R.layout.items);
        window.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    /**
     * 得到手机状态栏高度
     *
     * @return
     */
    private int getStatusBarHeight() {
        Window dialogWindow = getWindow();
        Rect frame = new Rect();
        dialogWindow.getDecorView().getWindowVisibleDisplayFrame(frame);
        return frame.top;
    }

    /**
     * 得到actionbar的高度
     *
     * @return
     */
    private int getActionBarHeight() {
        return getSupportActionBar().getHeight();
    }

}
