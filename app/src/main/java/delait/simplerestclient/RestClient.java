package delait.simplerestclient;

import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URL;

public class RestClient {
    URL url;
    protected int timeout = 10*1000;
    protected Gson gson = new Gson();
    protected boolean trustEveryone = false;
    protected boolean showLogs = true;

    void setURL(String url){
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public RestClient(String url){
        setURL(url);
    }


    public static class Builder{
        RestClient restClient;

        public Builder(String url){
            restClient = new RestClient(url);
        }

        public Builder setTimeout(int timeout){
            restClient.timeout = timeout;
            return this;
        }

        public Builder setGson(Gson gson){
            restClient.gson = gson;
            return this;
        }

        public Builder showLogs(boolean show){
            restClient.showLogs = show;
            return this;
        }

        public Builder trustEveryone(boolean trust){
            restClient.trustEveryone = trust;
            return this;
        }

        public RestClient build(){
            return restClient;
        }
    }
}
