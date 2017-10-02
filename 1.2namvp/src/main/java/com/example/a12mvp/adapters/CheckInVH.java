package com.example.a12mvp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.a12mvp.R;

/**
 * Created by ADMIN on 9/29/2017.
 */

public class CheckInVH extends RecyclerView.ViewHolder {

    private TextView tvMsg_LICI;
    private TextView tvAuthor_LICI;

    public CheckInVH(View itemView) {
        super(itemView);

        tvMsg_LICI = (TextView) itemView.findViewById(R.id.tvMsg_LICI);
        tvAuthor_LICI = (TextView) itemView.findViewById(R.id.tvAuthor_LICI);
    }

    public void bindData(CheckIn checkIn) {
        tvMsg_LICI.setText(TextUtils.isEmpty(checkIn.checkInMessage) ? "Empty" : checkIn.checkInMessage);
        tvAuthor_LICI.setText(TextUtils.isEmpty(checkIn.email) ? "Anonymous" : checkIn.email);
    }
}
