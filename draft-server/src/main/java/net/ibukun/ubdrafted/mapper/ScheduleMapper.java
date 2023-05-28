package net.ibukun.ubdrafted.mapper;

import net.ibukun.ubdrafted.domain.dto.ScheduleDto;
import net.ibukun.ubdrafted.domain.entity.Schedule;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class ScheduleMapper {
    public  static void mapToDomain(
            Schedule destination,
            ScheduleDto source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(
            ScheduleDto destination,
            Schedule source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(List<ScheduleDto> modelList,
                                  List<Schedule> domainList) throws Exception {
        for (Schedule domain : domainList) {
            ScheduleDto model = new ScheduleDto();
            ScheduleMapper.mapToDomain(domain, model);
            modelList.add(model);
        }
    }

    public static void mapToDomain(List<Schedule> domainList,
                                   List<ScheduleDto> modelList) throws Exception {
        for (ScheduleDto model : modelList) {
            Schedule domain = new Schedule();
            ScheduleMapper.mapToDomain(domain, model);
            domainList.add(domain);
        }
    }
}
