package cn.data.dataprocess.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.data.dataprocess.metadata.dao.IBaseMapperDao;
import cn.data.dataprocess.metadata.dao.mapper.DTradeInfoMapper;
import cn.data.dataprocess.service.IDTradeInfoService;
import one.yate.test.metadata.entity.DTradeInfo;


/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
@Service
public class DTradeInfoServiceImpl extends BaseServiceImpl<DTradeInfo,Long> implements IDTradeInfoService {
@Resource
private DTradeInfoMapper mapper;

protected IBaseMapperDao<DTradeInfo,Long> getMapperDao() {
return mapper;
}
}