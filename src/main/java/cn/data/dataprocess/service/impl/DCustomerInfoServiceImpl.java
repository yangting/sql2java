package cn.data.dataprocess.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.data.dataprocess.metadata.dao.IBaseMapperDao;
import cn.data.dataprocess.metadata.dao.mapper.DCustomerInfoMapper;
import cn.data.dataprocess.service.IDCustomerInfoService;
import one.yate.test.metadata.entity.DCustomerInfo;


/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
@Service
public class DCustomerInfoServiceImpl extends BaseServiceImpl<DCustomerInfo,Long> implements IDCustomerInfoService {
@Resource
private DCustomerInfoMapper mapper;

protected IBaseMapperDao<DCustomerInfo,Long> getMapperDao() {
return mapper;
}
}