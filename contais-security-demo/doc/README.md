#### wiremock使用
   
   1. 执行wiremock

          java -jar wiremock-standalone-2.19.0.jar --port 端口号
           
   2. wiremock client 4 java 
   
          新建一个类WiremockServer,在主函数中添加以下代码
          WireMock.configureFor(4396);   --指定wiremock的端口号
          WireMock.removeAllMappings();  --清空之前的配置
          使用实例:
          WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/order/1")).willReturn(WireMock.aResponse().withBody("{\"id\":1}").withStatus(200)));


  

    