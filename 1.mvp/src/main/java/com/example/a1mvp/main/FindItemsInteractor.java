package com.example.a1mvp.main;

import java.util.List;

/**
 * Created by ADMIN on 9/28/2017.
 */

public interface FindItemsInteractor {

    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    void findItems(OnFinishedListener listener);
}
