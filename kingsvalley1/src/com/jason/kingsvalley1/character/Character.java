package com.jason.kingsvalley1.character;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.jason.kingsvalley1.KingsValley1;
import com.jason.kingsvalley1.brick.IBuildingBlock;
import com.jason.kingsvalley1.brick.Image;

public class Character extends Image implements IBuildingBlock
{
	 //Fields
    private char character;
    
	//Properties
   	public char getCharacter() {
		return this.character;
	}
	public void setCharacter(char character) {
		this.character = character;
	}
	
	public Vector2 getPosition()
	{
		return this.position;
	}

	//Constructor
	public Character(KingsValley1 game, Vector2 position, TextureRegion region, char character)
	{
		super(game, position, region);
		this.character = character;
	}
	
	//Draw
	public void Draw(float delta)
    {
        super.Draw(delta);
    }
}
