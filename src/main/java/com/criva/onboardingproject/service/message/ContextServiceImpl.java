package com.criva.onboardingproject.service.message;

import com.criva.onboardingproject.model.dao.ContextDAO;
import com.criva.onboardingproject.model.vo.message.ContextVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContextServiceImpl implements ContextService {

    private ContextDAO contextDAO;

    @Autowired
    public ContextServiceImpl(ContextDAO contextDAO) {

        this.contextDAO = contextDAO;
    }

    @Override
    public ContextVO saveContext(ContextVO context) {

        return contextDAO.save(context);
    }

    @Override
    public List<ContextVO> saveContexts(List<ContextVO> contexts) {

        return contextDAO.saveAll(contexts);
    }
}
