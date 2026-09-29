package com.drz.carparking.interaction.commands;

import com.drz.carparking.exceptions.InvalidParameterException;
import com.drz.carparking.handler.ParkingLotCommandHandler;

public class SlotNumberByRegistrationNumberCommand implements Command {

    private final ParkingLotCommandHandler parkingLotCommandHandler;

    public SlotNumberByRegistrationNumberCommand(
        ParkingLotCommandHandler parkingLotCommandHandler
    ) {
        this.parkingLotCommandHandler = parkingLotCommandHandler;
    }

    @Override
    public String helpText() {
        return "slot_number_for_registration_number <registrationNumber>";
    }

    @Override
    public void execute(String[] params) throws InvalidParameterException {
        if (params.length < 1) {
            throw new InvalidParameterException(
                "Expected one parameter <registrationNumber>"
            );
        }

        parkingLotCommandHandler.slotNumberForRegistrationNumber(params[0]);
    }
}