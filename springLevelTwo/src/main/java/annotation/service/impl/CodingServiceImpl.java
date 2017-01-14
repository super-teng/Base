package annotation.service.impl;

import annotation.dao.CodingDao;
import annotation.service.CodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Super腾 on 2017/1/5.
 */
@Service
public class CodingServiceImpl implements CodingService {
    @Autowired
    private CodingDao codingDao;
    public void insertCoding() {
        codingDao.insertCoding();
    }

    public void deleteCoding() {
        codingDao.deleteCoding();
    }

    public void updateCoding() {
        codingDao.updateCoding();
    }

    public void searchCoding() {
        codingDao.searchCoding();
    }
}
