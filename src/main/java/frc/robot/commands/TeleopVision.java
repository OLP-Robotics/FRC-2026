package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Vision;

public class TeleopVision extends Command {
    private Vision s_Vision;

    public TeleopVision(Vision s_Vision) {
        this.s_Vision = s_Vision;

        addRequirements(this.s_Vision);
    }

    @Override
    public void execute() {
        s_Vision.activate();
    }
}