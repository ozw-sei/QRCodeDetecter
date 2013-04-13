package com.example.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import com.example.BoundingRect;
import com.example.QR.QRReader;
import com.example.QR.QRResult;

public class OverlayView extends View
{
    public static final String TAG = "OverlayView";

    public OverlayView( Context context ) {
        super( context );
    }


    @Override
    protected void onDraw( Canvas canvas ) {
        super.onDraw( canvas );
        Log.d( TAG, "onDraw" );

        if ( QRReader.isFound() ) {
            Paint paint = new Paint();
            QRResult result = QRReader.getQRResult();

            BoundingRect boundingRect = new BoundingRect( BoundingRect.SCREEN_ORIENTATION.LAND_SCAPE );
            boundingRect.setRect( result.getMarkerPosition() );
            boundingRect.setScaleRate( 1280, 720, 800, 480 );

            boundingRect.draw( canvas, paint );
        }
        invalidate();
    }
}
