package org.camera.camera.preview;

import org.camera.camera.CameraInterface;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
	private static final String TAG = "CameraSurfaceView";
	CameraInterface mCameraInterface;
	Context mContext;
	SurfaceHolder mSurfaceHolder;
	@SuppressWarnings("deprecation")
	public CameraSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		mSurfaceHolder = getHolder();
		mSurfaceHolder.setFormat(PixelFormat.TRANSPARENT);//translucent��͸�� transparent͸��
		mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		mSurfaceHolder.setKeepScreenOn(true);//������Ļ����,��������Ļ
		mSurfaceHolder.addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Log.i(TAG, "surfaceCreated...");
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.i(TAG, "surfaceChanged........_____width:"+width+"....____height:"+height);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.i(TAG, "surfaceDestroyed...");
		CameraInterface.getInstance().doStopCamera();
	}
	public SurfaceHolder getSurfaceHolder(){
		return mSurfaceHolder;
	}
}
