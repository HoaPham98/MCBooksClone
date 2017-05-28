package com.esp.mcbooksclone;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Hoa's PC on 5/27/2017.
 */

public class NotFoundDialog extends DialogFragment {

    public ScannerListener mScannerListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        setCancelable(false);
        return inflater.inflate(R.layout.dialog_not_found_book, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tryAgainBtn = (TextView) view.findViewById(R.id.btn_timlai);
        tryAgainBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onTryAgain(v);
            }
        });

    }

    public void onTryAgain(View v){
        dismiss();
        this.mScannerListener = (ScannerListener) getActivity();
        if(this.mScannerListener != null){
            mScannerListener.reseumCamera();
        }
    }
}
