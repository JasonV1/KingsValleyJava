package com.jason.kingsvalley1.level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.jason.kingsvalley1.KingsValley1;
import com.jason.kingsvalley1.brick.Brick;
import com.jason.kingsvalley1.brick.IBuildingBlock;
import com.jason.kingsvalley1.explorer.Explorer;
import com.jason.kingsvalley1.explorer.ExplorerManager;
import com.jason.kingsvalley1.gesturelistener.ExplorerGestureListener;
import com.jason.kingsvalley1.inputprocessor.ExplorerInputProcessor;
import com.jason.kingsvalley1.stairsLeft.StairsLeft;
import com.jason.kingsvalley1.stairsLeft.StepLeft;
import com.jason.kingsvalley1.stairsRight.StairsRight;
import com.jason.kingsvalley1.stairsRight.StepRight;

public class Level {

	//Fields
	private KingsValley1 game;
    private String levelPath;
    private ArrayList<String> lines;
    private int width, height;
    private IBuildingBlock bricks[][];
    private Explorer explorer;
    private ArrayList<StairsRight> stairsRight;
    private ArrayList<StairsLeft> stairsLeft;
    private ExplorerInputProcessor input;
    private ExplorerGestureListener gesture;
    private InputMultiplexer multiplexer;
	
	
    //Properties
    public Explorer getExplorer() {
		return explorer;
	}

	public void setExplorer(Explorer explorer) {
		this.explorer = explorer;
	}
    
    
    public Level(KingsValley1 game, int levelIndex) throws IOException 
	{
		this.game = game;
		this.levelPath = String.format("data/%s.txt", levelIndex);
        this.LoadAssets();
        this.stairsRight = new ArrayList<StairsRight>();
        this.stairsLeft = new ArrayList<StairsLeft>();
        this.DetectStairsRight();
        this.DetectStairsLeft();
        this.input = new ExplorerInputProcessor(this);
        this.gesture = new ExplorerGestureListener(this);
        this.multiplexer = new InputMultiplexer();
        this.multiplexer.addProcessor(this.input);
        this.multiplexer.addProcessor(new GestureDetector(this.gesture));
        Gdx.input.setInputProcessor(this.multiplexer);
        ExplorerManager.setStairsRight(this.stairsRight);
        ExplorerManager.setStairsLeft(this.stairsLeft);
	}

	private void LoadAssets() throws IOException 
	{
		this.lines = new ArrayList<String>();
		FileHandle handle = Gdx.files.internal(this.levelPath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(handle.read()));
	    String line = reader.readLine();
        this.width = line.length();
        while (line != null)
        {
            lines.add(line);
            line = reader.readLine();
        }
        this.height = lines.size();
        this.bricks = new IBuildingBlock[this.width][ this.height];

        for (int i = 0; i < this.height; i++)
        {
            for (int j = 0; j < this.width; j++)
            {
                char brickElement = lines.get(i).charAt(j);
                this.bricks[j][i] = this.LoadObject(brickElement, j * 16, i * 16);
            }
        }
	}
	
	private IBuildingBlock LoadObject(char brickElement, int x, int y)
	{
		switch (brickElement)
        {
            case '.':
                return new Brick(this.game, new Vector2(x, y), "Brick_transparant.png", '.');
            case '1':
                return new Brick(this.game, new Vector2(x, y), "Brick.png", '1');
            case '2':
                return new Brick(this.game, new Vector2(x, y), "fundament.png", '2');
            case '3':
                return new Brick(this.game, new Vector2(x, y), "EmptySpace.png", '3');
            case '+':
            	float speed = (KingsValley1.IsAndroid()) ? 4.5f : 1.5f;
            	this.explorer = new Explorer(this.game, new Vector2(x, y), speed);                 
            	return new Brick(this.game, new Vector2(x, y), "Brick_transparant.png", '+');
            case 's':
                return new StepRight(this.game, new Vector2(x, y), "trapTopRight01.png", 's');
            case 'x':
                return new StepLeft(this.game, new Vector2(x, y), "trapTopLeft01.png", 'x');
            default:
                return new Brick(this.game, new Vector2(x, y), "Brick_transparant.png", '.');
        }
	}
	
	private void DetectFloors()
	{
		for (int i = 0; i < this.height; i++)
		{
			int amountOfBricks = 0;
			Vector2 position = Vector2.Zero;
			for (int j = 0; j < this.width; j++)
			{
				if ( this.bricks[j][i].getCharacter() == '1' || 
					 this.bricks[j][i].getCharacter() == 's' || 
					 this.bricks[j][i].getCharacter() == 'x' ||
					 this.bricks[j][i].getCharacter() == '3')
				{
					if (amountOfBricks == 0)
					{
						position = new Vector2(j * 16, i * 16);
					}
					amountOfBricks++;
				}
				else
				{
					if (amountOfBricks > 0)
					{
						
					}
				}
			}
		}
	}
	
	 public void DetectStairsRight()
     {
         for (int i = 0; i < this.height; i++)
         {
             for (int j = 0; j < this.width; j++)
             {
                 if (this.bricks[j][i].getImageName() == "trapTopRight01.png")
                 {
                     int amountOfStairs = 0;
                     int horizontal = j + 1;
                     for (int k = (i + 1); k < this.height; k++)
                     {
                         horizontal--;
                         if (this.bricks[horizontal][k].getImageName() == "Brick.png")
                         {
                             amountOfStairs = k - i - 1;
                             break;
                         }
                     }
                     this.stairsRight.add(new StairsRight(this.game, new Vector2(j * 16, i * 16), amountOfStairs));
                 }
             }
         }
     }
	 
	 private void DetectStairsLeft()
     {
         for (int i = 0; i < this.height; i++)
         {
             for (int j = 0; j < this.width; j++)
             {
                 if (this.bricks[j][i].getImageName() == "trapTopLeft01.png")
                 {
                     int amountOfStairs = 0;
                     int horizontal = j;
                     for (int k = (i + 1); k < this.height; k++)
                     {
                         horizontal++;
                         if (this.bricks[horizontal][k].getImageName() == "Brick.png")
                         {
                             amountOfStairs = k - i - 1;
                             break;
                         }
                     }
                     this.stairsLeft.add(new StairsLeft(this.game, new Vector2(j * 16f, i * 16f), amountOfStairs));
                 }
             }
         }
     }
	
	public void Update(float delta)
    {
		if (this.explorer != null)
		this.explorer.Update(delta);
    }

    public void Draw(float delta)
    {
        for (int i = 0; i < this.bricks.length; i++)
        {
            for (int j = 0; j < this.bricks[i].length; j++)
            {
               this.bricks[i][j].Draw(delta);
            }
        }
        
        for (StairsRight stair : this.stairsRight)
        {
            stair.Draw(delta);
        }
        
        for (StairsLeft stair : this.stairsLeft)
        {
            stair.Draw(delta);
        }
       
        if (this.explorer != null)
            this.explorer.Draw(delta);
    }
}
