package com.root.mvp.mvpdemo.utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

public class MessageUtils {


    public void snackbar(String message, View view) {
        try {
            String output = message.substring(0, 1).toUpperCase() + message.substring(1);
            Snackbar snackbar1 = Snackbar.make(view, "" + output, Snackbar.LENGTH_SHORT);
            snackbar1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toast(Context context, String message) {
        try {
            if (!message.isEmpty() && message != null) {
                Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
