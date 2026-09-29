package com.drz.carparking.interaction.commands;

import com.drz.carparking.exceptions.InvalidParameterException;
import com.drz.carparking.handler.ParkingLotCommandHandler;

public class SlotNumbersByColorCommand implements Command {

    private final ParkingLotCommandHandler parkingLotCommandHandler;

    public SlotNumbersByColorCommand(ParkingLotCommandHandler parkingLotCommandHandler) {
        this.parkingLotCommandHandler = parkingLotCommandHandler;
    }

    @Override
    public String helpText() {
        return "slot_numbers_for_cars_with_colour <color>";
    }

    @Override
    public void execute(String[] params) throws InvalidParameterException {
        if (params.length < 1) {
            throw new InvalidParameterException("Expected one parameter <color>");
        }

        parkingLotCommandHandler.slotNumbersForCarsWithColor(params[0]);
    }
}