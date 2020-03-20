package com.jagrosh.jmusicbot;

import static org.junit.Assert.*;

import java.io.PrintStream;

import javax.swing.JTextArea;

import org.junit.Test;

import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.jagrosh.jmusicbot.entities.Prompt;
import com.jagrosh.jmusicbot.gui.GUI;
import com.jagrosh.jmusicbot.gui.TextAreaOutputStream;
import com.jagrosh.jmusicbot.settings.SettingsManager;

public class GUITesting {

	@Test
	public void testTitle() {
		// Initialize
        EventWaiter waiter = new EventWaiter();
        SettingsManager settings = new SettingsManager();
        Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
        BotConfig config = new BotConfig(prompt);
        Bot bot = new Bot(waiter, config, settings);
        config.load();
        
        GUI screen = new GUI(bot);
        screen.init();
        assertEquals("JMusicBot", screen.getTitle());
		
	}

}
