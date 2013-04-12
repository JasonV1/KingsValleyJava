package com.jason.kingsvalley1.floor;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jason.kingsvalley1.KingsValley1;
import com.jason.kingsvalley1.brick.Brick;

public class Floor {
	//Fields
	private KingsValley1 game;
	private Vector2 position;
	private int amountOfBricks;
	private char highOrLowFallRight;
	private char highOrLowFallLeft;
	private ArrayList<Brick> floor;
	private Rectangle collisionRect;
	
	//Properties
	public Rectangle getCollisionRect() {
		return collisionRect;
	}

	public void setCollisionRect(Rectangle collisionRect) {
		this.collisionRect = collisionRect;
	}

	//Constructor
	public Floor(KingsValley1 game, Vector2 position, int amountOfBricks, 
			char highOrLowFallRight, char highOrLowFallLeft)
	{
		this.game = game;
		this.position = position;
		this.amountOfBricks = amountOfBricks;
		this.highOrLowFallRight = highOrLowFallRight;
		this.highOrLowFallLeft = highOrLowFallLeft;
		this.floor = new ArrayList<Brick>();
		this.LoadContent();
	}
	
	//LoadContent
	private void LoadContent()
	{
		//Voor het teken en om te debuggen
		for ( int i = 0; i < this.amountOfBricks; i++)
		{
			this.floor.add(new Brick(this.game, this.position, "floorTexture16x16.png", 'F' ));
		}
		this.collisionRect = new Rectangle(this.position.x,
										   this.position.y,
										   this.amountOfBricks * 16f,
										   16f);
	}
	
	public void Draw(float delta)
	{
		for (Brick brick : this.floor)
		{
			brick.Draw(delta);
		}
	}
}
