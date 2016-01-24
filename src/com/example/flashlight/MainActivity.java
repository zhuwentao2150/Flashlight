package com.example.flashlight;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	boolean isFlash;	// ��������Ϊtrueʱ����false��
	Camera camera;
	Button mButtonOpenOrClose;	// ���ƿ���
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButtonOpenOrClose = (Button) findViewById(R.id.open_flashlight);
		camera = Camera.open();
		isFlash = true;
	}
	/**
	 * �����ֵ�Ͳ
	 * @param v
	 */
	public void openOrClose(View v){
		if(isFlash){
			Parameters mParameters = camera.getParameters();
			// �����ֵ�Ͳ��״̬
			mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
			camera.setParameters(mParameters);
			mButtonOpenOrClose.setText("�ر��ֵ�Ͳ");
			isFlash = false;
		}else{
			Parameters mParameterss = camera.getParameters();
			mParameterss.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
			camera.setParameters(mParameterss);
			mButtonOpenOrClose.setText("���ֵ�Ͳ");
			isFlash = true;
		}	
	}
	
	// Ӧ���˳��͹ر�
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		camera.release();	// �ͷ��ֵ�Ͳ
	}
	

	

}
