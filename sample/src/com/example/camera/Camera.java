package com.example.camera;

import android.view.SurfaceHolder;

public interface Camera
{
	/**
	 * create CameraInstances
	 *
	 * @return return CameraInstance
	 */
	public void createCamera( SurfaceHolder holder );

	/** release CameraInstance */
	public void releaseCamera();

	/** start CameraPreview */
	public void startPreview();

	/** stop CameraPreview */
	public void stopPreview();

	public void setPreviewSize( int width, int height );

	public void setPreviewCallBack(android.hardware.Camera.PreviewCallback cb);
}
