package com.contais.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.wiremock
 * @date 2018/9/24
 */
public class MockServer {

    public static void main(String[] args) throws IOException {
        WireMock.configureFor(4396);
        WireMock.removeAllMappings();

        mock("/order/1", "01");
        mock("/order/2", "02");
        mock("/order/3", "03");

    }

    private static void mock(String url, String file) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/response/" + file + ".txt");
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo(url)).willReturn(WireMock.aResponse().withBody(content).withStatus(200)));

    }
}
