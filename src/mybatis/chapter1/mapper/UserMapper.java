package mybatis.chapter1.mapper;

import mybatis.chapter1.bean.User;

public interface UserMapper {
	//添加用户
	public int insertUser(User user);
    //删除用户
	public int deleteUser(int id);
}
