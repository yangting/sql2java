package cn.data.dataprocess.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.data.dataprocess.metadata.dao.IBaseMapperDao;
import cn.data.dataprocess.metadata.dao.mapper.DVarietyInfoMapper;
import cn.data.dataprocess.service.IDVarietyInfoService;
import one.yate.test.metadata.entity.DVarietyInfo;


/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
@Service
public class DVarietyInfoServiceImpl extends BaseServiceImpl<DVarietyInfo,Long> implements IDVarietyInfoService {
@Resource
private DVarietyInfoMapper mapper;

protected IBaseMapperDao<DVarietyInfo,Long> getMapperDao() {
return mapper;
}
}