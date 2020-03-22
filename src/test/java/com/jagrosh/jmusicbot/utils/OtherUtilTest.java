package com.jagrosh.jmusicbot.utils;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import org.junit.Test;

import static com.jagrosh.jmusicbot.utils.OtherUtil.parseGame;
import static com.jagrosh.jmusicbot.utils.OtherUtil.parseStatus;
import static org.junit.Assert.assertEquals;

public class OtherUtilTest {

    @Test
    public void parseStatusTest(){

        String status = null;
        OnlineStatus st = parseStatus(status);
        assertEquals("online", st.getKey());

        status = "";
        st = parseStatus(status);
        assertEquals("online", st.getKey());

        status = "Offline";
        st = parseStatus(status);
        assertEquals("offline", st.getKey());

        status = "\\s\\s";
        st = parseStatus(status);
        assertEquals("", st.getKey());

    }

    @Test
    public void parseGameTest(){

        String status = "playing minecraft";
        Game game = parseGame(status);
        assertEquals("minecraft", game.getName());

        status = "listening to Hotel California";
        game = parseGame(status);
        assertEquals("Hotel California", game.getName());

        status = "listening okay";
        game = parseGame(status);
        assertEquals("okay", game.getName());

        status = "watching Sleeping Beauty";
        game = parseGame(status);
        assertEquals("Sleeping Beauty", game.getName());

        status = "streaming Streamer Modern Warfare";
        game = parseGame(status);
        assertEquals("Modern Warfare", game.getName());
        assertEquals("https://twitch.tv/Streamer", game.getUrl());

    }
}
