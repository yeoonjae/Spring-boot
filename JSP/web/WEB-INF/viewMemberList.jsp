<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Driver" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: yeonjae
  Date: 2021-09-27
  Time: 오후 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 목록</title>
</head>
<body>
MemberList (회원 목록)
<table>
    <tr>
        <td>이름</td>
        <td>아이디</td>
        <td>이메일</td>
    </tr>

    <%
        // 1. JDBC 드라이버 로딩
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String jdbcDriver = "jdbc:mysql://localhost:8080/JSP?useUnicode=true&characterEncoding=utf8";
        String dbUser = "username";
        String dbPw = "pw";
        String query = "SELECT * FROM MEMBER ORDER BY MEMBERID";

        try {
            // 2. 데이터베이스 커넥션 생성
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPw);

            // 3. Statement 생성
            stmt = conn.createStatement();

            // 4. 쿼리 실행
            rs = stmt.executeQuery(query);

            // 5. 쿼리 실행 결과 출력
            while (rs.next()) {
    %>
    <tr>
        <td><%= rs.getString("NAME") %>
        </td>
        <td><%= rs.getString("MEMBERID") %>
        </td>
        <td><%= rs.getString("EMAIL") %>
        </td>
    </tr>
    <%
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 사용한 Statement 종료
            if (rs != null) { try {rs.close();} catch (SQLException e) {  e.printStackTrace();}}
            if (stmt != null) { try {stmt.close();} catch (SQLException e) {  e.printStackTrace();}}

            //7. 커넥션 종료
            if (conn != null) { try {conn.close();} catch (SQLException e) {  e.printStackTrace();}}
            }
    %>
</table>
</body>
</html>
