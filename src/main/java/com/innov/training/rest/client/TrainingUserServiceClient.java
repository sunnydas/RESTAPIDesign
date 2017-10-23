package com.innov.training.rest.client;

import com.innov.training.rest.users.bean.SimpleUserBean;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Thsi client calls the training user service
 */
public class TrainingUserServiceClient {

  public static void main(String[] args) {
    Client client = javax.ws.rs.client.ClientBuilder.newClient();
    String BASE_URI =
        "http://localhost:8080/InnovRestTraining/api/rest/users";
    WebTarget webTarget = client.target(BASE_URI);
    WebTarget resource = webTarget;
    Invocation.Builder builder=resource.
        request(javax.ws.rs.core.MediaType.APPLICATION_JSON);
    Invocation invocation=builder.buildGet();
//Invoke the request and receive the response in
// specified format type.
    GenericType<List<SimpleUserBean>> responseType=new GenericType<List<SimpleUserBean>>() { };
    List<SimpleUserBean> users = invocation.invoke(responseType);
    System.out.println(users);
    SimpleUserBean simpleUserBean = new SimpleUserBean();
    simpleUserBean.setAge(35);
    simpleUserBean.setfName("john");
    simpleUserBean.setlName("doe");
    simpleUserBean.setHomeAddress("somewhere");
    simpleUserBean.setPrimaryEmailAddress("john.doe@web.com");
    simpleUserBean.setPrimarymobilePhoneNumber(61736127);
     builder=resource.
        request(javax.ws.rs.core.MediaType.APPLICATION_JSON);
    Response response = builder.post(Entity.entity(simpleUserBean, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    System.out.println(response);
  }

}
