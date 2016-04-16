package com.betadev.jsoncrops.object;

public class Seed {
	public int lightLevelMin = 9;
	public int lightLevelMax = Integer.MAX_VALUE;
	public int damage = 0; // TODO
	public double extraSeedChance = 0;
	public double extraEssenceDropChance = 1;

	public Seed() {};

	public Seed(int lightLevelMin, int lightLevelMax, double extraSeedChance, double extraEssenceDropChance) {
		this.lightLevelMin = lightLevelMin;
		this.lightLevelMax = lightLevelMax;
		this.extraSeedChance = extraSeedChance;
		this.extraEssenceDropChance = extraEssenceDropChance;
	}
}