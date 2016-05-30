package com.example.annuoaichengzhang.androiddevelopartdemo;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

/**
 * Created by niehongtao on 16/5/30.
 */
public class FreshDialog {
    private PopupWindow dialog;
    private Activity activity;

    public FreshDialog(Activity activity) {
        this.activity = activity;
        View view = View.inflate(activity, R.layout.new_layout_progress, null);
        this.dialog = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    public void showDialog(View parent) {
        if(null ==activity  || activity.isFinishing()) {
            return;
        }
        dialog.setFocusable(false);
        dialog.showAtLocation(parent, Gravity.CENTER, 0, 0);
    }

    public boolean isShowing() {
        if (dialog == null) {
            return false;
        }
        return dialog.isShowing();
    }

    public void dismiss() {
        if (dialog == null) {
            return;
        }

        if (isShowing()) {
            dialog.dismiss();
        }
    }
}
