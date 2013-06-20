package com.adruijter.kingsvalley1;

import com.adruijter.kingsvalley1.screens.GameScreen;
import com.adruijter.kingsvalley1.screens.SplashScreen;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.Application.ApplicationType;

public class KingsValley1 extends Game 
{	
	//Fields
	private SpriteBatch batch;
	private GameScreen gameScreen;
	private SplashScreen splashScreen;
	private static boolean isAndroid = true;
	private Color backgroundColor = new Color(0.125f, 0.125f, 0.957f, 1f);
	
	
	//Properties
	public static boolean IsAndroid()
	{
		return isAndroid;
	}
	public GameScreen getGameScreen() {
		return gameScreen;
	}
	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}

	public SpriteBatch getBatch() {
		return batch;
	}
	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}
	
	public SplashScreen getSplashScreen() {
		return splashScreen;
	}
	public void setSplashScreen(SplashScreen splashScreen) {
		this.splashScreen = splashScreen;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	@Override
	public void create() {
		this.batch = new SpriteBatch();
		this.splashScreen = new SplashScreen(this);
		this.gameScreen = new GameScreen(this);
		this.setScreen(this.gameScreen);
		switch(Gdx.app.getType())
		{
		   case Android:
			   isAndroid = true;
		   case Desktop:
			   isAndroid = false;
		   case WebGL:
			   isAndroid = false;
		}
	}

	
	@Override
	public void dispose() {
		this.batch.dispose();
		this.gameScreen.dispose();
		this.splashScreen.dispose();
		super.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0.06f, 0.06f, 0.06f, 1f);
		//Gdx.gl.glClearColor(this.backgroundColor.r, this.backgroundColor.g, this.backgroundColor.b, this.backgroundColor.a);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		for (int i = 0; i < 1000000; i++)
		{
			//double x = Math.pow(Math.PI, Math.PI);
		}
		super.render();		
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
