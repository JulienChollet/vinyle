package com.app.vinyle.mapper;

import com.app.vinyle.domain.VinyleDomain;
import com.app.vinyle.dto.VinyleRequest;
import com.app.vinyle.dto.VinyleResponse;
import com.app.vinyle.entity.VinyleEntity;

public class VinyleMapper {

    public static VinyleEntity domainToEntity (VinyleDomain vinyleDomain){
        return new VinyleEntity(vinyleDomain.id(), vinyleDomain.band(),vinyleDomain.name(),vinyleDomain.titles(),
                vinyleDomain.type(),vinyleDomain.description());
    }
    public static VinyleDomain entityToDoamain(VinyleEntity vinyleEntity){
        return new VinyleDomain (vinyleEntity.getId(), vinyleEntity.getBand(),vinyleEntity.getName(),vinyleEntity.getTitles(),
                vinyleEntity.getType(),vinyleEntity.getDescription());
    }

    public static VinyleDomain vinyleRequestToDomain(VinyleRequest vinyleRequest){
        return new VinyleDomain(vinyleRequest.id(), vinyleRequest.band(), vinyleRequest.name(),
                vinyleRequest.titles(), vinyleRequest.type(), vinyleRequest.description());
    }

    public static VinyleDomain vinyleResponseToDomain(VinyleResponse vinyleResponse) {

        return  new VinyleDomain(vinyleResponse.id(), vinyleResponse.band(), vinyleResponse.band(),
                vinyleResponse.titles(), vinyleResponse.type(), vinyleResponse.description());
    }


}
