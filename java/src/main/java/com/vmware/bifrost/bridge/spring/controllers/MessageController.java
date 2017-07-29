package com.vmware.bifrost.bridge.spring.controllers;

import com.vmware.bifrost.bridge.util.BifrostUtil;
import com.vmware.bifrost.bus.MessagebusService;
import samples.Greeting;
import samples.HelloMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessagebusService bus;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @MessageMapping("/{topicDestination}")
    public void bridgeMessage(HelloMessage message, @DestinationVariable String topicDestination) {
        Greeting greeting = new Greeting("Hello there, " + message.getName() + "!");
        logger.debug("[*] Bifröst Bridge: new message received.");
        bus.sendRequest(BifrostUtil.convertTopicToChannel(topicDestination), greeting);


    }
}
