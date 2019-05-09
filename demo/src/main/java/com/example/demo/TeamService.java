package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository ;

    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        teamRepository.findAll().forEach(teams::add);
        if (teams.size() == 0) {
            teamRepository.save(new  Team("Birds of Prey","Gotham"));
            teamRepository.save(new  Team("League of Justice","Washington D.C"));
            teamRepository.save(new  Team("Teen Titans","Jump City"));
            teamRepository.findAll().forEach(teams::add);
        }
        return teams;
    }

    public Team getTeam(String id) {
        return (Team)teamRepository.findById(id).orElse(new Team("Missing Team", "NA"));
    }

    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    public void updateTeam(Team team, String id) {
        teamRepository.save(team);
    }

    public void deleteTeam(String id) {
        teamRepository.delete(getTeam(id));
    }
}
