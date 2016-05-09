package com.dyyt.syncdb.metadata.dao;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
public interface IBaseMapperDao<E, PK> {
    /**
     * @description 通过实体进行添加
     * @param e
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(final E e);

    /**
     * @description 通过集合进行批量添加
     * @param e
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void batchAdd(final List<E> list);

    /**
     * @description 通过主键进行删除
     * @param e
     */
    Integer remove(@Param(value = "id") final PK e);

    /**
     * @description 通过主键进行批量删除
     * @param e
     */
    void batchRemove(final PK[] ids);

    /**
     * @description 通过实体更新
     * @param e
     */
    Integer update(final E e);

    /**
     * @description 通过主键查询
     * @param id
     * @return
     * @throws Exception
     */
    E getEntity(@Param(value = "id") final PK id);
}