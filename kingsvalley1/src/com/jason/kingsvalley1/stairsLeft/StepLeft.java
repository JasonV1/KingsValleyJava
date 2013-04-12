package com.jason.kingsvalley1.stairsLeft;

import com.badlogic.gdx.math.Vector2;
import com.jason.kingsvalley1.KingsValley1;
import com.jason.kingsvalley1.brick.IBuildingBlock;
import com.jason.kingsvalley1.brick.Image;

public class StepLeft extends Image implements IBuildingBlock
{
	//Fields
    private char character;
    private String imageName;

    //Properties
    @Override
    public char getCharacter()
    {
        return this.character;
    }
    @Override
    public String getImageName()
    {
        return this.imageName;
    } 
    @Override
    public void setImageName(String imageName)
    {
    	this.imageName = imageName;
    }

    //Constructor
    public StepLeft(KingsValley1 game, Vector2 position, String imageName, char character)
    {
        super(game, position, "data/Stairs/" + imageName);
        this.character = character;
        this.imageName = imageName;
    }
    @Override
    public void Draw(float delta)
    {
        super.Draw(delta);
    }
}
