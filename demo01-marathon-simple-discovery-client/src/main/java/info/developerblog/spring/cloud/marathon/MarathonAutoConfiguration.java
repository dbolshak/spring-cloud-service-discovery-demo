package info.developerblog.spring.cloud.marathon;

import mesosphere.marathon.client.Marathon;
import mesosphere.marathon.client.MarathonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConditionalOnMarathonEnabled
public class MarathonAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public MarathonProperties marathonProperties() {
        return new MarathonProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public Marathon marathonClient(MarathonProperties properties) {
        return MarathonClient.getInstance(properties.getEndpoint());
    }
}
