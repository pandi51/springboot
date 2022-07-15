package com.config.compare.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

	private List<String> region = Arrays.asList("region_1", "region_2");
	private List<String> envs = Arrays.asList("dev", "qa");

	@GetMapping(path = "/compare/{env}")
	public String compareConfig(@PathVariable String env) throws IOException {
		StringBuilder sb = new StringBuilder();

		for (String reg : region) {

			String mainPath = "classpath:/" + env + "/" + reg + "/application.properties";
			Resource mainRes = new ClassPathResource(mainPath);

			Properties mainProps = PropertiesLoaderUtils.loadProperties(mainRes);

			for (String envData : envs) {

				if (!env.equalsIgnoreCase(envData)) {

					String path = "classpath:/" + envData + "/" + reg + "/application.properties";
					Resource res = new ClassPathResource(path);

					Properties props = PropertiesLoaderUtils.loadProperties(res);

					sb.append("********************* Start ***************");
					sb.append("Comparing " + mainPath + " with " + path + " \n");

					//String missing = mainProps.entrySet().stream()
					//		.filter(mp -> null == props.getProperty(mp.getKey().toString(), null))
					//		.map(mp -> mp.getKey().toString()).collect(Collectors.joining(","));
 List<Strong> ms = new ArrayList<Strong>() ;
for(Map.Entry<Object, Object> mp: mainProps.entrySet()) {
  if( null== props.getProperty(mp.getKey().toString(), null)) {
      ms.add(mp.getKey().toString()) ;
}}

					sb.append("missing properties: " + Strings.join(ms.iterator(),',')+ " \n");
					sb.append("************** END *************");
				}
			}
		}
		return sb.toString();
	}

}
