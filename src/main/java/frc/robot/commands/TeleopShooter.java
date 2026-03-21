package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class TeleopShooter extends Command {
    private Shooter s_Shooter;
    private DoubleSupplier shootSup;
    private DoubleSupplier reverseShootSup;
    private BooleanSupplier yButtonSup;
    private BooleanSupplier bButtonSup;
    private BooleanSupplier aButtonSup;
    private BooleanSupplier xButtonSup;

    public TeleopShooter(Shooter s_Shooter, DoubleSupplier shooterSup, DoubleSupplier reverseShootSup,
            BooleanSupplier yButtonSup, BooleanSupplier bButtonSup, BooleanSupplier aButtonSup, BooleanSupplier xButtonSup) {
        this.s_Shooter = s_Shooter;

        addRequirements(this.s_Shooter);

        this.shootSup = shooterSup;
        this.reverseShootSup = reverseShootSup;
        this.yButtonSup = yButtonSup;
        this.bButtonSup = bButtonSup;
        this.aButtonSup = aButtonSup;
        this.xButtonSup = xButtonSup;
    }

    @Override
    public void execute() {
        s_Shooter.activate(
                shootSup.getAsDouble(),
                reverseShootSup.getAsDouble(),
                yButtonSup.getAsBoolean(),
                bButtonSup.getAsBoolean(),
                aButtonSup.getAsBoolean(),
                xButtonSup.getAsBoolean());


    }
}