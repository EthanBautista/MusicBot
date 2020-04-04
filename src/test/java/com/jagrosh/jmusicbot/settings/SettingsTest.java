package com.jagrosh.jmusicbot.settings;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static org.junit.Assert.*;

public class SettingsTest {

    @Before
    public void backupSettings() throws IOException {
        if(!Files.exists(Paths.get("serversettings.json.old")) && Files.exists(Paths.get("serversettings.json"))){
            Files.copy(Paths.get("serversettings.json"), Paths.get("serversettings.json.old"));
        }
        Files.deleteIfExists(Paths.get("serversettings.json"));
    }

    @After
    public void restoreSettings() throws IOException {
        if(Files.exists(Paths.get("serversettings.json.old"))){
            Files.deleteIfExists(Paths.get("serversettings.json"));
            Files.copy(Paths.get("serversettings.json.old"), Paths.get("serversettings.json"));
        }
        Files.deleteIfExists(Paths.get("serversettings.json.old"));
    }

    @Test
    public void SettingsSetTester(){

        //Repeat 1000 Times
        for(int i = 0; i < 1000; i++) {
            long textid = randomLong(0L, 2147483648L);
            long voiceid = randomLong(0L, 2147483648L);
            long roleid = randomLong(0L, 2147483648L);
            int volume = randomInt(0, 2147483647);
            boolean repeatMode = randomBoolean();

            SettingsManager manager = new SettingsManager();
            Settings settings = new Settings(manager, textid, voiceid, roleid, volume, null, repeatMode, null);

            assertEquals(textid, settings.textId);
            assertEquals(roleid, settings.roleId);
            assertEquals(volume, settings.getVolume());
            assertEquals(null, settings.getDefaultPlaylist());
            assertEquals(repeatMode, settings.getRepeatMode());
            assertEquals(null, settings.getPrefix());
        }

    }

    //Verify Default Initialization of settings
    @Test
    public void defaultSettingsInitialization() throws IOException {

        SettingsManager manager = new SettingsManager();
        Settings settings = new Settings(manager, 25, 3, 3, 50, null, true, null);
        settings = manager.getSettings(1L);

        Assert.assertEquals(0L, settings.textId);
        Assert.assertEquals(0, settings.voiceId);
        Assert.assertEquals(0, settings.roleId);
        Assert.assertEquals(null, settings.getDefaultPlaylist());
        Assert.assertEquals(false, settings.getRepeatMode());
        Assert.assertEquals(null, settings.getPrefix());

    }

    @Test
    public void WriteReadSettings(){
        SettingsManager manager = new SettingsManager();
        Settings settings; //= new Settings(manager, 25, 3, 3, 50, null, true, null);
        settings = manager.getSettings(1L);
        settings.textId = randomLong(0L, 2147483648L);;
        settings.voiceId = randomLong(0L, 2147483648L);;
        settings.roleId = randomLong(0L, 2147483648L);;
        settings.setVolume(randomInt(0, 2147483647));
        settings.setDefaultPlaylist("Test");
        settings.setRepeatMode(randomBoolean());
        settings.setPrefix("TestP");

        //manager.writeSettings();

        SettingsManager manager1 = new SettingsManager();
        Settings settings1;
        settings1 = manager1.getSettings(1L);


        Assert.assertEquals(settings.textId, settings1.textId);
        Assert.assertEquals(settings.voiceId, settings1.voiceId);
        Assert.assertEquals(settings.roleId, settings.roleId);
        Assert.assertEquals(settings.getVolume(), settings1.getVolume());
        Assert.assertEquals(settings.getDefaultPlaylist(), settings1.getDefaultPlaylist());
        Assert.assertEquals(settings.getRepeatMode(), settings1.getRepeatMode());
        Assert.assertEquals(settings.getPrefix(), settings1.getPrefix());

    }

    private long randomLong(long min, long max){

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return min + (long) (Math.random() * (max - min));
    }

    private boolean randomBoolean(){
        Random r = new Random();
        return r.nextBoolean();
    }

    private int randomInt(int min, int max){

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return min + (int) (Math.random() * (max - min));
    }


}
