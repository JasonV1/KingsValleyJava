package com.jason.kingsvalley1.jewel;

import com.adruijter.kingsvalley1.KingsValley1;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Ray 
{
	//Fields
		private KingsValley1 game;
		private Vector2 position;
		private TextureRegion region;
		private Color color;

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}

		public Ray(KingsValley1 game, Vector2 position, TextureRegion region)
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
			this.game.getBatch().draw(this.region,
									  this.position.x,
									  this.position.y,
									  this.region.getRegionWidth(),
									  this.region.getRegionHeight());
		}
}