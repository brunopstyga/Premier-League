package com.example.myapplicationteams.presentationview;

import com.example.myapplicationteams.model.data.entity.Team;
import com.example.myapplicationteams.model.data.room.FeaturesDB;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class TeamsActivityTest {

    TeamsActivity subject = new TeamsActivity();

    List<Team> teams = Stream.of(new Team("stadium A","team A", 1,
                    "", ""
            ,5, "stadium A", "photo", 1),
            new Team("stadium B","team B", 2, "", ""
                    ,6, "stadium B", "photo", 2)
    ).collect(Collectors.toList());

    List<FeaturesDB> expected = Stream.of(new FeaturesDB(0, "photo", "stadium A"),
            new FeaturesDB(1, "photo", "stadium B")).collect(Collectors.toList());

    @Test
    public void onCreate() {
    }

    @Test
    public void setUpView() {
    }

    @Test
    public void reachData() {


        List<FeaturesDB> actual = subject.reachData(teams);

        assertEquals(2, actual.size());
        assertTrue(expected.get(0).getDescrip().equalsIgnoreCase(actual.get(0).getDescrip()));
        assertTrue(expected.get(0).equals(actual.get(0)));

    }
}