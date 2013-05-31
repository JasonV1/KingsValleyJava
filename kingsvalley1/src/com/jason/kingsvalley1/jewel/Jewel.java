package com.jason.kingsvalley1.jewel;

import com.adruijter.kingsvalley1.KingsValley1;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Jewel 
{
	//Fields
	private KingsValley1 game;
	private Vector2 position;
	private Color color;
	private Crown crown;
	
	//Constructor
	public Jewel(KingsValley1 game, Vector2 position, Color color)
	{
		this.game = game;
		this.position = position;
		this.color = color;
		this.crown = new Crown(this.game, this.position);
	}
	
	public void Update(float delta)
	{
		
	}
	
	public void Draw(float delta)
	{
		this.game.getBatch().setColor(this.color);
		this.crown.Draw(delta);
		this.game.getBatch().draw(this.game.getGameScreen().getLevel().getRegion().get("jewel"),
								  this.position.x,
								  this.position.y,
								  16,
								  16);
	}
}