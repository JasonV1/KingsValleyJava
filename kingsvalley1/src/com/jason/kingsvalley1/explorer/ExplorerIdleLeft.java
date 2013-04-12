package com.jason.kingsvalley1.explorer;

import com.jason.kingsvalley1.animatedsprite.AnimatedSprite;



public class ExplorerIdleLeft extends AnimatedSprite
{
	//Field
	
	
	//Constructor
	public ExplorerIdleLeft(Explorer explorer)
	{
		super(explorer);
		this.i = 7;
		this.effect = true;
	}
	
	//Update
	public void Update(float delta)
	{
		
	}
	
	public void Draw(float delta)
	{
		super.Draw(delta);		
	}
}
