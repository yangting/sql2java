package cn.data.dataprocess.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.data.dataprocess.metadata.dao.IBaseMapperDao;
import cn.data.dataprocess.metadata.dao.mapper.DFundInfoMapper;
import cn.data.dataprocess.service.IDFundInfoService;
import one.yate.test.metadata.entity.DFundInfo;


/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
@Service
public class DFundInfoServiceImpl extends BaseServiceImpl<DFundInfo,Long> implements IDFundInfoService {
@Resource
private DFundInfoMapper mapper;

protected IBaseMapperDao<DFundInfo,Long> getMapperDao() {
return mapper;
}
}