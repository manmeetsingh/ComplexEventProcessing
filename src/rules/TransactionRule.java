package rules;

public class TransactionRule implements Rules{

	@Override
	public String getRule() {
		return ("select A.trancId as tid,(C.timestamp-B.timestamp) as LatencyBC,(B.timestamp-A.timestamp) as LatencyAB" +
				" from eventType.ShippingDone.win:time(30 minutes)  C," +
				" eventType.PurchaseOrderRaised.win:time(30 minutes)  B," +
				" eventType.OrderCreated.win:time(30 minutes)  A" +
				" where A.trancId = B.trancId and B.trancId = C.trancId");
	}
	
}
