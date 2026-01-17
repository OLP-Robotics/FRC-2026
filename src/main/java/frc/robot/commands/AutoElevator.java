package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;

public class AutoElevator extends Command{
    private Elevator s_Elevator;

    public AutoElevator(Elevator s_Elevator){
        this.s_Elevator = s_Elevator;

        addRequirements(s_Elevator);
    }

    @Override
    public void execute() {
        s_Elevator.activate(1);
    }
}
