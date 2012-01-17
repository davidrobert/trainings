package br.com.while42.studantcontacts.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class IndicatorBar extends View implements OnTouchListener {

	private static final float MIN_WIDTH = 200;
	private static final float MIN_HEIGHT = 30;
	
	private float x = 0;
	
	public float getRating() {
		return x;
	}

	public void setRating(float x) {
		if (x < 0) {
			x = 0;
		} else if (x > 100) {
			x = 100;
		} else { 
			this.x = x;
		}
	}
	
	private void setValue(float value) {
		setRating((value / getWidth()) * 100);
	}
	
	private float getValue() {
		return (getRating() / 100) * getWidth();
	}
	
		
	public IndicatorBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		setMinimumHeight((int) MIN_HEIGHT);
		setMinimumWidth((int) MIN_WIDTH);
		
		setOnTouchListener(this);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.drawColor(Color.CYAN);
		
		Paint color = new Paint();
		color.setColor(Color.RED);
		
		RectF retangulo = new RectF(
				0, // esquerda
				0, //
				getValue(), //
				MIN_HEIGHT); // altura
		
		canvas.drawRect(retangulo, color);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			setValue(event.getX());
			invalidate();
			// Neste caso o true PERMITE que seja propagado o evento!
			return true;
			
		} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
			setValue(event.getX());
			invalidate();
			// Neste caso o false NAO PERMITE que seja propagado o evento!
			return false;
		}
		
		// Neste caso o false NAO PERMITE que seja propagado o evento!
		return true; 
	}
	

}
