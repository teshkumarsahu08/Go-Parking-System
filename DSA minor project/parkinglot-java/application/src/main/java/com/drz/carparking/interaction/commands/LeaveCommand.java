package com.drz.carparking.interaction.commands;

import com.drz.carparking.exceptions.InvalidParameterException;
import com.drz.carparking.handler.ParkingLotCommandHandler;
import com.drz.carparking.utils.StringUtils;

public class LeaveCommand implements Command {

    private final ParkingLotCommandHandler parkingLotCommandHandler;

    public LeaveCommand(ParkingLotCommandHandler parkingLotCommandHandler) {
        this.parkingLotCommandHandler = parkingLotCommandHandler;
    }

    @Override
    public String helpText() {
        return "leave <slotNumber>";
    }

    @Override
    public void execute(String[] params) throws InvalidParameterException {
        if (params.length < 1) {
            throw new InvalidParameterException("Expected one parameter <slotNumber>");
        }
        if (!StringUtils.isInteger(params[0])) {
            throw new InvalidParameterException("slotNumber must be an integer");
        }

        parkingLotCommandHandler.leave(Integer.parseInt(params[0]));
    }
}