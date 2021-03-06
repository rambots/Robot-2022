package frc.robot.commands.drive;

import com.rambots4571.rampage.joystick.Gamepad.Axis;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class TankDriveCommand extends CommandBase {
	private final DriveTrain driveTrain;
	private final JoystickButton shifterButton;
	private boolean lastPressed;

	public TankDriveCommand(DriveTrain driveTrain, JoystickButton shifterButton) {
		this.driveTrain = driveTrain;
		this.shifterButton = shifterButton;
		lastPressed = shifterButton.get();
		addRequirements(driveTrain);
	}

	@Override
	public void execute() {
		boolean isPressed = shifterButton.get();
		if (!lastPressed && isPressed)
			driveTrain.shiftGears();

		driveTrain.drive(RobotContainer.driveController.getAxisValue(Axis.LeftYAxis),
		  RobotContainer.driveController.getAxisValue(Axis.RightYAxis));

		lastPressed = isPressed;
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
