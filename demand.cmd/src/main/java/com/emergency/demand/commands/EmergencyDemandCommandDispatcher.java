package com.emergency.demand.commands;

import com.emergency.cqrs.core.command.BaseCommand;
import com.emergency.cqrs.core.command.CommandDispatcher;
import com.emergency.cqrs.core.command.CommandHandlerMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class EmergencyDemandCommandDispatcher implements CommandDispatcher {
    private final Map<Class<? extends BaseCommand>, List<CommandHandlerMethod>> cache=new HashMap<>();
    @Override
    public <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler) {
       var handlers=cache.computeIfAbsent(type,c->new LinkedList<>());
       handlers.add(handler);
    }

    @Override
    public void send(BaseCommand command) {
      var handlerInCommand=cache.get(command.getClass());
      if (handlerInCommand==null){
          throw new RuntimeException("The command dont have a handler define");
      }
        handlerInCommand.get(0).handleCommand(command);

    }
}
