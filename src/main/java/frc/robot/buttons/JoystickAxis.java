package frc.robot.buttons;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickAxis {
	public Joystick joystick;
	public int axis;

	public JoystickAxis(Joystick stick, int axisID) {
		joystick = stick;
		axis = axisID;
	}

	public double get() {
		return joystick.getRawAxis(axis);
	}
}
