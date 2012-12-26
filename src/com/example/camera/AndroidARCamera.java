package com.example.camera;

import android.hardware.Camera;
import android.view.SurfaceHolder;

import java.io.IOException;


public class AndroidARCamera implements ARCamera
{
	//Hard Ware Camera
	Camera mCamera;
	boolean mARState = true;

	@Override
	public void createCamera( SurfaceHolder holder ) {
		mCamera = Camera.open();

		try {
			mCamera.setPreviewDisplay( holder );
			mCamera.autoFocus(autoFocusCallback);
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	@Override
	public void releaseCamera() {
		mCamera.release();
	}

	@Override
	public void startPreview() {
		mCamera.startPreview();
	}

	@Override
	public void stopPreview() {
		mCamera.stopPreview();
	}

	@Override
	public void setPreviewSize( int width, int height ) {
		Camera.Parameters param = mCamera.getParameters();
		param.setPreviewSize( width, height );

		mCamera.setParameters( param );
	}

	@Override
	public void setPreviewCallBack( Camera.PreviewCallback cb ) {
		mCamera.setPreviewCallback( cb );
	}

	@Override
	public void setARState( boolean state ) {
		mARState = state;

	}

	@Override
	public PreviewPicture getPreviewPicture() {
		return null;
	}
	Camera.AutoFocusCallback autoFocusCallback = new Camera.AutoFocusCallback()
	{
		@Override
		public void onAutoFocus( boolean b, Camera camera ) {
			camera.autoFocus(null);
		}
	};

}
