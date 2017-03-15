/** 
* 02-实现单例模式
* 要求：1. 能在多线程环境下运行
* 		2. 效率高
* 推荐的方法：
*		1. 利用静态构造函数
* 		2. 按需创建实例：懒汉模式
*		3. 双重校验锁
**/
public class Singleton () {
	private static Singleton singleton;

	private Singleton() {}

	public static Singleton getSingleton () {
		if (singleton == null) {
			synchronized(Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}