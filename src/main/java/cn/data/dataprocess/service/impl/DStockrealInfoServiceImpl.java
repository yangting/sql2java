package cn.data.dataprocess.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.data.dataprocess.metadata.dao.IBaseMapperDao;
import cn.data.dataprocess.metadata.dao.mapper.DStockrealInfoMapper;
import cn.data.dataprocess.service.IDStockrealInfoService;
import one.yate.test.metadata.entity.DStockrealInfo;


/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
@Service
public class DStockrealInfoServiceImpl extends BaseServiceImpl<DStockrealInfo,Long> implements IDStockrealInfoService {
@Resource
private DStockrealInfoMapper mapper;

protected IBaseMapperDao<DStockrealInfo,Long> getMapperDao() {
return mapper;
}
}