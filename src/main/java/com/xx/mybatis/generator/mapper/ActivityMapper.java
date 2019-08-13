package com.xx.mybatis.generator.mapper;

import com.xx.mybatis.generator.domain.ActivityDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.Map;


public interface ActivityMapper {

	int save(ActivityDO activityDO);

    int deleteById(@Param("id")Long id);

    int deleteBatchById(@Param("ids")List<Long> ids);

    int updateById(ActivityDO activityDO);

    ActivityDO getById(@Param("id")Long id);

    List<ActivityDO> listById(@Param("ids")List<Long> ids);

    ActivityDO getByActivitySource(@Param("activityId")Long activityId,@Param("activityType")Integer activityType,@Param("source")Integer source);

    List<ActivityDO> listByActivitySource(@Param("activityIds")List<Long> activityIds,@Param("activityTypes")List<Integer> activityTypes,@Param("sources")List<Integer> sources);

    List<ActivityDO> listByParam(Map params);

    Integer countByParam(Map params);
}
