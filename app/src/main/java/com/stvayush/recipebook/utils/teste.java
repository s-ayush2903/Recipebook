package com.stvayush.recipebook.utils;

import android.view.View;
import android.widget.ProgressBar;

/**
 * Authored by s-ayush2903 on 16/7/20
 */

class teste {
    // for testing purposes
    private ProgressBar progressBar;

    private void showProgressBar(boolean visible) {
        progressBar.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }
}
