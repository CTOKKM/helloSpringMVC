package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository  // 이 클래스가 DAO(데이터 액세스 객체)임을 나타내며, Spring이 자동으로 Bean으로 등록
public class OfferDao {

    private JdbcTemplate jdbcTemplate;  // Spring에서 제공하는 JDBC 템플릿 클래스 (SQL 실행을 간소화)

    @Autowired
    public void setDataSource(DataSource dataSource) {
        // DataSource를 통해 DB 연결을 설정하고, 이를 기반으로 JdbcTemplate을 초기화
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 전체 행(row) 개수를 조회 (SELECT COUNT)
    public int getRowCount() {
        String sqlStatement = "select count(*) from offers";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }

    // CRUD(create, reference(조회), update, delete) operation
    // 특정 name을 가진 Offer 객체 1개 조회 (단일 행 결과) - R
    public Offer getOffer(String name) {
        String sqlStatement = "select * from offers where name=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[]{name},
                new RowMapper<Offer>() {
                    @Override
                    public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        // ResultSet → Offer 객체로 변환
                        Offer offer = new Offer();
                        offer.setId(rs.getInt("id"));
                        offer.setName(rs.getString("name"));
                        offer.setEmail(rs.getString("email"));
                        offer.setText(rs.getString("text"));
                        return offer;
                    }
                });
    }

    // 전체 Offer 목록을 조회 (여러 행 결과) - R
    public List<Offer> getOffers() {
        String sqlStatement = "select * from offers";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {
            @Override
            public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Offer offer = new Offer();
                offer.setId(rs.getInt("id"));
                offer.setName(rs.getString("name"));
                offer.setEmail(rs.getString("email"));
                offer.setText(rs.getString("text"));
                return offer;
            }
        });
    }

    // Offer 객체를 DB에 삽입 (Insert) - C
    public boolean insert(Offer offer) {
        String name = offer.getName();
        String email = offer.getEmail();
        String text = offer.getText();

        String sqlStatement = "insert into offers (name, email, text) values (?,?,?)";

        // update()는 영향을 받은 행의 수를 반환 → 1이면 성공
        return (jdbcTemplate.update(sqlStatement, new Object[]{name, email, text}) == 1);
    }

    // Offer 객체의 정보를 수정 (Update) - U
    public boolean update(Offer offer) {
        int id = offer.getId();
        String name = offer.getName();
        String email = offer.getEmail();
        String text = offer.getText();

        String sqlStatement = "update offers set name=?, email=?, text=? where id=?";
        return (jdbcTemplate.update(sqlStatement, new Object[]{name, email, text, id}) == 1);
    }

    // 특정 id를 가진 Offer 삭제 (Delete) - D
    public boolean delete(int id) {
        String sqlStatement = "delete from offers where id=?";
        return (jdbcTemplate.update(sqlStatement, new Object[]{id}) == 1);
    }
}