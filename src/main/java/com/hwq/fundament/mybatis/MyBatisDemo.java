package com.hwq.fundament.mybatis;


/**
 * @Auther: Administrator
 * @Date: 2021/9/6 0006 20:44
 * @Description:
 */
public class MyBatisDemo {
//     public static void main(String[] args) {
//         DataSource dataSource = getDataSource();
//         TransactionFactory transactionFactory = new JdbcTransactionFactory();
//         Environment environment = new Environment("development", transactionFactory, dataSource);
//         Configuration configuration = new Configuration(environment);
//         configuration.addMapper(BlogMapper.class);
//         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//         SqlSession sqlSession = sqlSessionFactory.openSession();
//         BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//         Blog blog = mapper.selectBlog(1);
//         System.out.println(blog);
//     }

//     private static DataSource getDataSource() {
//         DruidDataSource druidDataSource = new DruidDataSource();
//         druidDataSource.setUrl("jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf8&useSSL=false&allowMultiQueries=true&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true");
//         druidDataSource.setUsername("root");
//         druidDataSource.setPassword("123456");
//         return druidDataSource;
//     }
}
