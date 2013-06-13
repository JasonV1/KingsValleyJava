package com.jason.kingsvalley1.score;

import com.adruijter.kingsvalley1.level.Level;
import com.badlogic.gdx.math.Vector2;
import com.jason.kingsvalley1.character.Character;

public class Score 
{
	private static int gameScore;

	public static int getGameScore() {
		return gameScore;
	}

	public static void setGameScore(int gameScore) {
		Score.gameScore = gameScore;
	}
	
	public static void AdjustScore(Level level)
	{
		String theScore = Integer.toString(gameScore);
		
		//Bepaal het verschil in lengte tussen de twee array's
		int diff = level.getScore().size() - theScore.length();
		
		//We bouwen nu het scorebord op van links naar rechts
		for (int i = 0; i < diff; i++)
		{
			level.getScore().set(i, new Character(level.getGame(),
								 				  level.getScore().get(i).getPosition(),
								 				  level.getRegion().get("0"),
								 				  '0'));
		}
		
		for (int i = diff; i < level.getScore().size(); i++)
		{
			level.getScore().add(i, new Character(level.getGame(),
								 				  new Vector2(level.getScore().get(i).getPosition().x,
								 				              level.getScore().get(i).getPosition().y,
								 				  level.getRegion().get("0"),
								 				  theScore.charAt(i - diff)));
		}
	}
}