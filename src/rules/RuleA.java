package rules;

public class RuleA implements Rules{
	public String getRule(){
		return("select * from A(a1=5).win:length(2) having a2>7");
	}
}

