//package oldsamples;
//
//import com.vmware.bifrost.bridge.spring.BifrostEnabled;
//import com.vmware.bifrost.bus.EventBus;
//import com.vmware.bifrost.bus.model.Message;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import oldsamples.model.Task;
//
//@Component
//public class LongTaskService implements BifrostEnabled {
//
//    @Autowired
//    private EventBus bus;
//
//    ExecutorService executorService;
//
//    private int taskCount = 0;
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    LongTaskService() {
//        executorService = Executors.newFixedThreadPool(10);
//    }
//
//    @Override
//    public void initialize() {
//
//        log.info("Initializing LongTaskService");
//
//        bus.respondStream("task-a",
//                (Message message) -> {
//
//                    Task task = new Task(taskCount, bus, 100, "task-a");
//                    executorService.submit(task);
//                    this.taskCount++;
//                    return task;
//                }
//        );
//
//        bus.respondStream("task-b",
//                (Message message) -> {
//
//                    Task task = new Task(taskCount, bus, 500, "task-b");
//                    executorService.submit(task);
//                    this.taskCount++;
//                    return task;
//                }
//        );
//    }
//}
//
