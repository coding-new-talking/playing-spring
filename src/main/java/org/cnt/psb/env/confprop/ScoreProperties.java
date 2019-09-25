package org.cnt.psb.env.confprop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * @author lixinjie
 * @since 2019-09-20
 */
//@Component
@ConfigurationProperties(prefix = "swimming")
public class ScoreProperties {

	@NestedConfigurationProperty
	private List<Score> scores = new ArrayList<>();
	
	@NestedConfigurationProperty
	private Map<String, List<Award>> awards = new HashMap<>();
	
	public List<Score> getScores() {
		return scores;
	}
	public Map<String, List<Award>> getAwards() {
		return awards;
	}

	public static class Score {
		
		private String level;
		private int lowBound;
		private int highBound;
		
		public String getLevel() {
			return level;
		}
		public void setLevel(String level) {
			this.level = level;
		}
		public int getLowBound() {
			return lowBound;
		}
		public void setLowBound(int lowBound) {
			this.lowBound = lowBound;
		}
		public int getHighBound() {
			return highBound;
		}
		public void setHighBound(int highBound) {
			this.highBound = highBound;
		}
		@Override
		public String toString() {
			return "Score [level=" + level + ", lowBound=" + lowBound + ", highBound=" + highBound + "]";
		}
	}
	
	public static class Award {
		
		private String name;
		private int count;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		@Override
		public String toString() {
			return "Award [name=" + name + ", count=" + count + "]";
		}
	}
}
