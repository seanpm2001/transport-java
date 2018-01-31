package samples;

import com.vmware.bifrost.bridge.spring.BifrostEnabled;
import com.vmware.bifrost.bridge.spring.BifrostService;
import com.vmware.bifrost.bus.MessagebusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import samples.model.Metrics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
//@BifrostService
public class MetricServiceA implements BifrostEnabled {

    @Autowired
    private MessagebusService bus;

    ExecutorService executorService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    MetricServiceA() {
        executorService = Executors.newFixedThreadPool(10);
    }

    @Override
    public void initializeSubscriptions() {
        logger.info("Initializing Metrics-A Service");
        Metrics metric = new Metrics(bus, 100, "metrics-a");
        executorService.submit(metric);
    }
}
