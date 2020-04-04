package com.jagrosh.jmusicbot.playlist;

import static org.junit.Assert.*;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

import com.jagrosh.jmusicbot.playlist.PlaylistLoader;
import com.jagrosh.jmusicbot.playlist.PlaylistLoader.Playlist;

import com.jagrosh.jmusicbot.BotConfig;
import com.jagrosh.jmusicbot.entities.Prompt;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class PlaylistLoaderTest {
	
	@Test
	public void createFolderTest(){
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		
		PlaylistLoader playlist = new PlaylistLoader(config);
		
		playlist.createFolder();
		Path path = Paths.get(config.getPlaylistsFolder());
		File dir = new File(path.toString());
		boolean exists = dir.exists();
		assertTrue(exists);	
	}

	@Test
	public void createPlaylistTest() throws IOException {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		
		PlaylistLoader playlist = new PlaylistLoader(config);
		
		
		Path path = Paths.get(config.getPlaylistsFolder()+File.separator+"test.txt");
		File dir = new File(path.toString());
		if( dir.exists()) {
			playlist.deletePlaylist("test");
		}
		playlist.createPlaylist("test");
		boolean exists = dir.exists();
		assertTrue(exists);	
		
	}
	
	@Test
	public void deletePlaylistTest() throws IOException {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		
		PlaylistLoader playlist = new PlaylistLoader(config);
		
		Path path = Paths.get(config.getPlaylistsFolder()+File.separator+"test1.txt");
		File dir = new File(path.toString());
		if( !dir.exists()) {
			playlist.createPlaylist("test1");
		}
		playlist.deletePlaylist("test1");
		boolean exists = dir.exists();
		assertFalse(exists);	
	}
	
	@Test
	public void writePlaylistTest() throws IOException {
		// Initialize
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		
		PlaylistLoader playlist = new PlaylistLoader(config);
		
		String expectedData = "testing";
		
		Path path = Paths.get(config.getPlaylistsFolder()+File.separator+"test.txt");
		File dir = new File(path.toString());
		if( dir.exists()) {
			playlist.deletePlaylist("test");
		}
		playlist.createPlaylist("test");
		playlist.writePlaylist("test", "testing");
	    BufferedReader reader = new BufferedReader(new FileReader(path.toString()));
	    String currentLine = reader.readLine();
	    reader.close();
	 
	    assertEquals(expectedData, currentLine);
	}

	@Test
	public void getPlaylistNull() {
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		
		PlaylistLoader playlist = new PlaylistLoader(config);
		
		Playlist play =  playlist.getPlaylist("test100");
		
		assertEquals(null,play);
	}
	

	@Test
	public void getPlaylistExist() {
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		
		
		PlaylistLoader playlist = new PlaylistLoader(config);

		Playlist play =  playlist.getPlaylist("test");
		
		assertNotNull(play);
	}
	
	@Test
	public void getPlaylistNamesExists() throws IOException {
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		
		PlaylistLoader playlist = new PlaylistLoader(config);
		

		Path path = Paths.get(config.getPlaylistsFolder()+File.separator+"bob.txt");
		File dir = new File(path.toString());
		Path path1 = Paths.get(config.getPlaylistsFolder()+File.separator+"job.txt");
		File dir1 = new File(path1.toString());
		Path path2 = Paths.get(config.getPlaylistsFolder()+File.separator+"gob.txt");
		File dir2 = new File(path2.toString());
		Path path3 = Paths.get(config.getPlaylistsFolder()+File.separator+"test.txt");
		File dir3 = new File(path3.toString());
		if( dir3.exists()) {
			playlist.deletePlaylist("test");
		}
		if( dir.exists()) {
			playlist.deletePlaylist("bob");
		}
		if( dir1.exists()) {
			playlist.deletePlaylist("job");
		}
		if( dir2.exists()) {
			playlist.deletePlaylist("gob");
		}
		playlist.createPlaylist("test");
		playlist.createPlaylist("bob");
		playlist.createPlaylist("job");
		playlist.createPlaylist("gob");
		
		List<String> list = playlist.getPlaylistNames();
		List<String> expected = new ArrayList<String>();
		
		expected.add("bob");
		expected.add("gob");
		expected.add("job");
		expected.add("test");
		
		assertEquals(list, expected);

	}
	
	@Test
	public void getIndexTest() {
		Prompt prompt = new Prompt("JMusicBot", "Switching to nogui mode. You can manually start in nogui mode by including the -Dnogui=true flag.", "true".equalsIgnoreCase(System.getProperty("nogui", "false")));
		BotConfig config = new BotConfig(prompt);
		config.load();
		PlaylistLoader playlist = new PlaylistLoader(config);
		int num = 1;
		String item = "Test";
		String reason = "Not Good";
		
		Playlist play =  playlist.getPlaylist("test");
		
	}

}
