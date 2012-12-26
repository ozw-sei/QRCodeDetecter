package com.example.camera;

/**
 * Created by IntelliJ IDEA.
 * User: MacBookAirUser
 * Date: 2012/12/26
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */
public class PreviewPicture
{
	byte[] mYUV;

	public PreviewPicture() {
	}
	public void setYUV(byte[] yuv){
		mYUV = yuv;
	}
}
