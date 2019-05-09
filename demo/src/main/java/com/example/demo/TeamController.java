package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @RequestMapping("/teams")
    public List<Team> getThanks(){
        return teamService.getAllTeams();
    }

    @RequestMapping("/teams/{id}")
    public Team getTeam(@PathVariable String id){
        return teamService.getTeam(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/teams")
    public void addTeam (@RequestBody Team team) {
        teamService.addTeam(team);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/teams/{id}")
    public void updateTeam(@RequestBody Team team, @PathVariable String id){
        teamService.updateTeam(team,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/teams/{id}")
    public void deleteTeam(@RequestBody Team team, @PathVariable String id){
        teamService.deleteTeam(id);}
}
