package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Shooter;

public class shootOnlyAuto extends SequentialCommandGroup {

    Shooter s_Shooter;
    double speed = 0.8;
    double duration = 10.0;

    public shootOnlyAuto(Shooter s_Shooter) {
        this.s_Shooter = s_Shooter;
        System.out.println("inside shootOnlyAuto()");
        addCommands(
                new InstantCommand(() -> s_Shooter.autoActivate()));
        System.out.println("added command to autoShoot");

    }
}
