package com.jason.kingsvalley1.explorer;

import com.badlogic.gdx.math.Vector2;
import com.jason.kingsvalley1.animatedsprite.AnimatedSprite;

public class ExplorerJumpRight extends AnimatedSprite
{
	 //Fields
    private Explorer explorer;
    private float startX, startY, a;
    private int startH, startK, h, k;


    //Constructor
    public ExplorerJumpRight(Explorer explorer, int h, int k)
    {
        super(explorer);
    	this.explorer = explorer;
        this.startK = k;
        this.startH = h;
        this.i = 0;
    }

    public void Initialize()
    {
        this.startX = this.explorer.getPosition().x;
        this.startY = this.explorer.getPosition().y;
        this.h = (int)(this.startX + this.startH);
        this.k = (int)(this.startY - this.startK);
        this.a = this.CalculateA();
    }

    private float CalculateA()
    {
        return (this.startY -this.k) / (float)Math.pow((double)(this.startX - this.h), 2d);
    }

    public void Update(float delta)
    {
        float x = this.explorer.getPosition().x + this.explorer.getSpeed();
        float y = (float)(this.a * Math.pow((x - this.h), 2d) + this.k); 

        this.explorer.setPosition(new Vector2(x,y));
        if (this.explorer.getPosition().y > this.startY)
        {
            this.explorer.setPosition(new Vector2(x, startY));
           	this.explorer.setState(this.explorer.getWalkRight());
        }
        //base.Update(gameTime);
    }

    public void Draw(float delta)
    {
        super.Draw(delta);
    }
	
}
