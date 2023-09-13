package com.emergency.demand.commands;

import com.emergency.cqrs.core.comand.BaseCommand;
import com.emergency.cqrs.core.comand.CommandDispatcher;
import com.emergency.cqrs.core.comand.CommandHandlerMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class EmergencyDemandCommandDispatcher implements CommandDispatcher {
    private final Map<Class<? extends BaseCommand>, List<CommandHandlerMethod>> routes=new HashMap<>();
    @Override
    public <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler) {
       var handlers=routes.computeIfAbsent(type,c->new LinkedList<>());
       handlers.add(handler);
    }

    @Override
    public void send(BaseCommand command) {
      var handlerInCommand=routes.get(command.getClass());
      if (!handlerInCommand.isEmpty()){
          throw new RuntimeException("The command dont have a handler define");
      }
        handlerInCommand.get(0).handleCommand(command);

    }
}
