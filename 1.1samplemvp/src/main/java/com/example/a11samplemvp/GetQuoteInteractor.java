package com.example.a11samplemvp;

import android.content.Context;

/**
 * Created by ADMIN on 9/28/2017.
 */

public interface GetQuoteInteractor {

    interface OnFinishedListener {
        void onFinished(String string);
    }

    void getNextQuote(OnFinishedListener listener);
    //void getNextQuote(Context context);
}
