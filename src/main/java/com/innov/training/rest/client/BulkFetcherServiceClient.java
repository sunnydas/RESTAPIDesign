package com.innov.training.rest.client;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.Future;

/**
 * Async client for bulk fetch operation
 */
public class BulkFetcherServiceClient {

  public static void main(String[] args) {
    String BASE_URI =
        "http://localhost:8080/InnovRestTraining/api/rest";
    final Client client = javax.ws.rs.client.ClientBuilder.newClient();
    WebTarget webTarget =
        client.target(BASE_URI).path("heavylifting").path("fetch");
    AsyncInvoker asyncInvoker = webTarget.
        request(javax.ws.rs.core.MediaType.APPLICATION_JSON).async();
    Future<String> entity = asyncInvoker.get(
        new InvocationCallback<String>() {
          @Override
          public void completed(String response) {
            //Call back on request completion
            //You can process the result here, if required
            System.out.println("Response fetched successfully " + response);
            client.close();
          }

          @Override
          public void failed(Throwable throwable) {
            //Call back on request failure
            //Handle the exception
            //log(...) method definition is not shown here
            System.err.print(throwable);
          }
        });
  }

}
