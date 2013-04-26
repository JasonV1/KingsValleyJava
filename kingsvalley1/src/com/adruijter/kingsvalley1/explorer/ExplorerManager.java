package com.adruijter.kingsvalley1.explorer;

import java.util.ArrayList;

import com.adruijter.kingsvalley1.floor.Floor;
import com.adruijter.kingsvalley1.stairsRight.StairsRight;
import com.adruijter.kingsvalley1.stairsLeft.StairsLeft;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class ExplorerManager
{
	//Fields
    private static Explorer explorer;
    private static ArrayList<StairsRight> stairsRight;
    private static ArrayList<StairsLeft> stairsLeft;
    private static ArrayList<Floor> floors;
    private static boolean debug = false;

    //Properties
    public static boolean Debug()
    {
    	return debug;
    }
    public static void setExplorer(Explorer value)
    {
        explorer = value;
    }
    public static void setStairsRight(ArrayList<StairsRight> value)
    {
        stairsRight = value;
    }
    public static void setStairsLeft(ArrayList<StairsLeft> value)
    {
        stairsLeft = value;
    }
    
	public static void setFloors(ArrayList<Floor> floors) {
		ExplorerManager.floors = floors;
	}
	
	public static boolean CollisionDetectionBottomStairsRight()
    {
        for (StairsRight stairs : stairsRight)
        {
            if (explorer.getCollisionRectStairs().overlaps(stairs.getCollisionRectBottom()))
            {
                if (explorer.getState().equals(explorer.getWalkRight()))
                {
                    int offset = 10;
                    if ( ((explorer.getCollisionRectStairs().x + explorer.getCollisionRectStairs().width) > 
                    	   stairs.getCollisionRectBottom().x + offset - 2) &&
                         ((explorer.getCollisionRectStairs().x + explorer.getCollisionRectStairs().width) < 
                           stairs.getCollisionRectBottom().x + offset + 2))
                    {
                        return true;
                    }
                }
                else if(explorer.getState().equals(explorer.getWalkDownStairsRight()))
                {
                    int offset = 0;
                    if ((explorer.getCollisionRectStairs().y > stairs.getCollisionRectBottom().y + offset - 2) &&
                        (explorer.getCollisionRectStairs().y < stairs.getCollisionRectBottom().y + offset + 5))
                    {
                    	explorer.setPosition( new Vector2(explorer.getPosition().x, stairs.getCollisionRectBottom().y - stairs.getCollisionRectBottom().height ));
                    	return true;
                    } 
                }
            }
        }
        return false;
    }
    public static boolean CollisionDetectionTopStairsRight()
    {
        
        for (StairsRight stairs : stairsRight)
        {
            if (explorer.getCollisionRectStairs().overlaps(stairs.getCollisionRectTop()))
            {
                if (explorer.getState().equals(explorer.getWalkLeft()))
                {
                    int offset = -10;
                    if ( (explorer.getCollisionRectStairs().x > stairs.getCollisionRectTop().x + stairs.getCollisionRectTop().width + offset - 3) &&
                         (explorer.getCollisionRectStairs().x < stairs.getCollisionRectTop().x + stairs.getCollisionRectTop().width + offset + 3))
                    {
                        return true;
                    }
                }
                else if (explorer.getState().equals(explorer.getWalkUpStairsRight()))
                {
                	int offset = 5;
                    if ((explorer.getCollisionRectStairs().y < (stairs.getCollisionRectTop().y - stairs.getCollisionRectTop().height + offset ) &&
                        (explorer.getCollisionRectStairs().y > (stairs.getCollisionRectTop().y - stairs.getCollisionRectTop().height - offset ))))
                    {
                        explorer.setPosition( new Vector2(explorer.getPosition().x, stairs.getCollisionRectTop().y - 2 * stairs.getCollisionRectTop().height ));
                    	return true;
                    }                	
                }
            }

        }
        return false;
    }
    
  
    public static boolean CollisionDetectionBottomStairsLeft()
    {
        for (StairsLeft stairs : stairsLeft)
        {
            if (explorer.getCollisionRectStairs().overlaps(stairs.getCollisionRectBottom()))
            {
                if (explorer.getState().equals(explorer.getWalkLeft()))
                {
                    int offset = -10;
                    if ((explorer.getCollisionRectStairs().x > stairs.getCollisionRectBottom().x + stairs.getCollisionRectBottom().width + offset - 2) &&
                        (explorer.getCollisionRectStairs().x < stairs.getCollisionRectBottom().x + stairs.getCollisionRectBottom().width + offset + 2)) 
                    {
                        return true;
                    }
                }
                else if (explorer.getState().equals(explorer.getWalkDownStairsLeft()))
                {
                    int offset = 0;
                    if ((explorer.getCollisionRectStairs().y > stairs.getCollisionRectBottom().y + offset - 2) &&
                         (explorer.getCollisionRectStairs().y < stairs.getCollisionRectBottom().y + offset + 5))
                    {
                    	explorer.setPosition( new Vector2(explorer.getPosition().x, stairs.getCollisionRectBottom().y - stairs.getCollisionRectBottom().height ));
                    	return true;
                    } 
                }
            }
        }
        return false;
    }


    public static boolean CollisionDetectionTopStairsLeft()
    {
        for (StairsLeft stairs : stairsLeft)
        {
            if (explorer.getCollisionRectStairs().overlaps(stairs.getCollisionRectTop()))
            {
                if (explorer.getState().equals(explorer.getWalkRight()))
                {
                    int offset = 10;
                    if ((explorer.getCollisionRectStairs().x + explorer.getCollisionRectStairs().width > stairs.getCollisionRectTop().x + offset - 3) &&
                        (explorer.getCollisionRectStairs().x + explorer.getCollisionRectStairs().width < stairs.getCollisionRectTop().x + offset + 3))
                    {
                        return true;
                    }
                }
                else if (explorer.getState().equals(explorer.getWalkUpStairsLeft()))
                {
                    int offset = 5;
                    if ((explorer.getCollisionRectStairs().y < (stairs.getCollisionRectTop().y - stairs.getCollisionRectTop().height + offset ) &&
                        (explorer.getCollisionRectStairs().y > (stairs.getCollisionRectTop().y - stairs.getCollisionRectTop().height - offset ))))
                    {
                        explorer.setPosition( new Vector2(explorer.getPosition().x, stairs.getCollisionRectTop().y - 2 * stairs.getCollisionRectTop().height ));
                     	return true;
                    }
                }
            }

        }
        return false;
    }
    
    public static boolean CollisionDetectionJumpRight()
    {
    	for (Floor floor : floors)
    	{
    		if ( floor.getAmountOfBricks() != 1)
    		{
	    		if ( explorer.getCollisionRectStairs().overlaps(floor.getCollisionRectangle()))
	    		{
	    			float pixelsThroughFloor = floor.getCollisionRectangle().y - 
	    							   explorer.getCollisionRectStairs().y - 
	    							   explorer.getCollisionText().getHeight();
	    			Gdx.app.log("diff", Float.toString(pixelsThroughFloor));
	    			explorer.setPixelsThroughFloor(pixelsThroughFloor);
	    			return true;
	    		}
    		}
    	}
    	return false;
    }
    
   
    
    public static boolean CollisionDetectionGroundAfterJump()
    {
      for (Floor floor : floors)
      {
    	  if (floor.getAmountOfBricks() != 1)
    	  {
    		  if (explorer.getCollisionRectStairs().overlaps(floor.getCollisionRectangle())
    			  && explorer.getCollisionRectStairs().y < floor.getCollisionRectangle().y)
    		  {
    			  float pixelsThroughFloor = floor.getCollisionRectangle().y -
    					  explorer.getCollisionRectStairs().y -
    					  explorer.getCollisionText().getHeight() + 2;
    			  Gdx.app.log("diff", Float.toString(pixelsThroughFloor));
    			  explorer.setPixelsThroughFloor(pixelsThroughFloor);
    			  return true;
    		  }
    	  }
      }
      return false;
    }
    
    public static boolean CollisionDetectionFallOfFloorLeft()
    {
    	for (Floor floor : floors)
    	{
    		if (explorer.getCollisionRectStairs().overlaps(floor.getCollisionRectangle()))
    		{
    			if (explorer.getCollisionRectStairs().x + 14 < floor.getCollisionRectangle().x)
    			{
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public static boolean CollisionDetectionFallOfFloorRight()
    {
    	for (Floor floor : floors)
    	{
    		if (explorer.getCollisionRectStairs().overlaps(floor.getCollisionRectangle()))
    		{
    			if (explorer.getCollisionRectStairs().x + 2 > 
    				(floor.getCollisionRectangle().x + floor.getCollisionRectangle().getWidth()))
    			{
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public static boolean CollisionDetectionWallInFrontRight()
    {
    	for (Floor floor : floors)
    	{
    		if (explorer.getCollisionRectStairs().overlaps(floor.getCollisionRectangle()))
    			 
    			if ((explorer.getPosition().x + explorer.getCollisionRectStairs().getWidth()) >
    			floor.getCollisionRectangle().x)
    			 {
    				if ((explorer.getPosition().x + explorer.getCollisionRectStairs().getWidth()) <
    					(floor.getCollisionRectangle().x + floor.getCollisionRectangle().getWidth()))
    				{
	    				 if((explorer.getPosition().y + 2 * explorer.getCollisionRectStairs().getHeight()) >
	    	    			(floor.getCollisionRectangle().y + floor.getCollisionRectangle().getHeight()))
	    				 {
	    					 float inWall = floor.getCollisionRectangle().x - (explorer.getCollisionRectStairs().x +
	    							 		explorer.getCollisionRectStairs().getWidth());
	    					 explorer.setPixelsInWallRight(inWall - 1);
	    					 return true;
	    				 }
    				}
    			 }
    			
    	}
    	return false;
    }
}
