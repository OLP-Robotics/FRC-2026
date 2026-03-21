package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    private final Joystick driver = new Joystick(0);
    private final Joystick co_driver = new Joystick(1);

    /* Drive Controls */
    private final int translationAxis = XboxController.Axis.kLeftY.value;
    private final int strafeAxis = XboxController.Axis.kLeftX.value;
    private final int rotationAxis = XboxController.Axis.kRightX.value;

    /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(driver, XboxController.Button.kY.value);
    private final JoystickButton robotCentric = new JoystickButton(driver, XboxController.Button.kLeftBumper.value);

    /* Co_Driver Buttons */
    private final JoystickButton intakeBall = new JoystickButton(co_driver, XboxController.Button.kRightBumper.value);
    private final JoystickButton outakeBall = new JoystickButton(co_driver, XboxController.Button.kLeftBumper.value);

    private final JoystickButton shootAt9 = new JoystickButton(co_driver, XboxController.Button.kY.value);
    private final JoystickButton shootAt8 = new JoystickButton(co_driver, XboxController.Button.kB.value);
    private final JoystickButton shootAt7 = new JoystickButton(co_driver, XboxController.Button.kA.value);
    private final JoystickButton shootAt6 = new JoystickButton(co_driver, XboxController.Button.kX.value);

    /* Co_Driver Controls */
    // private final int controlElevator = XboxController.Axis.kLeftY.value;
    private final int intakeSlapDown = XboxController.Axis.kLeftY.value;
    private final int shootBall = XboxController.Axis.kLeftTrigger.value; // fix name
    private final int reverseShootBall = XboxController.Axis.kRightTrigger.value;

    /* Subsystems */
    private final Swerve s_Swerve = new Swerve();
    private final Vision s_Vision = new Vision();
    private final Shooter s_Shooter = new Shooter();
    private final IntakeSlap s_IntakeSlap = new IntakeSlap();
    private final IntakeWheels s_IntakeWheels = new IntakeWheels();

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        s_Swerve.setDefaultCommand(
                new TeleopSwerve(
                        s_Swerve,
                        () -> -driver.getRawAxis(translationAxis),
                        () -> -driver.getRawAxis(strafeAxis),
                        () -> -driver.getRawAxis(rotationAxis),
                        () -> robotCentric.getAsBoolean()));

        s_Vision.setDefaultCommand(
                new TeleopVision(
                        s_Vision));

        s_Shooter.setDefaultCommand(
                new TeleopShooter(
                        s_Shooter,
                        () -> co_driver.getRawAxis(shootBall),
                        () -> co_driver.getRawAxis(reverseShootBall),
                        () -> shootAt9.getAsBoolean(),
                        () -> shootAt8.getAsBoolean(),
                        () -> shootAt7.getAsBoolean(),
                        () -> shootAt6.getAsBoolean()));

        s_IntakeWheels.setDefaultCommand(
                new TeleopIntakeWheels(
                        s_IntakeWheels,
                        () -> intakeBall.getAsBoolean(),
                        () -> outakeBall.getAsBoolean()));

        s_IntakeSlap.setDefaultCommand(
                new TeleopIntakeSlap(
                        s_IntakeSlap,
                        () -> co_driver.getRawAxis(intakeSlapDown)));

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
     * it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* Driver Buttons */
        zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroHeading()));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getBackwardsLineAuto() {
        // An ExampleCommand will run in autonomous
        return new backwardsLineAuto(s_Swerve);
    }

    public Command getSPatternAuto() {
        // An ExampleCommand will run in autonomous
        return new sCurve(s_Swerve);
    }

    public Command getShootAuto() {
        return new shootOnlyAuto(s_Shooter);
    }
}
