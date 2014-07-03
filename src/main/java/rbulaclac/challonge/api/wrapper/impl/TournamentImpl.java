/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rbulaclac.challonge.api.wrapper.impl;

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
import rbulaclac.challonge.api.wrapper.HttpUtil;

/**
 *
 * @author rbulaclac
 */
public class TournamentImpl {

    HttpClient httpclient;
    final String baseUrl;
    Logger logger = Logger.getLogger("TournamentImpl");

    public TournamentImpl(HttpClient httpclient, String baseUrl) {
        this.httpclient = httpclient;
        this.baseUrl = baseUrl;
    }

    public String getIndex(String api_key, String state, String type, String created_after, String created_before, String subdomain) {
        String url = baseUrl + "tournaments.json?api_key=" + api_key;
        if (!state.isEmpty()) {
            url += "&state=" + state;
        }
        if (!type.isEmpty()) {
            url += "&type=" + type;
        }
        if (!created_after.isEmpty()) {
            url += "&created_after=" + created_after;
        }
        if (!created_before.isEmpty()) {
            url += "&created_before=" + created_before;
        }
        if (!subdomain.isEmpty()) {
            url += "&subdomain=" + subdomain;
        }

        return HttpUtil.doGet(httpclient, url);
    }

    public void postCreate(String api_key, String name, String type, String url, String subdomain, String description, boolean open_signup,
            boolean hold_third_place_match, double pts_for_match_win, double pts_for_match_tie, double pts_for_game_win,
            double pts_for_game_tie, double pts_for_bye, int swiss_rounds, String ranked_by, double rr_pts_for_match_win,
            double rr_pts_for_match_tie, double rr_pts_for_game_win, double rr_pts_for_game_tie, boolean accept_attachments,
            boolean hide_forum, boolean show_rounds, boolean isPrivate, boolean notify_users_when_matches_open,
            boolean notify_users_when_the_tournament_ends, boolean sequential_pairings, int signup_cap) {
    }

    public String getShow(String api_key, String tournament, int include_participants, int include_matches) {
        String url = baseUrl + "tournaments/" + tournament +".json?api_key=" + api_key +
                "&include_participants=" + include_participants + "&include_matches=" + include_matches;
        System.out.println(url);
        return HttpUtil.doGet(httpclient, url);
    }

    public void putUpdate(String api_key, String name, String type, String url, String subdomain, String description, boolean open_signup,
            boolean hold_third_place_match, double pts_for_match_win, double pts_for_match_tie, double pts_for_game_win,
            double pts_for_game_tie, double pts_for_bye, int swiss_rounds, String ranked_by, double rr_pts_for_match_win,
            double rr_pts_for_match_tie, double rr_pts_for_game_win, double rr_pts_for_game_tie, boolean accept_attachments,
            boolean hide_forum, boolean show_rounds, boolean isPrivate, boolean notify_users_when_matches_open,
            boolean notify_users_when_the_tournament_ends, boolean sequential_pairings, int signup_cap) {
    }

    public void deleteDestroy(String api_key, String tournament) {
    }

    public void postStart(String api_key, String tournament, int include_participants, int include_matches) {
    }

    public void postFinalize(String api_key, String tournament, int include_participants) {
    }

    public void postReset(String api_key, String tournament, int include_participants) {
    }
}
