package com.drz.carparking.interaction.commands;

import com.drz.carparking.exceptions.InvalidParameterException;
import com.drz.carparking.handler.ParkingLotCommandHandler;

public class RegistrationNumbersByColorCommand implements Command {

    private final ParkingLotCommandHandler parkingLotCommandHandler;

    public RegistrationNumbersByColorCommand(
        ParkingLotCommandHandler parkingLotCommandHandler
    ) {
        this.parkingLotCommandHandler = parkingLotCommandHandler;
    }

    @Override
    public String helpText() {
        return "registration_numbers_for_cars_with_colour <color>";
    }

    @Override
    public void execute(String[] params) throws InvalidParameterException {
        if (params.length < 1) {
            throw new InvalidParameterException("Expected one parameter <color>");
        }

        parkingLotCommandHandler.registrationNumbersForCarsWithColor(params[0]);
    }
}