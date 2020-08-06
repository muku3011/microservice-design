package com.springboot;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients
public class Gateway {

	public static void main(String[] args) {
		SpringApplication.run(Gateway.class, args);
	}

	// TODO need to check how this will work with valid certificates, needed in that case or not. For now it's working with self-signed certificates
	// First import certificate into java keystore and then this will work
	@Bean
	public CloseableHttpClient httpClient() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();

		// TODO https://stackoverflow.com/questions/30250102/any-apache-httpclient-4-4-example-for-trust-self-signed-certificates
		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext,  new NoopHostnameVerifier());
		// SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		HttpClientBuilder httpClientBuilder = HttpClients.custom();
		httpClientBuilder.setSSLSocketFactory(socketFactory);
		// httpClientBuilder.setProxy()
		return httpClientBuilder.build();
	}
}