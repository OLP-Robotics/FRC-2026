package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX; // not used for NEO motors
// import com.revrobotics.spark.SparkMax;
// import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
   private final WPI_VictorSPX topWheels = new WPI_VictorSPX(3); // not used for NEO motors
   private final WPI_VictorSPX middleWheels = new WPI_VictorSPX(9);
   private final WPI_VictorSPX bottomWheels = new WPI_VictorSPX(23);
   private final Timer shootTimer = new Timer();

   // private final SparkMax topWheelsNeo = new SparkMax(1, MotorType.kBrushless);
   // private final SparkMax middleWheelsNeo = new SparkMax(2,
   // MotorType.kBrushless);
   // private final SparkMax bottomWheelsNeo = new SparkMax(23,
   // MotorType.kBrushless);

   // (wheels w/ top shooting hole)
   // 0.65 speed for new shooter
   // 0.9 speed from 5 ft away

   // new shooter design
   // kinda works from 4ft away at 0.8 speed, needs more of an angle
   // works pretty consistently from 0.9 speed 5 ft away??? sometimes overshoots?

   // new new new shooter design
   // 0.7 kinda wors kinda overshoots from 30 in away
   // 0.75 from 4 ft away works well!!! Yay!!
   // 0,85 works but sometimes gets too high of an arc and too short of a distance
   // - we'll see how it is w a more consistent shooter
   private double speed = 0.5;
   // changed direction of top motor so that it's opposite middle motor

   // 30 in away --> 0.8 speed
   //
   // public void activate(Double kLeftTrigger, Double kRightTrigger) {
   // if (kLeftTrigger > 0) {
   // topWheelsNeo.set(-speed);
   // middleWheelsNeo.set(speed);
   // // bottomWheelsNeo.set(-speed);
   // } else if (kRightTrigger == 0 && kLeftTrigger == 0) {
   // topWheelsNeo.set(0);
   // middleWheelsNeo.set(0);
   // // bottomWheelsNeo.set(0);
   // } else if (kRightTrigger < 0) {
   // topWheelsNeo.set(speed);
   // middleWheelsNeo.set(speed);
   // // bottomWheelsNeo.set(speed);
   // }
   // }

   // below not needed for Neo motors
   public void activate(double kLeftTrigger, double kRightTrigger, boolean yButtonPressed, boolean bButtonPressed,
         boolean aButtonPressed, boolean xButtonPressed) {

      if (yButtonPressed) {
         topWheels.set(ControlMode.PercentOutput, -0.9);
         middleWheels.set(ControlMode.PercentOutput, 0.9);
         bottomWheels.set(ControlMode.PercentOutput, -0.9);

      } else if (bButtonPressed) {
         topWheels.set(ControlMode.PercentOutput, -0.8);
         middleWheels.set(ControlMode.PercentOutput, 0.8);
         bottomWheels.set(ControlMode.PercentOutput, -0.8);

      } else if (aButtonPressed) {
         topWheels.set(ControlMode.PercentOutput, -0.7);
         middleWheels.set(ControlMode.PercentOutput, 0.7);
         bottomWheels.set(ControlMode.PercentOutput, -0.7);

      } else if (xButtonPressed) {
         topWheels.set(ControlMode.PercentOutput, -0.6);
         middleWheels.set(ControlMode.PercentOutput, 0.6);
         bottomWheels.set(ControlMode.PercentOutput, -0.6);

      } else if (kLeftTrigger > 0.1) {
         topWheels.set(ControlMode.PercentOutput, speed);
         middleWheels.set(ControlMode.PercentOutput, -speed);
         bottomWheels.set(ControlMode.PercentOutput, speed);

      } else if (kRightTrigger > 0.1) {
         topWheels.set(ControlMode.PercentOutput, -speed);
         middleWheels.set(ControlMode.PercentOutput, speed);
         bottomWheels.set(ControlMode.PercentOutput, -speed);

      } else {
         topWheels.set(ControlMode.PercentOutput, 0);
         middleWheels.set(ControlMode.PercentOutput, 0);
         bottomWheels.set(ControlMode.PercentOutput, 0);
      }
   }

   public void autoActivate() {
      System.out.println("inside autoActivate()");

      shootTimer.start();
      if (shootTimer.get() > 1 && shootTimer.get() < 11) {
         topWheels.set(ControlMode.PercentOutput, -0.9);
         middleWheels.set(ControlMode.PercentOutput, 0.9);
         bottomWheels.set(ControlMode.PercentOutput, -0.9);
      }
   }
}
