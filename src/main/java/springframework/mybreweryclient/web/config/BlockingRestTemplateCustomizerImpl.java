package springframework.mybreweryclient.web.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BlockingRestTemplateCustomizerImpl implements RestTemplateCustomizer{
	
	private final Integer maxtotalconnection;
	private final Integer defaultmaxperroot;
	private final Integer connectionrequesttimeout;
	private final Integer sockettimeout;
	
	
	
	public BlockingRestTemplateCustomizerImpl(@Value("${sfg.maxtotalconnection}") Integer maxtotalconnection,
			@Value("${sfg.defaultmaxperroot}") Integer defaultmaxperroot, 
			@Value("${sfg.connectionrequesttimeout}") Integer connectionrequesttimeout,
			@Value("${sfg.sockettimeout}") Integer sockettimeout) {
		super();
		this.maxtotalconnection = maxtotalconnection;
		this.defaultmaxperroot = defaultmaxperroot;
		this.connectionrequesttimeout = connectionrequesttimeout;
		this.sockettimeout = sockettimeout;
	}

	public ClientHttpRequestFactory clientHttpRequestFactory(){
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(maxtotalconnection);
		connectionManager.setDefaultMaxPerRoute(defaultmaxperroot);
		//if the request is taking longer than 3 seconds it will error and fail 
		RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(connectionrequesttimeout)
                .setSocketTimeout(sockettimeout).build();
	
		CloseableHttpClient httpClient = HttpClients.custom()
        .setDefaultRequestConfig(requestConfig)
        .setConnectionManager(connectionManager)
        .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
        .build();
        // Spring implementation of ClientHttpRequestFactory
		return new HttpComponentsClientHttpRequestFactory(httpClient);
		
	}

	public void customize(RestTemplate restTemplate) {
		// TODO Auto-generated method stub
		restTemplate.setRequestFactory(clientHttpRequestFactory());
		
	}

}
