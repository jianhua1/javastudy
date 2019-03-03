package com.jh.myfg.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @author 吴兵
 * @date 2018-01-05 19:26
 */
/**
 * @author 吴兵
 * @date 2018-01-05 19:26
 */

@Configuration
public class FeignMultipartSupportConfig {

  @Autowired
  private ObjectFactory<HttpMessageConverters> messageConverters;

  @Bean
  public Encoder feignFormEncoder() {
    return new SpringFormEncoder(new SpringEncoder(messageConverters));
  }
}
