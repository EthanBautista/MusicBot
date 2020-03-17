package com.jagrosh.jmusicbot;

import static org.junit.Assert.*;

import java.util.logging.Level;

import org.junit.Test;

import com.jagrosh.jmusicbot.entities.Pair;
import com.jagrosh.jmusicbot.entities.Prompt;

public class EntitiesTest {

	@Test
	public void testGetValue() {
		// Initialize
        Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
        BotConfig config = new BotConfig(prompt);
        config.load();
        
        Pair apple = new Pair(5,"Hello");
        assertEquals("Hello", apple.getValue());
	}
	@Test
	public void testGetKey() {
		// Initialize
        Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
        BotConfig config = new BotConfig(prompt);
        config.load();
        
        Pair apple = new Pair(5,"Hello");
        assertEquals(5, apple.getKey());
	}
	
	@Test
	public void testIsNoGui() {
		// Initialize
        Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
        BotConfig config = new BotConfig(prompt);
        config.load();
        Prompt newPrompt = new Prompt("New Prompt Pop");
        assertEquals(false,newPrompt.isNoGUI());
	}
	@Test
	public void testPromptWorking() {
		// Initialize
        Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
        BotConfig config = new BotConfig(prompt);
        config.load();
        Prompt newPrompt = new Prompt("New Prompt Pop");
        assertEquals("Hello", newPrompt.prompt("Say Hello"));
	}
	@Test
	public void testPromptNotWorking() {
		// Initialize
        Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
        BotConfig config = new BotConfig(prompt);
        config.load();
        Prompt newPrompt = new Prompt("New Prompt Pop");
        assertEquals(null, newPrompt.prompt("Close the Box"));
	}
	
	/*ALERT function testing should go here.*/ 

}
