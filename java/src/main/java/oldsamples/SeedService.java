//package oldsamples;
//
//import com.vmware.bifrost.core.AbstractService;
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SeedApi;
//import io.swagger.client.model.Seed;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//import com.vmware.bifrost.bridge.Request;
//import com.vmware.bifrost.bridge.Response;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import oldsamples.model.SeedRequest;
//
//
//import java.util.*;
//
//
//@Service("seedService")
//@Profile("dev")
//@RestController
//@RequestMapping("/seed")
//public class SeedService extends AbstractService {
//
//    public static String Channel = "service-seed";
//
//    protected SeedApi seedApi;
//
//    public SeedService(SeedApi seedApi) {
//        super(SeedService.Channel);
//        this.seedApi = seedApi;
//    }
//
//    @GetMapping
//    Response<List<Seed>> getSeedRestRequest() throws Exception {
//        return this.getSeeds(new SeedRequest("GetSeeds"));
//    }
//
//    @GetMapping("/custom")
//    Response<Seed> nonExternalApiMethod() throws Exception {
//        return this.customBusinessLogic(new SeedRequest("CustomLogic"));
//    }
//
//
//
//    @Override
//    public void handleServiceRequest(Request request) {
//        switch (request.getType()) {
//            case "GetSeeds":
//                this.getSeeds(request);
//                break;
//
//            case "PlantSeed":
//                this.plantSeed(request);
//                break;
//
//            case "KillPlant":
//                this.killPlant(request);
//                break;
//
//            case "CustomLogic":
//                this.customBusinessLogic(request);
//                break;
//
//        }
//    }
//
//    protected Response customBusinessLogic(Request request) {
//        super.logDebugMessage("Running Custom API Method", "customBusinessLogic()");
//
//        // really want to do something useful here.
//        Seed seed = new Seed();
//        seed.setId(new Random().nextLong());
//        seed.setType(Seed.TypeEnum.BUSH);
//
//        Response response = new Response(request.getId(), Arrays.asList(seed));
//        // push to bus and return response (for any restful callers)
//        this.sendResponse(response);
//        return response;
//    }
//
//
//
//    protected Response getSeeds(Request request) {
//        super.logDebugMessage("Running API Method", "getSeeds()");
//        this.runCustomCodeBefore("SeedService","getSeeds", request);
//        try {
//
//            List<Seed> result = this.seedApi.getSeeds();
//            this.logDebugMessage("API call success for","getSeeds()");
//            Response response = new Response(request.getId(), result);
//
//            this.runCustomCodeAfter("SeedService","getSeeds", response);
//            this.sendResponse(response);
//            return response;
//
//        } catch (ApiException e) {
//            this.apiFailedHandler(
//                    new Response(request.getVersion(), request.getId(), true), e, "getSeeds()");
//        }
//        return null;
//
//    }
//
//    protected void plantSeed(Request request) {
//        super.logDebugMessage("Running API Method", "plantSeed()");
//        try {
//
//            Seed requestSeed = this.castPayload(Seed.class, request);
//            Seed responseSeed = this.seedApi.plantSeed(requestSeed);
//            List<Seed> seeds = new ArrayList<>(Arrays.asList(responseSeed));
//            this.logDebugMessage("API call success for", "plantSeed()");
//            this.sendResponse(new Response(request.getId(), seeds));
//
//        } catch (ApiException e) {
//            this.apiFailedHandler(new Response(request.getId(), null), e, "plantSeed()");
//        }
//
//    }
//
//    protected void killPlant(Request request) {
//        super.logDebugMessage("Running API Method", "killPlant()");
//        try {
//
//            Seed requestSeed = this.castPayload(Seed.class, request);
//            this.seedApi.killPlant(requestSeed);
//            this.logDebugMessage("API call success for","killPlant()");
//            this.sendResponse(new Response(request.getId(), null));
//
//        } catch (ApiException e) {
//            this.apiFailedHandler(new Response(request.getId(), null), e, "killPlant()");
//        }
//
//    }
//}
