package net.ibukun.ubdrafted.mapper;

import net.ibukun.ubdrafted.domain.dto.PlayerDto;
import net.ibukun.ubdrafted.domain.entity.Player;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class PlayerMapper {
    public  static void mapToDomain(
            Player destination,
            PlayerDto source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(
            PlayerDto destination,
            Player source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(List<PlayerDto> modelList,
                                  List<Player> domainList) throws Exception {
        for (Player domain : domainList) {
            PlayerDto model = new PlayerDto();
            PlayerMapper.mapToDomain(domain, model);
            modelList.add(model);
        }
    }

    public static void mapToDomain(List<Player> domainList,
                                   List<PlayerDto> modelList) throws Exception {
        for (PlayerDto model : modelList) {
            Player domain = new Player();
            PlayerMapper.mapToDomain(domain, model);
            domainList.add(domain);
        }
    }
}
