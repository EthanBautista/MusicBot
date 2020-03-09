package com.jagrosh.jmusicbot;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jagrosh.jmusicbot.entities.Prompt;
import com.jagrosh.jmusicbot.utils.FormatUtil;
import com.jagrosh.jmusicbot.utils.OtherUtil;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

public class BotConfigTest {

	@Test
	public void isValidTest() {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();

		boolean result = config.isValid();
		assertEquals(true, result);
	}
	
	@Test
	public void getAltPrefixTest() {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
	
		String result = config.getAltPrefix();
		assertEquals(null, result);
	}
	
	@Test
	public void getPrefixTest() {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String expected = expectedConfig.getString("prefix");
		String result = config.getPrefix();
		assertEquals(expected, result);
	}
	@Test
	public void getTokenTest() {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String expected = expectedConfig.getString("token");
		String result = config.getToken();
		assertEquals(expected, result);
	}

	@Test
	public void getOwnerIdTest() {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String expected = expectedConfig.getString("owner");
		long result = config.getOwnerId();
		assertEquals(Long.parseLong(expected), result);
	}
	@Test
	public void getSuccessTest() {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String expected = expectedConfig.getString("success");
		String result = config.getSuccess();
		assertEquals(expected, result);
	}
	@Test
	public void getWarningTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String expected = expectedConfig.getString("warning");
		String result = config.getWarning();
		assertEquals(expected, result);
    }
	
	@Test
    public void getErrorTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String expected = expectedConfig.getString("error");
		String result = config.getError();
		assertEquals(expected, result);
    }
	
	@Test
    public void getLoadingTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String expected = expectedConfig.getString("loading");
		String result = config.getLoading();
		assertEquals(expected, result);
    }
	
	@Test
    public void getSearchingTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String expected = expectedConfig.getString("searching");
		String result = config.getSearching();
		assertEquals(expected, result);
    }
	
	@Test
    public void getGameTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();;
		Game expected = OtherUtil.parseGame(expectedConfig.getString("game"));
		Game result = config.getGame();
		assertEquals(expected, result);
    }
	
	@Test
    public void getStatusTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();;
		OnlineStatus expected = OtherUtil.parseStatus(expectedConfig.getString("status"));
		OnlineStatus result = config.getStatus();
		assertEquals(expected, result);
    }
	
	@Test
    public void getHelpTest(){
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String expected = expectedConfig.getString("help");
		String result = config.getHelp();
		assertEquals(expected, result);
    }
	
	@Test
    public void getStayTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String expected = expectedConfig.getString("stayinchannel");
		boolean result = config.getStay();
		assertEquals(Boolean.parseBoolean(expected), result);
    }
	
	@Test
    public void getSongInStatusTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String expected = expectedConfig.getString("songinstatus");
		boolean result = config.getSongInStatus();
		assertEquals(Boolean.parseBoolean(expected), result);
    }
	
	@Test
    public void getPlaylistsFolderTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String expected = expectedConfig.getString("playlistsfolder");
		String result = config.getPlaylistsFolder();
		assertEquals(expected, result);
    }
	
	@Test
    public void getDBotsTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		String owner = expectedConfig.getString("owner");
		boolean expected = Long.parseLong(owner) == 113156185389092864L;
		boolean result = config.getDBots();
		assertEquals(expected, result);
    }
	
	@Test
    public void useUpdateAlertsTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		boolean expected = expectedConfig.getBoolean("updatealerts");
		boolean result = config.useUpdateAlerts();
		assertEquals(expected, result);
    }
	
	@Test
    public void useEvalTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		boolean expected = expectedConfig.getBoolean("eval");
		boolean result = config.useEval();
		assertEquals(expected, result);
    }
	
	@Test
    public void useNPImagesTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		boolean expected = expectedConfig.getBoolean("npimages");
		boolean result = config.useNPImages();
		assertEquals(expected, result);
    }
	
	@Test
    public void getMaxSecondsTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		Config expectedConfig = ConfigFactory.load();
		long expected = expectedConfig.getLong("maxtime");
		long result = config.getMaxSeconds();
		assertEquals(expected, result);
    }
	
	@Test
    public void getMaxTimeTest()
    {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		long max = config.getMaxSeconds();
		String expected = FormatUtil.formatTime(max * 1000);
		String result = config.getMaxTime();
		assertEquals(expected, result);
    }
	
	//Skipped isTooLong Function
	//Skipped getAliases Function

}
