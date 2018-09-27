package me.galaxy.blog.config;

import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "nav")
@PropertySource(value = "freemarker.properties")
public class FreeMarkerConfig {

    private Map<String, String> urls;

    public Map<String, String> getUrls() {
        return urls;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
    }

    @Autowired
    private freemarker.template.Configuration configuration;

    @PostConstruct
    public void setConfiguration() throws TemplateModelException {
        configuration.setSharedVaribles(urls);
    }

}
