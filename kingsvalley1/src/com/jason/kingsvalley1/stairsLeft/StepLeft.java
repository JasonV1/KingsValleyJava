package com.jason.kingsvalley1.stairsLeft;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.jason.kingsvalley1.KingsValley1;
import com.jason.kingsvalley1.brick.IBuildingBlock;
import com.jason.kingsvalley1.brick.Image;

public class StepLeft extends Image implements IBuildingBlock
{
	//Fields
    private char character;

    //Properties
    @Override
    public char getCharacter()
    {
        return this.character;
    }
    

    //Constructor
    public StepLeft(KingsValley1 game, Vector2 position, TextureRegion region, char character)
    {
        super(game, position, region);
        this.character = character;
    }
    @Override
    public void Draw(float delta)
    {
        super.Draw(delta);
    }
}
