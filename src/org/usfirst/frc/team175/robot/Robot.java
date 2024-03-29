/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team175.robot;

import org.usfirst.frc.team175.robot.util.BuzzTalonSRX;
import org.usfirst.frc.team175.robot.util.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends IterativeRobot {

    private BuzzTalonSRX talonSRX;
    private DigitalInput limitSwitch;

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        talonSRX = new BuzzTalonSRX(Constants.TALON_SRX_PORT);
        limitSwitch = new DigitalInput(Constants.LIMIT_PORT);
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for
     * items like diagnostics that you want ran during disabled, autonomous,
     * teleoperated and test.
     *
     * This runs after the mode specific periodic functions, but before LiveWindow
     * and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable chooser
     * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
     * remove all of the chooser code and uncomment the getString line to get the
     * auto name from the text box below the Gyro
     *
     * You can add additional auto modes by adding additional comparisons to the
     * switch structure below with additional strings. If using the SendableChooser
     * make sure to add them to the chooser code above as well.
     */
    @Override
    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    	/*
    	 * This block of code will set the motor to full power when the limit switch is not held down but will turn it
         * off if it is held down.
    	 */
    	if (!limitSwitch.get()) {
    		talonSRX.setPower(0);
    	} else {
    		talonSRX.setPower(1);
    	}
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        // talonSRX.setSelectedSensorPosition(0, Constants.PID_LOOP_INDEX, Constants.TIMEOUT_MS);
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    	/*
    	// Talon SRX Demo

        // This block of code will set the motor to full power when the limit switch is not held down but will turn it
        // off if it is held down.
        if (limitSwitch.get()) 
            talonSRX.setPower(0);
        else
            talonSRX.setPower(1);

        
        // This block of code will run the motor at full power until it passes 1000 encoder counts/ticks (just for 
        // comparison, 4096 ticks = 1 revolution) at which case, it will stop.
        if (talonSRX.getPosition() > 1000) 
            talonSRX.setPower(0);
        else 
            talonSRX.setPower(1);
        */
    }

}
