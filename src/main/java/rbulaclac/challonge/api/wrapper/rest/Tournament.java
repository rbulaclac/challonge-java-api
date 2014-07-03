package rbulaclac.challonge.api.wrapper.rest;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import rbulaclac.challonge.api.wrapper.impl.TournamentImpl;

/**
 *
 * @author rbulaclac
 */
@Path("/tournament")
public class Tournament {

    CloseableHttpClient httpclient;
    TournamentImpl tournament;
    Logger logger = Logger.getLogger("Tournament");

    public Tournament() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        httpclient = HttpClients.createDefault();
        tournament = new TournamentImpl(httpclient, "https://api.challonge.com/v1/");
    }

    //http://localhost:8080/challonge-api-wrapper/rest/tournament/index?api_key=rgDh7PCc1Ebdo6MapDF5eJFBN83UTJFGQyjJFWIx
    @GET
    @Path("/index")
    public String index(
            @QueryParam("api_key") String api_key,
            @DefaultValue("") @QueryParam("format") String format,
            @DefaultValue("") @QueryParam("state") String state,
            @DefaultValue("") @QueryParam("type") String type,
            @DefaultValue("") @QueryParam("created_after") String created_after,
            @DefaultValue("") @QueryParam("created_before") String created_before,
            @DefaultValue("") @QueryParam("subdomain") String subdomain) {
        return tournament.getIndex(api_key, format, state, type, created_after, created_before, subdomain);
    }

    @POST
    @Path("/create")
    public void create() {
    }

    //http://localhost:8080/challonge-api-wrapper/rest/tournament/show?api_key=rgDh7PCc1Ebdo6MapDF5eJFBN83UTJFGQyjJFWIx&tournament=1020034
    @GET
    @Path("/show")
    public String show(
            @QueryParam("api_key") String api_key,
            @QueryParam("tournament") String tournamentId,
            @DefaultValue("") @QueryParam("format") String format,
            @DefaultValue("0") @QueryParam("include_participants") int include_participants,
            @DefaultValue("0") @QueryParam("include_matches") int include_matches) {
        if (api_key.isEmpty() || tournamentId.isEmpty() || api_key == null || tournamentId == null) {
            return "API Key or Tournament field is empty. Both are required.";
        }
        return tournament.getShow(api_key, tournamentId, format, include_participants, include_matches);
    }

    @PUT
    @Path("/update")
    public void update() {

    }

    @DELETE
    @Path("/destroy")
    public String destroy(
            @QueryParam("api_key") String api_key,
            @QueryParam("tournament") String tournamentId,
            @DefaultValue("") @QueryParam("format") String format) {
        return tournament.deleteDestroy(api_key, tournamentId, format);
    }

    @POST
    @Path("/start")
    public String start(
            @QueryParam("api_key") String api_key,
            @QueryParam("tournament") String tournamentId,
            @DefaultValue("") @QueryParam("format") String format,
            @DefaultValue("0") @QueryParam("include_participants") int include_participants,
            @DefaultValue("0") @QueryParam("include_matches") int include_matches) {
        return tournament.postStart(api_key, tournamentId, format, include_participants, include_matches);
    }

    @POST
    @Path("/finalize")
    public String finalizeTournament(
            @QueryParam("api_key") String api_key,
            @QueryParam("tournament") String tournamentId,
            @DefaultValue("") @QueryParam("format") String format,
            @DefaultValue("0") @QueryParam("include_participants") int include_participants) {
        return tournament.postFinalize(api_key, tournamentId, format, include_participants);
    }

    @POST
    @Path("/reset")
    public String reset(
            @QueryParam("api_key") String api_key,
            @QueryParam("tournament") String tournamentId,
            @DefaultValue("") @QueryParam("format") String format,
            @DefaultValue("0") @QueryParam("include_participants") int include_participants) {
        return tournament.postReset(api_key, tournamentId, format, include_participants);
    }
}
