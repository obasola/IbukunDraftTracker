package net.ibukun.ubdrafted.test;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.ibukun.ubdrafted.builder.PickBuilder;
import net.ibukun.ubdrafted.builder.TeamBuilder;
import net.ibukun.ubdrafted.domain.dto.PickDto;
import net.ibukun.ubdrafted.domain.dto.TeamDto;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.adelean.inject.resources.core.InjectResources.resource;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestWithResources
public class PickBuilderTest {
    @GivenTextResource("/net/ibukun/ubdrafted/test/pickData.json")
    String resourceContent;
    Logger log = Logger.getLogger("PickBuilder");
    private String COMMA_DELIMITER = ",";

    @Test
    public void getSelectionByTeamAndRound() {
        String[] data = new String[]{"1","1","1","31","6.34","2023","Kansas City Chiefs","Kansas City","AFC West"};
        PickDto dto =  buildTeamPick(data);
        assertNotNull(dto);
        assertEquals("Not matching","Kansas City Chiefs", dto.getTeam().getName());
        assertNotNull(dto.getCombineScore());
    }
    private PickDto buildTeamPick(String[] data) {

        int pickId = data[0] != null ? Integer.parseInt(data[0].replace(" ","")) : 0;
        int teamId = data[1] != null ? Integer.parseInt(data[1].replace(" ","")) : 0;
        int roundSelected = data[2] != null ? Integer.parseInt(data[2].replace(" ","")) : 0;
        int pickNumber = data[3] != null ? Integer.parseInt(data[3].replace(" ","")) : 0;
        float combineScore = data[4] != null ? Float.parseFloat(data[4].replace(" ","")) : 0;

        String draftYearStr = data[5];
        String teamName=data[6];
        String teamCity = data[7];
        String teamConference = data[8];

        PickBuilder builder = new PickBuilder(
                pickId,buildTeamDto(teamId,teamName,teamCity,teamConference),
                roundSelected,pickNumber,draftYearStr, combineScore);

        return builder.build();
    }
    private PickDto buildTeamPick() {
        int pickId = 1;
        int teamId = 1;
        int roundSelected = 1;
        int pickNumber = 31;
        String draftYearStr = "2023";
        String teamName="Kansas City Chiefs";
        String teamCity = "Kansas City";
        String teamConference = "AFC West";
        float combineScore = Float.parseFloat("6.10");
        PickBuilder builder = new PickBuilder(pickId,buildTeamDto(teamId,teamName,teamCity,teamConference),
                roundSelected,pickNumber,draftYearStr, combineScore);
        return builder.build();
    }

    private TeamDto buildTeamDto(int teamId, String teamName, String teamCity, String teamConference) {
        TeamBuilder builder = new TeamBuilder(teamId, teamName, teamCity, teamConference);
        return builder.build();
    }
}
