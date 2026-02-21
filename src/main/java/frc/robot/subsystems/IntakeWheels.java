// package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class IntakeWheels extends SubsystemBase {
//     private final TalonSRX armMotor = new TalonSRX(0); // add in motor num and change device type

//     private double fullSpeed = -1;
//     private double halfSpeed = -0.5;

//     public void activate(boolean kRightBumper, boolean kLeftBumper) { // change direction of wheels if needed
// //         if (kRightBumper) {
// //             armMotor.set(ControlMode.PercentOutput, halfSpeed);
// //         } else if (!kRightBumper && !kLeftBumper) {
// //             armMotor.set(ControlMode.PercentOutput, 0);
// //         } else if (kLeftBumper) {
// //             armMotor.set(ControlMode.PercentOutput, -halfSpeed);
// //         }
// //     }
// // }
