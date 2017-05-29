package com.esp.mcbooksclone.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.RelativeLayout;

import com.esp.mcbooksclone.R;

import me.dm7.barcodescanner.core.IViewFinder;
import me.dm7.barcodescanner.core.ViewFinderView;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

/**
 * Created by Hoa's PC on 5/29/2017.
 */

public class ScannerView extends ZBarScannerView {

    public ScannerView(Context context) {
        super(context);
    }

    private class QrView extends ViewFinderView{

        public QrView(Context context) {
            super(context);
        }

        @Override
        public void onDraw(Canvas canvas) {
            if(getFramingRect() == null){

            }
        }
    }

    @Override
    protected IViewFinder createViewFinderView(Context context) {
        return new QrView(context);
    }

    public static class FrontCameraView extends RelativeLayout {
        public FrontCameraView(Context context) {
            super(context);
            inflate(context, R.layout.item_view_front_camera, this);
        }
    }


}
