package com.example.springjpa.convert;

import com.example.springjpa.entity.User;
import com.example.springjpa.vo.response.UserPageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author : brian
 * @since 0.1
 * https://mapstruct.org/documentation/stable/reference/html/#implicit-type-conversions
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    /**
     * convert
     * @param bean origin
     * @return target
     */
    UserPageResponse convert(User bean);

}
