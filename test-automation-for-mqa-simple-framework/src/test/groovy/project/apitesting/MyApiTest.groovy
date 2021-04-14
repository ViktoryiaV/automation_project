package project.apitesting

import aqa.framework.api.httpclient.Response
import aqa.framework.api.httpclient.impl.BaseHttpClient
import groovy.util.logging.Log4j
import org.apache.http.entity.ContentType
import org.testng.annotations.Test

@Log4j
class MyApiTest {

    @Test
    void getMethodTest() {
        BaseHttpClient httpClient = new BaseHttpClient(ContentType.APPLICATION_JSON)

        def params = [
                p1: 'b1',
                p2: 'b2',
        ]
        def headers = [
                'MyHeader': 'test1'
        ]
        Response response = httpClient.doGet('https://httpbin.org/get', params, headers)
        assert response.code == 200
        Map body = response.parse() as Map
        log.info(body)
        assert body.headers['Myheader'] == 'test1'
    }

    @Test
    void postMethodTest() {
        BaseHttpClient httpClient = new BaseHttpClient(ContentType.APPLICATION_JSON)
        httpClient.addHeader('MyHeader', 'test1')

        def params = [
                p1: 'b1',
                p2: 'b2',
        ]

        Response response = httpClient.doPost('https://httpbin.org/post', params)
        assert response.code == 200
        Map body = response.parse() as Map
        log.info(body)
        assert body.headers['Myheader'] == 'test1'
        assert body.json == params
    }
}
