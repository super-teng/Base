package annotation.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Super腾 on 2017/1/5.
 * 持久层
 */
public interface CodingDao {
    public void insertCoding();
    public void deleteCoding();
    public void updateCoding();
    public void searchCoding();
}
