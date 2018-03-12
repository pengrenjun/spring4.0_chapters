package com.smart.ioc;

public class MoAttack {
	private GeLi geli;

	public void setGeli(GeLi geli) {
		this.geli = geli;
	}

	public void cityGateAsk() {
		geli.responseAsk("墨者革离");
	}
}