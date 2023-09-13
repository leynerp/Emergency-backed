package com.emergency.demand;

import com.emergency.cqrs.core.comand.CommandDispatcher;
import com.emergency.demand.commands.CreateEmergencyDemandCommand;
import com.emergency.demand.commands.EmergencyDemandCommandHandler;
import com.emergency.demand.commands.UpdateEmergencyDemandCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemandApplication {

	private CommandDispatcher commandDispatcher;
	private EmergencyDemandCommandHandler commandHandler;

	public DemandApplication(CommandDispatcher commandDispatcher, EmergencyDemandCommandHandler commandHandler) {
		this.commandDispatcher = commandDispatcher;
		this.commandHandler = commandHandler;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemandApplication.class, args);
	}

	public void initHandlers(){
		commandDispatcher.registerHandler(CreateEmergencyDemandCommand.class,commandHandler::handle);
		commandDispatcher.registerHandler(UpdateEmergencyDemandCommand.class,commandHandler::handle);
	}

}
