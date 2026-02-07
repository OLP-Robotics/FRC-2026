package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class TeleopShooter extends Command {
    private Shooter s_Shooter;
    private BooleanSupplier shootSup;
    private BooleanSupplier reverseShootSup;

    public TeleopShooter(Shooter s_Shooter, BooleanSupplier shooterSup, BooleanSupplier reverseShootSup) {
        this.s_Shooter = s_Shooter;

        addRequirements(this.s_Shooter);

        this.shootSup = shooterSup;
        this.reverseShootSup = reverseShootSup;
    }

    @Override
    public void execute() {
        s_Shooter.activate(
                shootSup.getAsBoolean(),
                reverseShootSup.getAsBoolean());
    }
}