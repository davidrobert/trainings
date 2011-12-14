package br.com.while42.view;

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

	private static final float MAX_LARGURA = 200;
	private static final float MAX_ALTURA = 30;
	
	private float x;
	
	public float getRating() {
		return x;
	}

	public void setRating(float x) {
		this.x = x;
	}
	
	public IndicatorBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		setMinimumHeight((int) MAX_ALTURA);
		setMinimumWidth((int) MAX_LARGURA);
		
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
				x, //
				MAX_ALTURA); // altura
		
		canvas.drawRect(retangulo, color);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			x = event.getX();
			invalidate();
			// Neste caso o true PERMITE que seja propagado o evento!
			return true;
			
		} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
			x = event.getX();
			invalidate();
			// Neste caso o false NAO PERMITE que seja propagado o evento!
			return false;
		}
		
		// Neste caso o false NAO PERMITE que seja propagado o evento!
		return true; 
	}
	

}
