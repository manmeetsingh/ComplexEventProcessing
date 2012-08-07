package rules;

public class RuleA {
	public static String ruleA(){
		return("select * from A(a1=5).win:length(2) having a2>7");
	}
}

