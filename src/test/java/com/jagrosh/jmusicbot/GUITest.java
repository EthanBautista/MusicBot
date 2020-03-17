package com.jagrosh.jmusicbot;

import static org.junit.Assert.*;

import javax.swing.JTextArea;

import org.junit.Test;

import com.jagrosh.jmusicbot.entities.Prompt;
import com.jagrosh.jmusicbot.gui.TextAreaOutputStream;

public class GUITest {

	@Test
	public void testTextAreaOutputStream() {
		// Initialize
        Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
        BotConfig config = new BotConfig(prompt);
        config.load();
        JTextArea textArea = new JTextArea(5,100);
        TextAreaOutputStream testText = new TextAreaOutputStream(textArea,1000);
        testText.clear();
        assertNull(testText.appender);
        
		
	}
	@Test
	public void testClear() {
		fail("Not yet implemented");
	}
	@Test
	public void testClose() {
		fail("Not yet implemented");
	}
	@Test
	public void testFlush() {
		fail("Not yet implemented");
	}
	@Test
	public void testWrite() {
		fail("Not yet implemented");
	}
	@Test
	public void testWriteTwo() {
		fail("Not yet implemented");
	}
	@Test
	public void testWriteThree() {
		fail("Not yet implemented");
	}

}
