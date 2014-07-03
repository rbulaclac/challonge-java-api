/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbulaclac.challonge.api.wrapper.impl;

import java.util.logging.Logger;
import org.apache.http.client.HttpClient;
import rbulaclac.challonge.api.wrapper.HttpUtil;

/**
 *
 * @author Ryan
 */
public class MatchImpl {

    HttpClient httpclient;
    final String baseUrl;
    Logger logger = Logger.getLogger("TournamentImpl");

    public MatchImpl(HttpClient httpclient, String baseUrl) {
        this.httpclient = httpclient;
        this.baseUrl = baseUrl;
    }

    public void getIndex(String api_key, String tournament, String match_id, String format,
            String state, int participant_id) {
        String url = baseUrl + "tournaments/" + tournament + "/matches." + format + "?api_key=" + api_key
                + "&state=" + state + "&participant_id" + participant_id;
        HttpUtil.doGet(httpclient, url);

    }

    public void getShow(String api_key, String tournament, String match_id, String format) {
        String url = baseUrl + "tournaments/" + tournament + "/matches." + format + "?api_key=" + api_key
                + "&match_id" + match_id;
        HttpUtil.doGet(httpclient, url);

    }

    public void putUpdate(String api_key, String tournament, String match_id, String format,
            String scores_csv, String winner_id, String player1_votes,
            String player2_votes) {

    }
}
