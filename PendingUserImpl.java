package baihoc.minimart.daoimpl;

import baihoc.minimart.dao.PendingUserDao;
import baihoc.minimart.entity.PendingUser;
import baihoc.minimart.until.XJdbc;
import baihoc.minimart.until.XQuery;
import java.sql.Timestamp;

public class PendingUserImpl implements PendingUserDao {

    private final String insertSql = "INSERT INTO PendingUser (Username, Password, Fullname, OTP, ExpiredAt) VALUES (?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE PendingUser SET Password=?, Fullname=?, OTP=?, ExpiredAt=? WHERE Username=?";
    private final String deleteSql = "DELETE FROM PendingUser WHERE Username=?";
    private final String findByUsernameSql = "SELECT * FROM PendingUser WHERE Username=?";

    @Override
    public boolean insert(PendingUser user) {
    return XJdbc.executeUpdate(insertSql,
    user.getUsername(),
    user.getPassword(),
    user.getFullname(),
    user.getOtp(),
    user.getExpiredAt() // ❌ bỏ Timestamp.valueOf
) > 0;
    }

    @Override
    public PendingUser findByUsername(String username) {
return XQuery.getSingleBean(PendingUser.class,
    findByUsernameSql,
    username
);
    }

    @Override
    public boolean delete(String username) {
        return XJdbc.executeUpdate(deleteSql, username) > 0;
    }

    @Override
    public void save(PendingUser pendingUser) {
      XJdbc.executeUpdate(updateSql,
    pendingUser.getPassword(),
    pendingUser.getFullname(),
    pendingUser.getOtp(),
    pendingUser.getExpiredAt(), // ❌ bỏ Timestamp.valueOf
    pendingUser.getUsername()
);

    }
}
