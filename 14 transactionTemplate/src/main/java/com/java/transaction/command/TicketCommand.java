package com.java.transaction.command;

import com.java.transaction.dto.TDto;

public interface TicketCommand {
	public void execute(TDto tDto);
}
