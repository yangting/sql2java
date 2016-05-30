package cn.data.dataprocess.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.data.dataprocess.metadata.dao.IBaseMapperDao;
import cn.data.dataprocess.metadata.dao.mapper.DEntrustInfoMapper;
import cn.data.dataprocess.service.IDEntrustInfoService;
import one.yate.test.metadata.entity.DEntrustInfo;


/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
@Service
public class DEntrustInfoServiceImpl extends BaseServiceImpl<DEntrustInfo,Long> implements IDEntrustInfoService {
@Resource
private DEntrustInfoMapper mapper;

protected IBaseMapperDao<DEntrustInfo,Long> getMapperDao() {
return mapper;
}
}