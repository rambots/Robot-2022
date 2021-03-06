// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.index;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.subsystems.Index;

public class ReverseIndex extends CommandBase {
	/** Creates a new ReverseIndex. */

	Index index;

	public ReverseIndex(Index index) {
		this.index = index;
		addRequirements(index);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		index.setIndexMotor(Constants.INDEX_SPEED * -1);
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		index.stop();
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
