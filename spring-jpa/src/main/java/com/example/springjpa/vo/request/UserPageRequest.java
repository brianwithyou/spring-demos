package com.example.springjpa.vo.request;

import com.example.springcommon.common.BasePageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author : brian
 * @since 0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserPageRequest extends BasePageRequest {

    private List<String> names;

    private String name;

    private String gender;
}
