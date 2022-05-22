package com.hmkcode.impl;

import com.hmkcode.api.MyService;
import com.hmkcode.api.MyServiceProviderInterface;

public class MyServiceProviderImpl1 implements MyServiceProviderInterface {

	@Override
	public MyService getService() {
		return new MyServiceImpl1();
	}

}
