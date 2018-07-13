package com.criva.onboardingproject.service.message;

import com.criva.onboardingproject.model.dao.ContextDAO;
import com.criva.onboardingproject.model.vo.message.Context;
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
    public Context saveContext(Context context) {

        return contextDAO.save(context);
    }

    @Override
    public List<Context> saveContexts(List<Context> contexts) {

        return contextDAO.saveAll(contexts);
    }

    @Override
    public List<Context> findAllByIds(List<String> ids) {

        return contextDAO.findAllByIdIn(ids);
    }
}
