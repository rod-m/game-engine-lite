Lite Game Engine

# sprint-001
made a simple movement system with some basic physics. 
Uses processing PVector for the math.
Rotate the ship using PVector heading method.

# sprint-002
added a bullet fire mechanic to game

# sprint-003
Example of applying an interface.
Bullet now implements an interface called 'ProjectileInterface'
Player implements ShooterInterface

# sprint-004
Added some debris to shoot at. 
Added size vector to GameObject and a boolen hitAble to filter what to check for collisions. 
The bullet checks all gameobjects that are hittable and destroys them.