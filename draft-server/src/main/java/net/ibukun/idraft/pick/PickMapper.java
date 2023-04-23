package net.ibukun.idraft.pick;

import net.ibukun.idraft.pick.Pick;
import net.ibukun.idraft.pick.PickDto;
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
            net.ibukun.idraft.pick.PickMapper.mapToDomain(domain, model);
            modelList.add(model);
        }
    }

    public static void mapToDomain(List<Pick> domainList,
                                   List<PickDto> modelList) throws Exception {
        for (PickDto model : modelList) {
            Pick domain = new Pick();
            net.ibukun.idraft.pick.PickMapper.mapToDomain(domain, model);
            domainList.add(domain);
        }
    }
}
