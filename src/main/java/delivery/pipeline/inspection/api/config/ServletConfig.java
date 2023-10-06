package delivery.pipeline.inspection.api.config;

import delivery.pipeline.inspection.api.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

/**
 * apDeliveryPipelineApi
 * delivery.pipeline.inspection.api.config
 *
 * @author REX
 * @version 1.0
 * @since 6 / 7/2017
 */
@Configuration
public class ServletConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
