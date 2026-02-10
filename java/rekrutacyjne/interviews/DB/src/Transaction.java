public class Transaction {
    private Double amount;
    private String sender;
    private String receiver;

    public Transaction(String _sender, String _receiver) {
        this.receiver = _receiver;
        this.sender = _sender;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
