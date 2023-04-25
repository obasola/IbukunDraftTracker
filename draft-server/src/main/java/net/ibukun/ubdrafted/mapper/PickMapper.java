package net.ibukun.ubdrafted.mapper;


import net.ibukun.ubdrafted.domain.dto.PickDto;
import net.ibukun.ubdrafted.domain.entity.Pick;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class PickMapper {
    public  static void mapToDomain(
            Pick destination,
            PickDto source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(
            PickDto destination,
            Pick source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(List<PickDto> modelList,
                                  List<Pick> domainList) throws Exception {
        for (Pick domain : domainList) {
            PickDto model = new PickDto();
            PickMapper.mapToDomain(domain, model);
            modelList.add(model);
        }
    }

    public static void mapToDomain(List<Pick> domainList,
                                   List<PickDto> modelList) throws Exception {
        for (PickDto model : modelList) {
            Pick domain = new Pick();
            PickMapper.mapToDomain(domain, model);
            domainList.add(domain);
        }
    }
}
