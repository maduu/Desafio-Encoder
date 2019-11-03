
package frc.robot.commands;

import frc.robot.subsystems.SubsystemJoystick;
import frc.robot.subsystems.SubsystemDriver;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.Robot;

public class CommandDrive extends Command {
	
	private boolean a = true;
	private double b = 6015;
	double pulsesCurrent;

	public CommandDrive() {
		super(Robot.driver);
	}

	@Override
	protected void initialize(){
		Robot.driver.encoderDriver.reset();
	}
		
	@Override
	protected void execute() {
		this.pulsesCurrent = Robot.driver.returnPulses();
		if (this.a) {
			Robot.driver.tankDrive(0.4, 0.4);
		} else {
			Robot.driver.tankDrive(-0.4, -0.4);
		}
	}
	
	@Override
	protected boolean isFinished() {
		if (this.pulsesCurrent >= this.b) {
		return false;
		} else if (this.pulsesCurrent <= -this.b) {
		return false;
		}
	}
	
	@Override
	protected void end() {
	}
	
	@Override
	protected void interrupted(){
		a = !a;
		Robot.driver.tankDrive(0.0, 0.0);
	}

}