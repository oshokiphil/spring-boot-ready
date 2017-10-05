package springboot.ready.config;

import java.io.FileReader;

import org.apache.maven.model.Developer;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.SneakyThrows;

@Service
public class MavenInfo {

    private static final String SEPARATOR = " - ";

    @SneakyThrows
    public Maven get() {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader("pom.xml"));
        Maven mavenInfo = new Maven();
        mavenInfo.setId(model.getId());
        mavenInfo.setGroupId(model.getGroupId());
        mavenInfo.setArtifactId(model.getArtifactId());
        mavenInfo.setVersion(model.getVersion());
        mavenInfo.setVersion(model.getDescription());
        mavenInfo.setVersion(model.getUrl());
        mavenInfo.setDevelopers(getDevelopers(model));
        return mavenInfo;
    }

    private String getDevelopers(Model model) {
        StringBuilder developers = new StringBuilder(200);
        developers.append(SEPARATOR);
        for (Developer developer: model.getDevelopers()) {
            developers.append(developer.getName());
            developers.append(SEPARATOR);
        }
        return developers.toString();
    }


    @Data
    public class Maven {
        private String id;
        private String groupId;
        private String artifactId;
        private String version;
        private String description;
        private String url;
        private String developers;
    }
}
