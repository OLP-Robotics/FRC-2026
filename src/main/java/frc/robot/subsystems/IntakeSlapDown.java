// package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;

// import edu.wpi.first.wpilibj.DigitalInput;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class IntakeSlapDown extends SubsystemBase {
//     private final TalonSRX intakeSlapDown = new TalonSRX(22); // To do: change number/motor if needed 
//     private DigitalInput topHeightLimitSwitch = new DigitalInput(0);

//     public void activate(double kLeftY) {
//         // on joystick, positive is down
//         if (kLeftY > 0) {
//             intakeSlapDown.set(ControlMode.PercentOutput, -kLeftY);
//         // on joystick, negative is up
//         } else if (kLeftY < 0 && (topHeightLimitSwitch.get())) {
//             intakeSlapDown.set(ControlMode.PercentOutput, -kLeftY);
//         } else {
//             intakeSlapDown.set(ControlMode.PercentOutput, 0);
//         }
//     }
// }
