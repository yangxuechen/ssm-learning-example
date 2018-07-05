package mybatis.chapter1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.ibatis.session.SqlSession;

import mybatis.chapter1.bean.User;
import mybatis.chapter1.mapper.UserMapper;
import mybatis.chapter1.utils.SqlSessionFactoryUtil;


class Test {
	
	@org.junit.jupiter.api.Test
	void getUserTest() {
		SqlSession sqlSession=null;
		try {
			sqlSession=SqlSessionFactoryUtil.openSqlSession();
			UserMapper um=(UserMapper) sqlSession.getMapper(UserMapper.class);
			User user=null;
			user=um.getUser(1);
			System.out.println(user.getUserName()+" "+user.getPassword());
			sqlSession.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			sqlSession.rollback();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
	}
	
	@org.junit.jupiter.api.Test
	void updateUserTest() {
		SqlSession sqlSession=null;
		try {
			sqlSession=SqlSessionFactoryUtil.openSqlSession();
			UserMapper um=(UserMapper) sqlSession.getMapper(UserMapper.class);
			User user=new User();
			user.setId(1);
			user.setUserName("yangxuechen");
			user.setPassword("1");
			int n=um.updateUser(user);
			if(n>0) {
				System.out.println("seccess");
			}
			sqlSession.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			sqlSession.rollback();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
	}
	
	@org.junit.jupiter.api.Test
	void insertUserTest() {
		SqlSession sqlSession=null;
		try {
			sqlSession=SqlSessionFactoryUtil.openSqlSession();
			UserMapper um=(UserMapper) sqlSession.getMapper(UserMapper.class);
			User user=new User();
			user.setUserName("LebronJames");
			user.setPassword("1");
			int n=um.insertUser(user);
			if(n>0) {
				System.out.println("seccess");
			}
			sqlSession.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			sqlSession.rollback();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
	}
	
	@org.junit.jupiter.api.Test
	void deleteUserTest() {
		SqlSession sqlSession=null;
		try {
			sqlSession=SqlSessionFactoryUtil.openSqlSession();
			UserMapper um=(UserMapper) sqlSession.getMapper(UserMapper.class);
			int n=um.deleteUser(20);
			if(n>0) {
				System.out.println("seccess");
			}
			sqlSession.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			sqlSession.rollback();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
	}

}
