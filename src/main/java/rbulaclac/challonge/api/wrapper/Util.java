package rbulaclac.challonge.api.wrapper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import rbulaclac.challonge.api.wrapper.impl.TournamentImpl;

/**
 * Hello world!
 *
 */
public class Util {

    public static String doGet(HttpClient httpclient, String url) {
        String response = "";
        try {
            HttpGet httpget = new HttpGet(url);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            response = httpclient.execute(httpget, responseHandler);
        } catch (IOException ex) {
            Logger.getLogger(TournamentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

}
