package com.example.camera;

import android.hardware.Camera.PreviewCallback;
import android.util.Log;
import com.example.QR.QRReader;

public class CameraPreview implements PreviewCallback
{
    public static final String TAG = "CameraPreview";
    final int mPreviewWidth;
    final int mPreviewHeight;
    QRReader mReader = new QRReader();

    /**
     * CameraPreviewSize
     *
     * @param previewWidth
     *         プレビューの幅
     * @param previewHeight
     *         プレビューの高さ
     */
    public CameraPreview( int previewWidth, int previewHeight ) {
        mPreviewHeight = previewHeight;
        mPreviewWidth = previewWidth;
    }

    @Override
    public void onPreviewFrame( byte[] bytes, android.hardware.Camera camera ) {

        try {
            mReader.readYUV( bytes, mPreviewWidth, mPreviewHeight, 0, 0, mPreviewWidth, mPreviewHeight, false );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        if ( QRReader.isFound() ) {
            Log.d( TAG, "found" );
        }
    }

}
