package guru.ysy.ragollama.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.List;

/**
 * @Author: Fred R. Zhen
 * @Date: 2024/5/14 16:27
 * @Email: fred.zhen@gmail.com
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "ysy.aiapp")
public class VectorStoreProperties {
    private String vectorStorePath;
    private List<Resource> documentsToLoad;

}
