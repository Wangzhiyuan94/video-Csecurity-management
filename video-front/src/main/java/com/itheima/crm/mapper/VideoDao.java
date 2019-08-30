package com.itheima.crm.mapper;

import java.sql.SQLException;
import java.util.List;


import org.apache.ibatis.annotations.Param;

import com.itheima.crm.pojo.Video;


public interface VideoDao {

	public List<Video> getAllVideo();
	
	/*public List<Video> findVideoProductListForPageBean(int index, int currentCount, String sortType) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = null;
		if(sortType==null){
			 sql = "select * from videos limit ?,?";
		}else{
			 sql = "select * from videos order by goodCount " +sortType+" limit ?,?";
		}
		
		return runner.query(sql, new BeanListHandler<Video>(Video.class),index,currentCount);
	}*/
	public void uploadvideo(Video video);

	public void updateGoodCount(@Param("id")String id, @Param("count")String count); 
}
