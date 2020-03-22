package com.jagrosh.jmusicbot.utils;

import com.jagrosh.jmusicbot.Utilities;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.impl.GuildImpl;
import net.dv8tion.jda.core.entities.impl.JDAImpl;
import net.dv8tion.jda.core.entities.impl.TextChannelImpl;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static com.jagrosh.jmusicbot.utils.FormatUtil.filter;
import static com.jagrosh.jmusicbot.utils.FormatUtil.progressBar;
import static com.jagrosh.jmusicbot.Utilities.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FormatUtilTest {

    @Test
    public void formatTimeTest(){
        //Note input is in ms
        String testA = FormatUtil.formatTime(3000);
        String testB = FormatUtil.formatTime(300000);
        String testC = FormatUtil.formatTime(60000);
        String testD = FormatUtil.formatTime(31500);
        String testE = FormatUtil.formatTime(0);
        String testF = FormatUtil.formatTime(Long.MAX_VALUE);

        assertEquals("00:03", testA);
        assertEquals("05:00", testB);
        assertEquals("01:00", testC);
        assertEquals("00:32", testD);
        assertEquals("00:00", testE);
        assertEquals("LIVE", testF);


    }

    @Test
    public void  progressBarTest(){

        final int stepCount = 12;
        final double stepSize = 1.00/stepCount;

        //Just testing a few thousand times
        for(int i = 0 ; i < 10000; i++){

            int testStep = randomInt(0, stepCount);
            double testValue = randomDouble(0.00, stepSize) + stepSize*testStep;

            String progressBar = progressBar(testValue);
            char value = progressBar.charAt( (int)(testValue/stepSize));

            assertNotEquals(value, '▬');
        }

    }

    //Skipped volume icon testing

    //Skipped listOfTChannels, listOfVChannels, listOfRoles to many dependencies

    @Test
    public void filterTest(){

        String[] tests = {"@here", "@everyone", "\u202E", "@everyone @here \u202E", "ExtraEndSpaceTest "};

        String result = filter(tests[0]);
        assertEquals("@h\u0435re", result);

        result = filter(tests[1]);
        assertEquals("@\u0435veryone", result);

        result = filter(tests[2]);
        assertEquals("", result);

        result = filter(tests[3]);
        assertEquals("@\u0435veryone @h\u0435re", result);

        result = filter(tests[4]);
        assertEquals("ExtraEndSpaceTest", result);



    }




}
