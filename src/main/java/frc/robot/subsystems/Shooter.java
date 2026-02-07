package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final TalonSRX topWheels = new TalonSRX(9);
    private final TalonSRX middleWheels = new TalonSRX(3);
    private final TalonSRX bottomWheels = new TalonSRX(23);

    private double speed = 0.7;

    public void activate(boolean kRightBumper, boolean kLeftBumper) {
        if (kRightBumper) {
            topWheels.set(ControlMode.PercentOutput, speed);
            middleWheels.set(ControlMode.PercentOutput, speed);
            bottomWheels.set(ControlMode.PercentOutput, speed);
        } else if (kLeftBumper) {
            topWheels.set(ControlMode.PercentOutput, -speed);
            middleWheels.set(ControlMode.PercentOutput, -speed);
            bottomWheels.set(ControlMode.PercentOutput, -speed);
        } else {
            topWheels.set(ControlMode.PercentOutput, 0);
            middleWheels.set(ControlMode.PercentOutput, 0);
            bottomWheels.set(ControlMode.PercentOutput, 0);
        }
    }
}
