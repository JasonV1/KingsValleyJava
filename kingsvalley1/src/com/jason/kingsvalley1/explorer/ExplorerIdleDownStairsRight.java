package com.jason.kingsvalley1.explorer;

import com.jason.kingsvalley1.animatedsprite.AnimatedSprite;

public class ExplorerIdleDownStairsRight extends AnimatedSprite
{
	//Fields

    //Constructor
    public ExplorerIdleDownStairsRight(Explorer explorer)
    {
    	super(explorer);
        this.i = 7;
        this.effect = true;
    }

    public void Update(float delta)
    {
      
    }

    public void Draw(float delta)
    {
        super.Draw(delta);
    }
}
