package com.emergency.demand;

import com.emergency.cqrs.core.command.CommandDispatcher;
import com.emergency.common.commands.CreateEmergencyDemandCommand;
import com.emergency.common.commands.DeleteEmergencyDemandCommand;
import com.emergency.demand.commands.EmergencyDemandCommandHandler;
import com.emergency.common.commands.UpdateEmergencyDemandCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
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
    @PostConstruct
	public void initHandlers(){
		commandDispatcher.registerHandler(CreateEmergencyDemandCommand.class,commandHandler::handle);
		commandDispatcher.registerHandler(UpdateEmergencyDemandCommand.class,commandHandler::handle);
		commandDispatcher.registerHandler(DeleteEmergencyDemandCommand.class,commandHandler::handle);
	}

}
