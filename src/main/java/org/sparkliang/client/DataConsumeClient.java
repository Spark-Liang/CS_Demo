package org.sparkliang.client;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class DataConsumeClient {

    private String filePath;
    private String fileType;
    private URL baseUrl;

    private CloseableHttpAsyncClient httpClient;

    public DataConsumeClient (
            String serverAddress,int port
            , String fileDirectory,String fileName, String fileType
    ) throws MalformedURLException {

        this.filePath = fileDirectory+'/'+fileName;
        this.fileType = fileType;
        baseUrl = new URL("http",serverAddress,port,"dataconsume/"+filePath);

    }


    private void init() throws URISyntaxException {
        httpClient= HttpAsyncClients.createDefault();

        HttpPut initRequest = new HttpPut(
                new URIBuilder(baseUrl.toString()).addParameter("fileType",fileType).build().toString()
        );

    }

    public boolean send(Map<String, Serializable> messageData){
        return false;
    }



    public static void main(String[] args) throws Exception{

        new DataConsumeClient("localhost",9090,"test","abc.txt","json").send(
                new HashMap<>()
        );

    }
}
