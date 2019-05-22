package com.example.webservices.producing;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchema;


@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Value("${user.ws.local}")
    private String uri;

    @Bean(name = "userImport")
    public DefaultWsdl11Definition defaultWsdl11Definition(@Qualifier(value = "user") XsdSchema countriesSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("UserResource");
        wsdl.setLocationUri(uri);
        wsdl.setTargetNamespace("https://company.example.com/user/schemas");
        wsdl.setSchema(countriesSchema);
        return wsdl;
    }
}
