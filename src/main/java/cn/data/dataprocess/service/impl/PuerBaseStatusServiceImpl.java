package cn.data.dataprocess.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.data.dataprocess.metadata.dao.IBaseMapperDao;
import cn.data.dataprocess.metadata.dao.mapper.PuerBaseStatusMapper;
import cn.data.dataprocess.service.IPuerBaseStatusService;
import one.yate.test.metadata.entity.PuerBaseStatus;


/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
@Service
public class PuerBaseStatusServiceImpl extends BaseServiceImpl<PuerBaseStatus,Long> implements IPuerBaseStatusService {
@Resource
private PuerBaseStatusMapper mapper;

protected IBaseMapperDao<PuerBaseStatus,Long> getMapperDao() {
return mapper;
}
}