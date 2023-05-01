package top.om1ga.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.om1ga.common.constant.Constant;
import top.om1ga.common.utils.PageResult;
import top.om1ga.convert.NoticeConvert;
import top.om1ga.dao.NoticeDao;
import top.om1ga.entity.NoticeEntity;
import top.om1ga.mybatis.service.impl.BaseServiceImpl;
import top.om1ga.query.NoticeQuery;
import top.om1ga.service.NoticeService;
import top.om1ga.vo.NoticeVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月20日 21:37
 * @Description:
 * @since: 1.0
 */
@Service
@AllArgsConstructor
public class NoticeServiceImpl extends BaseServiceImpl<NoticeDao, NoticeEntity> implements NoticeService {
    @Override
    public PageResult<NoticeVO> page(NoticeQuery query) {
        System.out.println(query);
        Map<String, Object> params = getParams(query);
        IPage<NoticeEntity> page = getPage(query);
        params.put(Constant.PAGE,page);
        List<NoticeEntity> list = baseMapper.getList(params);
        return new PageResult<>(NoticeConvert.INSTANCE.convertList(list), page.getTotal());
    }

    private Map<String,Object> getParams(NoticeQuery query){
        Map<String,Object> params = new HashMap<>();
        params.put("title",query.getTitle());
        params.put("content",query.getContent());
        return params;
    }


    private Wrapper<NoticeEntity> getWrapper(NoticeQuery query){
        LambdaQueryWrapper<NoticeEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getTitle()),NoticeEntity::getTitle,query.getTitle());
        return wrapper;
    }

    @Override
    public List<NoticeVO> getList() {
        NoticeQuery query = new NoticeQuery();
        List<NoticeEntity> entityList = baseMapper.selectList(getWrapper(query));
        return NoticeConvert.INSTANCE.convertList(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(NoticeVO vo) {
    NoticeEntity entity = NoticeConvert.INSTANCE.convert(vo);
    baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(NoticeVO vo) {
        NoticeEntity entity = NoticeConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        removeByIds(ids);
    }
}
