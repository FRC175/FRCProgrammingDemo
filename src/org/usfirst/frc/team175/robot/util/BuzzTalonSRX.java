package org.usfirst.frc.team175.robot.util;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * This wrapper over the Talon SRX motor controller just simplifies some commonly
 * used methods.
 * 
 * @author Arvind
 */
public class BuzzTalonSRX extends TalonSRX {

	public BuzzTalonSRX(int devicePort) {
		super(devicePort);

		// super.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.PID_LOOP_INDEX, Constants.TIMEOUT_MS);
        super.configNominalOutputForward(0, Constants.TIMEOUT_MS);
        super.configNominalOutputReverse(0, Constants.TIMEOUT_MS);
        super.configPeakOutputForward(1, Constants.TIMEOUT_MS);
        super.configPeakOutputReverse(-1, Constants.TIMEOUT_MS);
        super.configAllowableClosedloopError(0, Constants.SLOT_INDEX, Constants.TIMEOUT_MS);

        super.setSelectedSensorPosition(0, Constants.PID_LOOP_INDEX, Constants.TIMEOUT_MS);
        super.setNeutralMode(NeutralMode.Brake);
	}

	/**
	 * Applies a given amount of power to the motor.
	 * 
	 * @param power
	 *         The power (from 0 - 1) applied to the motor
	 * @throws NumberFormatException
	 *         If power is outside of the acceptable range (0 - 1)
	 */
	public void setPower(double power) {
		
			super.set(ControlMode.PercentOutput, power);
		
	}

	/**
	 * Makes the motor travel a certain distance.
	 * 
	 * @param position
	 *         The position the motor must get to (in encoder counts/ticks)
	 */
	public void setPosition(double position) {
		super.set(ControlMode.Position, position);
	}

	/**
	 * Returns the current position of the motor (in encoder counts/ticks).
	 */
	public int getPosition() {
        return super.getSelectedSensorPosition(Constants.PID_LOOP_INDEX);
    }

}
