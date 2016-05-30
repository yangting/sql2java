package cn.data.dataprocess.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.data.dataprocess.metadata.dao.IBaseMapperDao;
import cn.data.dataprocess.metadata.dao.mapper.DAgentInfoMapper;
import cn.data.dataprocess.service.IDAgentInfoService;
import one.yate.test.metadata.entity.DAgentInfo;


/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
@Service
public class DAgentInfoServiceImpl extends BaseServiceImpl<DAgentInfo,Long> implements IDAgentInfoService {
@Resource
private DAgentInfoMapper mapper;

protected IBaseMapperDao<DAgentInfo,Long> getMapperDao() {
return mapper;
}
}