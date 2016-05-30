package cn.data.dataprocess.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.data.dataprocess.metadata.dao.IBaseMapperDao;
import cn.data.dataprocess.metadata.dao.mapper.PuerBatchStatusMapper;
import cn.data.dataprocess.service.IPuerBatchStatusService;
import one.yate.test.metadata.entity.PuerBatchStatus;


/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
@Service
public class PuerBatchStatusServiceImpl extends BaseServiceImpl<PuerBatchStatus,Long> implements IPuerBatchStatusService {
@Resource
private PuerBatchStatusMapper mapper;

protected IBaseMapperDao<PuerBatchStatus,Long> getMapperDao() {
return mapper;
}
}