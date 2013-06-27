package com.jason.kingsvalley1.exitDoor;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.jason.kingsvalley1.KingsValley1;

public class ExitDoor 
{
	//Fields
	private KingsValley1 game;
	private Vector2 position;
	private HashMap<String, TextureRegion> region;
	
	//Constructor
	public ExitDoor(KingsValley1 game, Vector2 position, HashMap<String, TextureRegion> region)
	{
		this.game = game;
		this.position = position;
		this.region = region;
	}
	
	public void Update(float delta)
	{
		
	}
	
	public void Draw(float delta)
	{
		
	}
}
