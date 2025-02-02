package com.api.vehicles.infraestructura.adapter.outputs;



import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.api.vehicles.aplication.ports.outputs.ProccessPaymentPort;
import com.api.vehicles.domain.ProcessPayment;
import com.api.vehicles.domain.RequestLogin;
import com.api.vehicles.domain.ResponseLogin;
import com.api.vehicles.domain.ResponsePayment;
import com.api.vehicles.infraestructura.adapter.outputs.entities.ConfigurationEntity;
import com.api.vehicles.infraestructura.adapter.outputs.entities.ConsultEntity;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.ConfigurationEntityRepository;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.ConsultEntityRepository;
@Service
public class ProccessPaymentAdapter implements ProccessPaymentPort {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ConfigurationEntityRepository configRepo;
	@Autowired
	ConsultEntityRepository consultRepo;
	@Override
	public ResponsePayment processPaymentApi(ProcessPayment payment,Long id) {
		try {
			ConfigurationEntity c=configRepo.findById(1L).get();
			if(c.getExpireDate()==null ||c.getExpireDate().before(new Date())) {
				loginApi(c);
			}
			ConsultEntity co=consultRepo.findById(id).get();
			co.setOrderNumber(UUID.randomUUID().toString());
			consultRepo.save(co);
			payment.setKey(c.getApiKey());
			payment.setOrderNumber(co.getOrderNumber());
			
			payment.setAmount(String.valueOf(c.getPrice()));
			payment.setRedirect("https://coloniaride.com/payment");
			payment.setCurrency("GTQ");
			payment.setCapture("1");
			payment.setSubscription("0");
			payment.setSubscription("AUTOINFO");
			HttpHeaders headers =new HttpHeaders();
	        headers.set("Authorization","bearer "+c.getAccessToken());
	        headers.set("Accept", "application/json");
	        headers.set("Content-Type", "application/json");
	        // Crear la entidad con los headers y el body
	        HttpEntity<Object> entity = new HttpEntity<>(payment, headers);
			return restTemplate.postForEntity("https://app.tilopay.com/api/v1/processPayment", entity,ResponsePayment.class).getBody();
			/*
			 * 
			 * OkHttpClient client = new OkHttpClient().newBuilder()
  .build();
MediaType mediaType = MediaType.parse("application/json");
RequestBody body = RequestBody.create(mediaType, "{\r\n    \"redirect\" : \"https://www.urlToRedirect.com\",\r\n    \"key\": api_key,\r\n    \"amount\": \"1.00\",\r\n    \"currency\": \"USD\",\r\n    \"billToFirstName\": \"DEMO\",\r\n    \"billToLastName\": \"DEMO\",\r\n    \"billToAddress\": \"San Jose\",\r\n    \"billToAddress2\": \"Catedral\",\r\n    \"billToCity\": \"JS\",\r\n    \"billToState\": \"SJ\",\r\n    \"billToZipPostCode\": \"10061\",\r\n    \"billToCountry\": \"CR\",\r\n    \"billToTelephone\": \"88888888\",\r\n    \"billToEmail\": \"myemail@exapmle.com\",\r\n    \"shipToFirstName\":\"DEMO\",\r\n    \"shipToLastName\":\"DEMO\",\r\n    \"shipToAddress\":\"San Jose\",\r\n    \"shipToAddress2\":\"Catedral\",\r\n    \"shipToCity\":\"JS\",\r\n    \"shipToState\":\"SJ\",\r\n    \"shipToZipPostCode\":\"10061\",\r\n    \"shipToCountry\":\"CR\",\r\n    \"shipToTelephone\":\"88888888\",\r\n    \"orderNumber\": \"1212122\",\r\n\t\"capture\": \"1\",\r\n\t\"subscription\": \"0\",\r\n    \"platform\": \"api\",\r\n    \"returnData\" : \"dXNlcl9pZD0xMg==\",\r\n    \"hashVersion\" : \"V2\"\r\n}");
Request request = new Request.Builder()
  .url("https://app.tilopay.com/api/v1/processPayment")
  .method("POST", body)
  .addHeader("Authorization", "bearer [bearer token from GetToken method]")
  .addHeader("Accept", "application/json")
  .addHeader("Content-Type", "application/json")
  .build();
Response response = client.newCall(request).execute();


			 * return restTemplate.exchange( String.format(getIngredientUrl, id),
			 * HttpMethod.HEAD, null, ResponseEntity.class);
			 */
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void loginApi(ConfigurationEntity c) throws Exception {
		try {
			ResponseLogin l=restTemplate.postForEntity("https://app.tilopay.com/api/v1/login", new RequestLogin(c.getApiUser(), c.getApiPassword()),ResponseLogin.class).getBody();
			c.setAccessToken(l.getAccessToken());
			c.setExpireDate(Date.from(Instant.now().plusSeconds(l.getExpiresIn()-3600)));
			c.setExpiresIn(l.getExpiresIn()+"");
			c=configRepo.save(c);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
