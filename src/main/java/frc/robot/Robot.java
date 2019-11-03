package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.SubsystemJoystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Autonomous;
import frc.robot.subsystems.SubsystemDriver;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  public static SubsystemDriver driver = new SubsystemDriver();
  public static SubsystemJoystick joystick = new SubsystemJoystick();
  
  public static OI m_oi;
  
  CommandGroup m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    m_oi = new OI();
    SmartDashboard.putData("Auto mode", m_chooser);
    m_autonomousCommand = new Autonomous(4);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }
  
  @Override
  public void autonomousInit() {
    if (m_autonomousCommand != null) m_autonomousCommand.start();
    }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}