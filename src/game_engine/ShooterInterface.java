package game_engine;

import processing.core.PVector;

public interface ShooterInterface{
	public abstract PVector GetDir(); // returns direction player is facing
	public abstract PVector GetFrom(); // return position vector to shoot from
}
