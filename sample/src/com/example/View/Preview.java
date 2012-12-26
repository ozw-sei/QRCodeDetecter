package com.example.View;

import android.content.Context;
import android.view.SurfaceHolder;
import com.example.camera.CameraPreview;
import com.example.camera.AndroidARCamera;
import com.example.camera.Camera;
import android.view.SurfaceView;


public class Preview extends SurfaceView implements SurfaceHolder.Callback
{
	Camera mCamera;

	/**
	 * コンストラクタ
	 * @param context
	 */
	public Preview( Context context ) {
		super( context );

		getHolder().addCallback(this);
		getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	/**
	 * Surface が生成された際にCallBackされる
	 * @param surfaceHolder
	 */
	@Override
	public void surfaceCreated( SurfaceHolder surfaceHolder ) {
		mCamera = new AndroidARCamera();
		mCamera.createCamera(getHolder());
		mCamera.setPreviewSize(800,480);
		CameraPreview previewCB = new CameraPreview(800,480);
		mCamera.setPreviewCallBack(previewCB);
	}

	/**
	 * Surfaceの状態が変わった際に呼ばれる
	 * @param surfaceHolder
	 * @param i
	 * @param i1
	 * @param i2
	 */
	@Override
	public void surfaceChanged( SurfaceHolder surfaceHolder, int i, int i1, int i2 ) {
		mCamera.startPreview();
	}

	/**
	 * Surfaceが破棄された際に呼ばれる
	 * @param surfaceHolder
	 */
	@Override
	public void surfaceDestroyed( SurfaceHolder surfaceHolder ) {
		mCamera.stopPreview();
	}
}
