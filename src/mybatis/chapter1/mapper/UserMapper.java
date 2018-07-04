package mybatis.chapter1.mapper;

import java.util.List;

import mybatis.chapter1.bean.User;

public interface UserMapper {
	//添加用户
	public int insertUser(User user);
    //通过用户id删除用户
	public int deleteUser(int id);
	//更新用户信息
	public int updateUser(User user);
	//通过用户id查找用户
	public User getUser(int id);
	//查找所有用户
	public List<User> getAllUsers();
}
