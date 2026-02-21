package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final WPI_VictorSPX topWheels = new WPI_VictorSPX(9);
    private final WPI_VictorSPX middleWheels = new WPI_VictorSPX(3);
    private final WPI_VictorSPX bottomWheels = new WPI_VictorSPX(23);

    // 0.65 speed for new shooter 
    private double speed = 0.65;

    public void activate(boolean kLeftBumper, boolean kRightBumper) {
        if (kLeftBumper) {
            topWheels.set(ControlMode.PercentOutput, -speed);
            middleWheels.set(ControlMode.PercentOutput, -speed);
            bottomWheels.set(ControlMode.PercentOutput, -speed);
        } else if (!kRightBumper && !kLeftBumper) {
            topWheels.set(ControlMode.PercentOutput, 0);
            middleWheels.set(ControlMode.PercentOutput, 0);
            bottomWheels.set(ControlMode.PercentOutput, 0);
        } else if (kRightBumper) {
            topWheels.set(ControlMode.PercentOutput, speed);
            middleWheels.set(ControlMode.PercentOutput, speed);
            bottomWheels.set(ControlMode.PercentOutput, speed);
        }
    }
}
