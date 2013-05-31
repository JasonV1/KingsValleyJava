package com.jason.kingsvalley1.jewel;

import java.util.ArrayList;
import java.util.Map;

import com.adruijter.kingsvalley1.KingsValley1;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Crown 
{
	//Fields
	private KingsValley1 game;
	private Vector2 position;
	private ArrayList<Ray> rays;
	private Map<String, TextureRegion> region;
	
	public Crown(KingsValley1 game, Vector2 position)
	{
		this.game = game;
		this.region = this.game.getGameScreen().getLevel().getRegion();
		this.position = position;
		this.rays = new ArrayList<Ray>();
		this.rays.add(new Ray(this.game, this.position.add(-16f, 0f), this.region.get("crownPartLeft")));
		this.rays.add(new Ray(this.game, this.position, this.region.get("crownPartMiddle")));
		this.rays.add(new Ray(this.game, this.position.add(16f, 0f), this.region.get("crownPartRight")));
	}
	
	public void Update(float delta)
	{
		
	}
	
	public void Draw(float delta)
	{
		for (Ray ray : this.rays)
		{
			ray.Draw(delta);
		}
	}
}
