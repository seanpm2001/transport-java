package com.vmware.bifrost.core.autogen;


import com.vmware.bifrost.bridge.Request;
import com.vmware.bifrost.bridge.Response;
import com.vmware.bifrost.bus.model.Message;
import org.springframework.http.HttpMethod;


/**
 * Generic lambda interface that allows for making ReST or Websocket calls for an API from the API layer to the Service layer
 *
 * @param <RequestType> The service request object
 * @param <ResponseType>The service response object
 */
public interface IRestApiBridge<RequestType extends Request, ResponseType extends Response> {
    void apiRequest(
            IApiType<RequestType, ResponseType> apiType,
            HttpMethod method,
            String uri,
            String jsonBody,
            IApiSuccessHandler<RequestType, ResponseType> successHandler,
            IApiFailureHandler failureHandler,
            String apiClassName,
            Message message
    );
}
