package com.example.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.view.ViewGroup.*;

public class MyActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

		Preview preview = new Preview(this);
		setContentView(preview);

		OverlayView overlayView = new OverlayView(this);
		// オーバーレイビューを設定
		addContentView(
				overlayView, new AbsListView.LayoutParams( LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT ) );
    }
}
