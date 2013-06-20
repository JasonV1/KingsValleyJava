package com.adruijter.kingsvalley1.screens;

import com.adruijter.kingsvalley1.KingsValley1;
import com.adruijter.kingsvalley1.brick.Image;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class SplashScreen implements Screen {

	//Fields
	private KingsValley1 game;
	private float ratio, yzoom = 480f;	
	private Image image, image1985Konami, imagePush;
	private TextureRegion msxRegion, konamiRegion, nothingRegion,
						  kingsValleyRegion, konami1985Region,  pushRegion;
	private Texture texture;
	private float timer;
	
	public float getRatio() {
		return ratio;
	}
	
	private OrthographicCamera cam;
	
	//Constructor
	public SplashScreen(KingsValley1 game) 
	{
		this.game = game;
		cam = new OrthographicCamera();		
		this.ratio = ((float)Gdx.graphics.getWidth() / (float)Gdx.graphics.getHeight());
		cam.setToOrtho(true,  this.ratio * this.yzoom, this.yzoom);
		cam.position.set(544f/2f, 480f/2f, 0);
		this.game.getBatch().setColor(1f, 1f, 1f, 1f);		
		cam.update();		
	}

	
	@Override
	public void render(float delta)
	{
		
		if ( this.image.getPosition().y > this.cam.position.y/2)
		{
			this.image.getPosition().add(0f, -2f);
		}
		else 
		{
			this.timer += delta;
			if (this.timer < 2)
			{			
				this.image.setRegion(this.msxRegion);
			}
			else if (this.timer < 3)
			{
				this.image.setRegion(this.nothingRegion);
			}
			else if (this.timer < 4)
			{
				this.image.setRegion(this.konamiRegion);
				this.image.getPosition().set(new Vector2(this.cam.position.x - this.image.getRegion().getRegionWidth()/2, this.cam.position.y/2 + 200));
				this.timer = 4;
			}
			else if (this.timer < 10)
			{
				this.image.setRegion(this.kingsValleyRegion);
				this.image.setPosition(new Vector2(this.cam.position.x - kingsValleyRegion.getRegionWidth()/2, this.cam.position.y/2));
				this.game.setBackgroundColor(new Color(0.00f, 0.00f, 0.00f, 1f));
			}
		}
		this.game.getBatch().setProjectionMatrix(cam.combined);
		
		this.game.getBatch().begin();
		this.image.Draw(delta);
		this.game.getBatch().end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		this.texture = new Texture(Gdx.files.internal("data/SpriteSheet.png"));
		this.msxRegion = new TextureRegion(this.texture, 22, 164, 406, 204 );
		this.konamiRegion =  new TextureRegion(this.texture, 182, 377, 200, 80);
		this.nothingRegion = new TextureRegion(this.texture, 0, 0, 0, 0);
		this.kingsValleyRegion = new TextureRegion(this.texture, 148, 0, 300, 111);
		this.konami1985Region = new TextureRegion(this.texture, 148, 112, 197, 23);
		this.msxRegion.flip(false,  true);
		this.konamiRegion.flip(false, true);
		this.kingsValleyRegion.flip(false, true);
		this.konami1985Region.flip(false, true);
		this.image = new Image(this.game, new Vector2(this.cam.position.x - msxRegion.getRegionWidth()/2, this.cam.position.y/2 + 200), this.msxRegion);
		this.image1985Konami = new Image(this.game, new Vector2(this.cam.position.x - this.konami1985Region.getRegionWidth()/2, this.cam.position.y/2 + 200), this.msxRegion);
		this.image = new Image(this.game, new Vector2(this.cam.position.x - msxRegion.getRegionWidth()/2, this.cam.position.y/2 + 200), this.msxRegion);
	}

	
	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
