package net.ibukun.ubdrafted.mapper;

import net.ibukun.ubdrafted.domain.dto.CombineScoreDto;
import net.ibukun.ubdrafted.domain.entity.CombineScore;
import org.springframework.beans.BeanUtils;
import java.util.List;

public class CombineScoreMapper {
    public  static void mapToDomain(
            CombineScore destination,
            CombineScoreDto source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(
            CombineScoreDto destination,
            CombineScore source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(List<CombineScoreDto> modelList,
                                  List<CombineScore> domainList) throws Exception {
        for (CombineScore domain : domainList) {
            CombineScoreDto model = new CombineScoreDto();
            CombineScoreMapper.mapToDomain(domain, model);
            modelList.add(model);
        }
    }

    public static void mapToDomain(List<CombineScore> domainList,
                                   List<CombineScoreDto> modelList) throws Exception {
        for (CombineScoreDto model : modelList) {
            CombineScore domain = new CombineScore();
            CombineScoreMapper.mapToDomain(domain, model);
            domainList.add(domain);
        }
    }
}
