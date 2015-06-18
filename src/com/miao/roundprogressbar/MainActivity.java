package com.miao.roundprogressbar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	private RoundProgressBar mRound;
	private int progress = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mRound = (RoundProgressBar) findViewById(R.id.roundbar1);

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (progress <= 100) {
					progress += 1;

					if (progress > 100)
						progress = 1;

					mRound.setProgress(progress);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
