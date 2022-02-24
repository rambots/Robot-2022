// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveTimedCommand extends CommandBase {
	private DriveTrain drivetrain;
	private double timeInSeconds;
	private Timer timer;

	/** Creates a new DriveTimedCommand. */
	public DriveTimedCommand(DriveTrain dt, double timeInSeconds) {
		// Use addRequirements() here to declare subsystem dependencies.
		this.drivetrain = dt;
		this.timeInSeconds = timeInSeconds;
		timer = new Timer();
		addRequirements(drivetrain);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		timer.reset();
		timer.start();
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		drivetrain.drive(0.5, 0.5);
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return timer.get() >= timeInSeconds;
	}
}
