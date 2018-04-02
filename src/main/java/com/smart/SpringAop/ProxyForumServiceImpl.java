package com.smart.SpringAop;

/*通过jdk的动态代理将检测功能代码与业务层代码进行模块化处理*/

public class ProxyForumServiceImpl implements ForumService {

	@Override
	public void removeTopic(int topicId) {
		//PerformanceMonitor.begin("com.smart.SpringAop.ForumServiceImpl.removeTopic");
		System.out.println("模拟删除Topic记录:"+topicId);
		try {
			Thread.currentThread().sleep(20);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
		//PerformanceMonitor.end();
	}

	@Override
	public void removeForum(int forumId) {
		//PerformanceMonitor.begin("com.smart.SpringAop.ForumServiceImpl.removeForum");
		System.out.println("模拟删除Forum记录:"+forumId);
		try {
			Thread.currentThread().sleep(40);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
		//PerformanceMonitor.end();
	}
}
