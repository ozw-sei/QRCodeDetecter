package com.example.camera;

public interface ARCamera extends Camera
{
	/**
	 * ARCamera switching
	 *
	 * @param state
	 */
	public void setARState( boolean state );

	/**
	 * get Preview Picture
	 *
	 * @return PreviewPicture
	 */
	public PreviewPicture getPreviewPicture();

}
