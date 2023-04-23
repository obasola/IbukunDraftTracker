package net.ibukun.idraft.team;

import org.springframework.beans.BeanUtils;
import java.util.List;

public class TeamMapper {
    public  static void mapToDomain(
            Team destination,
            TeamDto source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(
            TeamDto destination,
            Team source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(List<TeamDto> modelList,
                                  List<Team> domainList) throws Exception {
        for (Team domain : domainList) {
            TeamDto model = new TeamDto();
            net.ibukun.idraft.team.TeamMapper.mapToDomain(domain, model);
            modelList.add(model);
        }
    }

    public static void mapToDomain(List<Team> domainList,
                                   List<TeamDto> modelList) throws Exception {
        for (TeamDto model : modelList) {
            Team domain = new Team();
            net.ibukun.idraft.team.TeamMapper.mapToDomain(domain, model);
            domainList.add(domain);
        }
    }
}
