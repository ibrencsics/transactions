package org.ib.transactions.mysql;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.Types;

/**
 * Created with IntelliJ IDEA.
 * User: ibrencsics
 * Date: 2012.12.14.
 * Time: 16:59
 * To change this template use File | Settings | File Templates.
 */
public class ExampleDAO extends JdbcDaoSupport {

    private static final String INSERT_TRANSACTION_TEST_TABLE = "insert into transaction_test_table (time, action) values (?,?)";

    public int insertTransactionTest(String time, String action) {
        return getJdbcTemplate().update(INSERT_TRANSACTION_TEST_TABLE, new Object[]{time, action});
    }
}
